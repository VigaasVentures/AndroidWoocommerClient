package com.vigaas.androidwoocommerceclient.interfaces;

import com.vigaas.androidwoocommerceclient.models.Error;
import com.vigaas.androidwoocommerceclient.models.Product;

import java.util.List;

/**
 * Created by damandeep on 19/10/16.
 */

public interface ProductListResponseHandler {
    public void onSuccess(List<Product> products,int totalPages, int currentPage);
    public void onConnectionFailure(String error, String errorDetails);
    public void onFailure(Error e);
}
