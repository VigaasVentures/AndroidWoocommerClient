package com.vigaas.androidwoocommerceclient.interfaces;

import com.vigaas.androidwoocommerceclient.models.Customer;
import com.vigaas.androidwoocommerceclient.models.Error;

/**
 * Created by daman on 27/1/17.
 */

public interface CustomerDetailsResponseHandler {

    void onSuccess(String custJson, Customer customer);
    void onError(Error error);
    void onConnectionFailure(String error, String errorDetails);

}
