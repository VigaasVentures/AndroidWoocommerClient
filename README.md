# Android Woocommerce Client [![](https://jitpack.io/v/VigaasVentures/AndroidWoocommerClient.svg)](https://jitpack.io/#VigaasVentures/AndroidWoocommerClient)

This is Android Client for making a customer app from Woocommerce.

## USAGE
To use this lib via gradle just have to do 2 steps
```
allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
  ```
  ```
  dependencies {
            compile 'com.github.VigaasVentures:AndroidWoocommerClient:0.0.1'
    }
  ```
The above steps will include the library to your project.

**Note** You need to generate API Keys in Woocommerce before this 


Now you need to initialise it.

Extend your `Application` and include following code
  
```Java
  @Override
    public void onCreate() {
        WoocommerceClient.setDefault(getResources().getString(R.string.shop_consumer_key),getResources().getString(R.string.shop_consumer_secret),"https://ambala.webdemos.cf",getApplicationContext());
        super.onCreate();

        WoocommerceClient.setCustomerAuthType(WoocommerceClient.CustomerAuthType.BASIC_AUTHENTICATION);
    }
```

Now you can use the functions in `WoocommerceClient`
e.g To get Top Level Categories
   
```Java
    ProductCategoryListParameters mProductCategoryListParameters = new ProductCategoryListParameters();
        mProductCategoryListParameters.setPerPage(100);
        mProductCategoryListParameters.setOrderBy(ProductCategoryListParameters.OrderBy.ID);
        WoocommerceClient.getProductCategoriesList(mProductCategoryListParameters, new ProductCategoryListResponseHandler() {
            @Override
            public void onSuccess(List<ProductCategory> categories, int totalPages, int currentPage) {
                
            }

            @Override
            public void onConnectionFailure(String error, String errorDetails) {
                
            }

            @Override
            public void onFailure(Error e) {
                
            }
        });
```
Check the demos app for detialed usage
