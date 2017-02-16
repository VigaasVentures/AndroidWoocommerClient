package com.vigaas.androidwoocommerceclient;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.OkHttpResponseAndStringRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.vigaas.androidwoocommerceclient.interfaces.CustomerDetailsResponseHandler;
import com.vigaas.androidwoocommerceclient.interfaces.LoginResponseHandler;
import com.vigaas.androidwoocommerceclient.interfaces.OnCartItemsChangeListener;
import com.vigaas.androidwoocommerceclient.interfaces.OnOrderAppResponseHandler;
import com.vigaas.androidwoocommerceclient.interfaces.OrdersListResponseHandler;
import com.vigaas.androidwoocommerceclient.interfaces.ProductCategoryListResponseHandler;
import com.vigaas.androidwoocommerceclient.interfaces.ProductListResponseHandler;
import com.vigaas.androidwoocommerceclient.models.Cart;
import com.vigaas.androidwoocommerceclient.models.CartLine;
import com.vigaas.androidwoocommerceclient.models.Customer;
import com.vigaas.androidwoocommerceclient.models.Error;
import com.vigaas.androidwoocommerceclient.models.Order;
import com.vigaas.androidwoocommerceclient.models.Product;
import com.vigaas.androidwoocommerceclient.models.ProductCategory;
import com.vigaas.androidwoocommerceclient.requestparams.OrdersListParameters;
import com.vigaas.androidwoocommerceclient.requestparams.ProductCategoryListParameters;
import com.vigaas.androidwoocommerceclient.requestparams.ProductListParameters;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

import static android.R.attr.order;

/**
 * Created by damandeep on 19/10/16.
 */

public class WoocommerceClient {

    protected static String mConsumerKey, mConsumerSecret, mBaseUrl;
    private static Context mContext;

    public static boolean DEBUG = false;

    private static CustomerAuthType authType;

    /*private static AuthorizationFlow flow = null;*/

    private static Cart cart;

    private static OnCartItemsChangeListener cartItemsChangeListener;

    public enum CustomerAuthType {
        BASIC_AUTHENTICATION,
        OAUTH1
    }

    private WoocommerceClient() {

    }

    public static void setDefault(String consumerKey, String consumerSecret, String baseUrl, Context applicationContext) {
        mConsumerKey = consumerKey;
        mConsumerSecret = consumerSecret;
        mBaseUrl = baseUrl;
        mContext = applicationContext;
        Log.d("Settings Desfults", "Set URL: "+baseUrl);
        cart = new Cart();

        SharedPreferences sp = mContext.getSharedPreferences("cart",Context.MODE_PRIVATE);
        Gson gson = new Gson();
        if(sp.getString("cart", "").contains("{")) {
            cart = gson.fromJson(sp.getString("cart", ""), Cart.class);
        }
//        OkHttpClient mOkHttpClient = new OkHttpClient.Builder().authenticator(new Authenticator() {
//            @Override
//            public Request authenticate(Route route, Response response) throws IOException {
//                String credentials = Credentials.basic(mConsumerKey,mConsumerSecret);
//                return response.request().newBuilder().header("Authorization",credentials).build();
//            }
//        }).build();

        AndroidNetworking.initialize(applicationContext);
    }

    public static void setCustomerAuthType(CustomerAuthType type) {
        authType = type;
    }

    /*public static void setupOAuthClient(String clientKey, String clientSecret) {
        if(authType == CustomerAuthType.OAUTH1) {
            SharedPreferencesCredentialStore credentialStore = new SharedPreferencesCredentialStore(mContext, "woocommerce_auth", new JacksonFactory());
            AuthorizationFlow.Builder builder = new AuthorizationFlow.Builder(BearerToken.authorizationHeaderAccessMethod(),
                    AndroidHttp.newCompatibleTransport(),
                    new JacksonFactory(),
                    new GenericUrl(mBaseUrl + "/oauth1/access"),
                    new ClientParametersAuthentication(clientKey, clientSecret),
                    clientKey,
                    mBaseUrl + "/oauth1/authorize");
            builder.setTemporaryTokenRequestUrl(mBaseUrl + "/oauth1/request");
            builder.setCredentialStore(credentialStore);
            flow = builder.build();
        }

    }*/

