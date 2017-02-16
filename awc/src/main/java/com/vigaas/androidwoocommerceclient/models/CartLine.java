package com.vigaas.androidwoocommerceclient.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.List;

import static android.R.attr.id;

/**
 * Created by damandeep on 07/02/17.
 */

public class CartLine implements Parcelable {
    private int productId;
    private int variationId;
    private String SKU;
    private int quantity;
    private double price;
    private double weight;
    private String productName;
    private List<Attribute> attributeList;
    private String imgUrl;

    public CartLine() {
    }

    public CartLine(@NonNull int productId, int variationId, String SKU, @NonNull int quantity, @NonNull double price, @NonNull double weight, @NonNull String productName, @NonNull String imgUrl, List<Attribute> attributeList) {
        this.productId = productId;
        this.variationId = variationId;
        this.SKU = SKU;
        this.quantity = quantity;
        this.price = price;
        this.weight = weight;
        this.productName = productName;
        this.imgUrl = imgUrl;
        this.attributeList = attributeList;
    }

    public CartLine(@NonNull int productId, @NonNull int quantity, @NonNull double price, @NonNull double weight, @NonNull String productName, @NonNull String imgUrl) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.weight = weight;
        this.productName = productName;
        this.imgUrl = imgUrl;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getVariationId() {
        return variationId;
    }

    public void setVariationId(int variationId) {
        this.variationId = variationId;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Attribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.productId);
        dest.writeInt(this.variationId);
        dest.writeString(this.SKU);
        dest.writeInt(this.quantity);
        dest.writeDouble(this.price);
        dest.writeDouble(this.weight);
        dest.writeString(this.productName);
        dest.writeTypedList(this.attributeList);
        dest.writeString(this.imgUrl);
    }

    protected CartLine(Parcel in) {
        this.productId = in.readInt();
        this.variationId = in.readInt();
        this.SKU = in.readString();
        this.quantity = in.readInt();
        this.price = in.readDouble();
        this.weight = in.readDouble();
        this.productName = in.readString();
        this.attributeList = in.createTypedArrayList(Attribute.CREATOR);
        this.imgUrl = in.readString();
    }

    public static final Creator<CartLine> CREATOR = new Creator<CartLine>() {
        @Override
        public CartLine createFromParcel(Parcel source) {
            return new CartLine(source);
        }

        @Override
        public CartLine[] newArray(int size) {
            return new CartLine[size];
        }
    };
}
