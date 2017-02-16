package com.vigaas.androidwoocommerceclient.interfaces;

import com.vigaas.androidwoocommerceclient.models.CartLine;

import java.util.ArrayList;

/**
 * Created by damandeep on 07/02/17.
 */

public interface OnCartItemsChangeListener {
    void onCartUpdate(ArrayList<CartLine> items);
}
