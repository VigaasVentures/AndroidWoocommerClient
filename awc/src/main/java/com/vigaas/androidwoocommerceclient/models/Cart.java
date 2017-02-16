package com.vigaas.androidwoocommerceclient.models;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by damandeep on 07/02/17.
 */

public class Cart {
    private double totalPrice = 0;
    private double totalWeight = 0;
    private ArrayList<CartLine> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public void addToCart(CartLine item) {

        boolean ADDED = false;

        for(int i= 0; i<cartItems.size(); i++) {
            CartLine c = cartItems.get(i);
            if(c.getProductId() == item.getProductId()) {
                if (c.getVariationId() == item.getVariationId()) {
                    ADDED = true;
                    cartItems.set(i,item);
                    Log.d("INITAL_TPAA", ""+totalPrice);
                    totalPrice = totalPrice - (c.getPrice()*c.getQuantity()) + (item.getQuantity()*item.getPrice());
                    Log.d("FINAL_TPAA", ""+totalPrice);
                    totalWeight = totalWeight - (c.getWeight()*c.getQuantity()) + (item.getQuantity()*item.getWeight());
                    return;
                }
                else {
                    ADDED = true;
                    cartItems.add(item);
                    Log.d("INITAL_TPBB", ""+totalPrice);
                    totalPrice = totalPrice  + (item.getQuantity()*item.getPrice());
                    Log.d("FINAL_TPBB", ""+totalPrice);
                    totalWeight = totalWeight  + (item.getQuantity()*item.getWeight());
                    return;
                }
            }
        }

        if(!ADDED) {
            cartItems.add(item);
            Log.d("INITAL_TPCC", ""+totalPrice);
            totalPrice = totalPrice  + (item.getQuantity()*item.getPrice());
            Log.d("FINAL_TPCC", ""+totalPrice);

            totalWeight = totalWeight  + (item.getQuantity()*item.getWeight());
        }
    }

    public ArrayList<CartLine> getCartItems() {
        return cartItems;
    }

    public ArrayList<CartLine> updateCartItemAtPosition(CartLine item, int position) {
        Log.d("INITAL_TP11", ""+totalPrice);
        double subPrice = cartItems.get(position).getPrice()*cartItems.get(position).getQuantity();
        double addPrice = item.getQuantity()*item.getPrice();
        Log.d("11_SUB",subPrice+"");
        Log.d("11_ADD",addPrice+"");
        totalPrice = totalPrice - subPrice + addPrice;
        Log.d("FINAL_TP11", ""+totalPrice);
        totalWeight = totalWeight - (cartItems.get(position).getWeight()*cartItems.get(position).getQuantity()) + (item.getQuantity()*item.getWeight());
        cartItems.set(position,item);
        return cartItems;
    }

    public void removeFromCart(int position) {
        Log.d("INITAL_TP22", ""+totalPrice);
        double subPrice = cartItems.get(position).getPrice()*cartItems.get(position).getQuantity();
        Log.d("22_SUB",subPrice+"");
        totalPrice = totalPrice - subPrice;
        Log.d("FINAL_TP22", ""+totalPrice);
        totalWeight = totalWeight - (cartItems.get(position).getQuantity()*cartItems.get(position).getWeight());
        cartItems.remove(position);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public void clearCart() {
        cartItems.clear();
        totalPrice = 0;
        totalWeight = 0;
    }
}
