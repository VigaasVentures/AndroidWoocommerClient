package com.vigaas.androidwoocommerceclient.interfaces;

import com.vigaas.androidwoocommerceclient.models.Error;
import com.vigaas.androidwoocommerceclient.models.Product;
import com.vigaas.androidwoocommerceclient.models.ProductCategory;

import java.util.List;

/**
 * Created by damandeep on 19/10/16.
 */

public interface ProductCategoryListResponseHandler {
    public void onSuccess(List<ProductCategory> categories, int totalPages, int currentPage);
    public void onConnectionFailure(String error, String errorDetails);
    public void onFailure(Error e);
}
