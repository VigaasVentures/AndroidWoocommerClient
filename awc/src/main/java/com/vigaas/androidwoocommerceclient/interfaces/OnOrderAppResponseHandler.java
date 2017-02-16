package com.vigaas.androidwoocommerceclient.interfaces;

import com.vigaas.androidwoocommerceclient.models.Error;
import com.vigaas.androidwoocommerceclient.models.Order;

/**
 * Created by daman on 9/2/17.
 */

public interface OnOrderAppResponseHandler {

    void onSuccess(Order order);
    void onError(Error error);
    void onConnectionFailure(String error, String errorDetails);
}
