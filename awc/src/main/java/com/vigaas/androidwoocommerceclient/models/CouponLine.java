package com.vigaas.androidwoocommerceclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by damandeep on 08/02/17.
 */

public class CouponLine implements Parcelable {
    private int id;
    private String code;
    private String discount;
    @SerializedName("discount_tax")private String discountTax;

    public CouponLine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscountTax() {
        return discountTax;
    }

    public void setDiscountTax(String discountTax) {
        this.discountTax = discountTax;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.code);
        dest.writeString(this.discount);
        dest.writeString(this.discountTax);
    }

    protected CouponLine(Parcel in) {
        this.id = in.readInt();
        this.code = in.readString();
        this.discount = in.readString();
        this.discountTax = in.readString();
    }

    public static final Parcelable.Creator<CouponLine> CREATOR = new Parcelable.Creator<CouponLine>() {
        @Override
        public CouponLine createFromParcel(Parcel source) {
            return new CouponLine(source);
        }

        @Override
        public CouponLine[] newArray(int size) {
            return new CouponLine[size];
        }
    };
}