    public static void setCartItemsChangeListener(OnCartItemsChangeListener listener) {
        cartItemsChangeListener = listener;
    }


    public static void getProductsList(final ProductListParameters productListParameters, final ProductListResponseHandler responseHandler) {
        AndroidNetworking.get(mBaseUrl+"/wp-json/wc/v1/products")
                .addQueryParameter("consumer_key",mConsumerKey)
                .addQueryParameter("consumer_secret",mConsumerSecret)
                .setTag("productlist")
                .addQueryParameter(productListParameters.getParams())
                .setPriority(Priority.HIGH)
                .build()
                .getAsOkHttpResponseAndString(new OkHttpResponseAndStringRequestListener() {
                    @Override
                    public void onResponse(Response okHttpResponse, String response) {
//                        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
//                        Gson gson = new Gson();
//                        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                            @Override
                            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                                try {
                                    return dateFormat.parse(json.getAsString());
                                }
                                catch (ParseException e) {
                                    return null;
                                }
                            }
                        });

                        Gson gson = gsonBuilder.create();

                        Type listType = new TypeToken<ArrayList<Product>>(){}.getType();
                        try {
                            List<Product> mProductList = gson.fromJson(response,listType);
                            int total = Integer.parseInt(okHttpResponse.header("X-WP-TotalPages"));
                            responseHandler.onSuccess(mProductList,total,productListParameters.getPage());
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            Error error = gson.fromJson(response,Error.class);
                            responseHandler.onFailure(error);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        if(DEBUG) {
                            Log.d("CONNECTION_ERROR", "Code: " + anError.getErrorCode());
                        }
                        responseHandler.onConnectionFailure(anError.getErrorBody(), anError.getErrorDetail());
                    }
                });
    }



    public static void setDebug(boolean debug) {
        DEBUG = debug;
    }


    public static void getProductCategoriesList(final ProductCategoryListParameters parameters, final ProductCategoryListResponseHandler responseHandler) {
        AndroidNetworking.get(mBaseUrl+"/wp-json/wc/v1/products/categories")
                .addQueryParameter("consumer_key",mConsumerKey)
                .addQueryParameter("consumer_secret",mConsumerSecret)
                .setTag("productcategorylist")
                .addQueryParameter(parameters.getParams())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsOkHttpResponseAndString(new OkHttpResponseAndStringRequestListener() {
                    @Override
                    public void onResponse(Response okHttpResponse, String response) {
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                            @Override
                            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                                try {
                                    return dateFormat.parse(json.getAsString());
                                }
                                catch (ParseException e) {
                                    return null;
                                }
                            }
                        });

                        Gson gson = gsonBuilder.create();

                        Type listType = new TypeToken<ArrayList<ProductCategory>>(){}.getType();
                        try {
                            List<ProductCategory> mProductCategoryList = gson.fromJson(response,listType);
                            int total = Integer.parseInt(okHttpResponse.header("X-WP-TotalPages"));
                            responseHandler.onSuccess(mProductCategoryList,total,parameters.getPage());
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            Error error = gson.fromJson(response,Error.class);
                            responseHandler.onFailure(error);
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        responseHandler.onConnectionFailure(anError.getErrorBody(),anError.getErrorDetail());
                    }
                });
    }


    /*public static void loginUser(final String callback, FragmentManager fragmentManager) {
        if(authType == CustomerAuthType.OAUTH1 && flow != null) {
            AuthorizationUIController controller = new DialogFragmentController(fragmentManager) {
                @Override
                public boolean isJavascriptEnabledForWebView() {
                    return true;
                }

                @Override
                public boolean disableWebViewCache() {
                    return false;
                }

                @Override
                public boolean removePreviousCookie() {
                    return false;
                }

                @Override
                public String getRedirectUri() throws IOException {
                    return "http://localhost/" + callback;
                }
            };
            OAuthManager oAuthManager = new OAuthManager(flow, controller);
            //            Credential credential = oAuthManager.authorize10a("userId",null,null).getResult();
            oAuthManager.authorize10a("userId", new OAuthManager.OAuthCallback<Credential>() {
                @Override
                public void run(OAuthManager.OAuthFuture<Credential> future) {
                    try {
                        Log.d("LOGIN", future.getResult().getAccessToken());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }, new Handler());
        }
    }*/

    public static void loginUser(final String username, final String password, final LoginResponseHandler responseHandler) {
        if(authType == CustomerAuthType.BASIC_AUTHENTICATION) {

            OkHttpClient mOkHttpClient = new OkHttpClient.Builder().authenticator(new Authenticator() {
                @Override
                public Request authenticate(Route route, Response response) throws IOException {
                    String credentials = Credentials.basic(username,password);
                    return response.request().newBuilder().header("Authorization",credentials).build();
                }
            }).build();

            AndroidNetworking.get(mBaseUrl+"/wp-json/wp/v2/users/me")
                    .setOkHttpClient(mOkHttpClient)
                    .getResponseOnlyFromNetwork()
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                responseHandler.onLoginSucess(response.getInt("id"),response.getString("name"),response.getJSONObject("avatar_urls").getString("96"));
                            } catch (JSONException e) {
                                Log.d("AWC_LOGINUSER-IO",e.toString());
                                responseHandler.onLoginError();
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(ANError anError) {
                            Log.d("AWC_LOGINUSER",anError.getErrorDetail());
                            responseHandler.onLoginError();
                        }
                    });
                    /*.getAsOkHttpResponse(new OkHttpResponseListener() {
                        @Override
                        public void onResponse(final Response response) {
                            if(response.code() == 200) {
                                AsyncTask.execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            JSONObject obj = new JSONObject(response.body().string());
                                            Looper.prepare();
                                            responseHandler.onLoginSucess(obj.getInt("id"),obj.getString("name"),obj.getJSONObject("avatar_urls").getString("96"));
                                        } catch (JSONException e) {
                                            Log.d("AWC_LOGINUSER-JSON",e.toString());
                                            responseHandler.onLoginError();
                                            e.printStackTrace();

                                        } catch (IOException e) {
                                            Log.d("AWC_LOGINUSER-IO",e.toString());
                                            responseHandler.onLoginError();
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                            else {
                                responseHandler.onLoginError();
                            }
                        }

                        @Override
                        public void onError(ANError anError) {
                            Log.d("AWC_LOGINUSER",anError.getErrorBody());
                            responseHandler.onLoginError();
                        }
                    });*/

        }
        else {
            throw new RuntimeException("Cannot use this function wihtout Basic Authentication");
        }
    }





    public static void getCustomerDetails(String custId, final CustomerDetailsResponseHandler responseHandler) {
        AndroidNetworking.get(mBaseUrl+"/wp-json/wc/v1/customers/"+custId)
                .addQueryParameter("consumer_key",mConsumerKey)
                .addQueryParameter("consumer_secret",mConsumerSecret)
                .setTag("get_cust_details")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsOkHttpResponseAndString(new OkHttpResponseAndStringRequestListener() {
                    @Override
                    public void onResponse(Response okHttpResponse, String response) {
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                            @Override
                            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                                try {
                                    return dateFormat.parse(json.getAsString());
                                }
                                catch (ParseException e) {
                                    return null;
                                }
                            }
                        });

                        Gson gson = gsonBuilder.create();
                        try {
                            Customer c = gson.fromJson(response,Customer.class);
                            responseHandler.onSuccess(response,c);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            Error error = gson.fromJson(response,Error.class);
                            responseHandler.onError(error);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        responseHandler.onConnectionFailure(anError.getErrorBody(),anError.getErrorDetail());
                    }
                });
    }

    public static void addOrder(final Order order, final OnOrderAppResponseHandler responseHandler) throws JSONException {

        Gson gson = new Gson();
        String jj = gson.toJson(order);
        Log.d("SENDING_DATA",jj);
        JSONObject object = new JSONObject(jj);
        AndroidNetworking.post(mBaseUrl+"/wp-json/wc/v1/orders")
                .addQueryParameter("consumer_key",mConsumerKey)
                .addQueryParameter("consumer_secret",mConsumerSecret)
                .addJSONObjectBody(object)
                .setTag("orders_add")
                .setPriority(Priority.HIGH)
                .build()
                .getAsOkHttpResponseAndString(new OkHttpResponseAndStringRequestListener() {
                    @Override
                    public void onResponse(Response okHttpResponse, String response) {
                        Log.d("RESP",response);
//                        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
//                        Gson gson = new Gson();
//                        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                            @Override
                            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                                try {
                                    return dateFormat.parse(json.getAsString());
                                }
                                catch (ParseException e) {
                                    return null;
                                }
                            }
                        });

                        Gson gson = gsonBuilder.create();


                        try {
                            Order oo = gson.fromJson(response,Order.class);
                            responseHandler.onSuccess(oo);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            Error error = gson.fromJson(response,Error.class);
                            responseHandler.onError(error);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        if(DEBUG) {
                            Log.d("CONNECTION_ERROR", "Code: " + anError.getErrorCode());
                        }
                        responseHandler.onConnectionFailure(anError.getErrorBody(), anError.getErrorDetail());
                    }
                });
    }

    public static void setPaid(int orderId, String paymentMethod, String paymentMethodTitle, String transId, final OnOrderAppResponseHandler responseHandler) throws JSONException {

        JSONObject object = new JSONObject();
        object.put("set_paid",true);
        object.put("payment_method",paymentMethod);
        object.put("payment_method_title",paymentMethodTitle);
        object.put("transaction_id",transId);
        AndroidNetworking.put(mBaseUrl+"/wp-json/wc/v1/orders/"+orderId)
                .addQueryParameter("consumer_key",mConsumerKey)
                .addQueryParameter("consumer_secret",mConsumerSecret)
                .addJSONObjectBody(object)
                .setTag("orders_update")
                .setPriority(Priority.HIGH)
                .build()
                .getAsOkHttpResponseAndString(new OkHttpResponseAndStringRequestListener() {
                    @Override
                    public void onResponse(Response okHttpResponse, String response) {
                        Log.d("RESP",response);
//                        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
//                        Gson gson = new Gson();
//                        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                            @Override
                            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                                try {
                                    return dateFormat.parse(json.getAsString());
                                }
                                catch (ParseException e) {
                                    return null;
                                }
                            }
                        });

                        Gson gson = gsonBuilder.create();


                        try {
                            Order oo = gson.fromJson(response,Order.class);
                            responseHandler.onSuccess(oo);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            Error error = gson.fromJson(response,Error.class);
                            responseHandler.onError(error);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        if(DEBUG) {
                            Log.d("CONNECTION_ERROR", "Code: " + anError.getErrorCode());
                        }
                        responseHandler.onConnectionFailure(anError.getErrorBody(), anError.getErrorDetail());
                    }
                });

        JSONObject object1 = new JSONObject();
        object1.put("note","PayPal Braintree charge complete (Charge ID: "+transId+")");

        AndroidNetworking.post(mBaseUrl+"/wp-json/wc/v1/orders/"+orderId+"/notes")
                .addQueryParameter("consumer_key",mConsumerKey)
                .addQueryParameter("consumer_secret",mConsumerSecret)
                .addJSONObjectBody(object1)
                .setTag("orders_note_add")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }


    public static void getOrder(int orderId, final OnOrderAppResponseHandler responseHandler) {


        AndroidNetworking.get(mBaseUrl+"/wp-json/wc/v1/orders/"+orderId)
                .addQueryParameter("consumer_key",mConsumerKey)
                .addQueryParameter("consumer_secret",mConsumerSecret)
                .setTag("orders_update")
                .setPriority(Priority.HIGH)
                .build()
                .getAsOkHttpResponseAndString(new OkHttpResponseAndStringRequestListener() {
                    @Override
                    public void onResponse(Response okHttpResponse, String response) {
                        Log.d("RESP",response);
//                        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
//                        Gson gson = new Gson();
//                        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                            @Override
                            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                                try {
                                    return dateFormat.parse(json.getAsString());
                                }
                                catch (ParseException e) {
                                    return null;
                                }
                            }
                        });

                        Gson gson = gsonBuilder.create();


                        try {
                            Order oo = gson.fromJson(response,Order.class);
                            responseHandler.onSuccess(oo);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            Error error = gson.fromJson(response,Error.class);
                            responseHandler.onError(error);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        if(DEBUG) {
                            Log.d("CONNECTION_ERROR", "Code: " + anError.getErrorCode());
                        }
                        responseHandler.onConnectionFailure(anError.getErrorBody(), anError.getErrorDetail());
                    }
                });
    }



    public static void getOrdersList(final OrdersListParameters ordersListParameters, final OrdersListResponseHandler responseHandler) {
        AndroidNetworking.get(mBaseUrl+"/wp-json/wc/v1/orders")
                .addQueryParameter("consumer_key",mConsumerKey)
                .addQueryParameter("consumer_secret",mConsumerSecret)
                .addQueryParameter(ordersListParameters.getParams())
                .setTag("orderslist")
                .setPriority(Priority.HIGH)
                .build()
                .getAsOkHttpResponseAndString(new OkHttpResponseAndStringRequestListener() {
                    @Override
                    public void onResponse(Response okHttpResponse, String response) {
                        Log.d("RESP",response);
//                        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
//                        Gson gson = new Gson();
//                        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                            @Override
                            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                                try {
                                    return dateFormat.parse(json.getAsString());
                                }
                                catch (ParseException e) {
                                    return null;
                                }
                            }
                        });

                        Gson gson = gsonBuilder.create();

                        Type listType = new TypeToken<ArrayList<Order>>(){}.getType();
                        try {
                            List<Order> mOrderList = gson.fromJson(response,listType);
                            int total = Integer.parseInt(okHttpResponse.header("X-WP-TotalPages"));
                            Log.d("TOTAL","PAGES: "+total);
                            responseHandler.onSuccess(mOrderList,total,ordersListParameters.getPage());
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            Error error = gson.fromJson(response,Error.class);
                            responseHandler.onFailure(error);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        if(DEBUG) {
                            Log.d("CONNECTION_ERROR", "Code: " + anError.getErrorCode());
                        }
                        responseHandler.onConnectionFailure(anError.getErrorBody(), anError.getErrorDetail());
                    }
                });
    }


    public static void addItemToCart(CartLine item) {
        cart.addToCart(item);
        if(cartItemsChangeListener != null) {
            cartItemsChangeListener.onCartUpdate(cart.getCartItems());
        }
        SharedPreferences sp = mContext.getSharedPreferences("cart",Context.MODE_PRIVATE);
        SharedPreferences.Editor spEditor = sp.edit();
        Gson gson = new Gson();
        String cartJson = gson.toJson(cart);
        spEditor.putString("cart",cartJson);
        spEditor.apply();

    }

    public static void removeFromCart(int position) {
        cart.removeFromCart(position);
        if(cartItemsChangeListener != null) {
            cartItemsChangeListener.onCartUpdate(cart.getCartItems());
        }
        SharedPreferences sp = mContext.getSharedPreferences("cart",Context.MODE_PRIVATE);
        SharedPreferences.Editor spEditor = sp.edit();
        Gson gson = new Gson();
        String cartJson = gson.toJson(cart);
        spEditor.putString("cart",cartJson);
        spEditor.apply();
    }

    public static int getCartItemsCount() {
        return cart.getCartItems().size();
    }

    public static ArrayList<CartLine> getCartItems() {
        return cart.getCartItems();
    }

    public static ArrayList<CartLine> updateCartItemAtPosition(CartLine item, int position) {
        ArrayList<CartLine> c = cart.updateCartItemAtPosition(item,position);
        if(cartItemsChangeListener != null) {
            cartItemsChangeListener.onCartUpdate(cart.getCartItems());
        }
        SharedPreferences sp = mContext.getSharedPreferences("cart",Context.MODE_PRIVATE);
        SharedPreferences.Editor spEditor = sp.edit();
        Gson gson = new Gson();
        String cartJson = gson.toJson(cart);
        spEditor.putString("cart",cartJson);
        spEditor.apply();
        return c;
    }

    public static double getTotalPriceFromCart() {
        return cart.getTotalPrice();
    }

    public static double getTotalWeightFromCart() {
        return cart.getTotalWeight();
    }

    public static void clearCart() {
        cart.clearCart();
        if(cartItemsChangeListener != null) {
            cartItemsChangeListener.onCartUpdate(cart.getCartItems());
        }
    }

}
