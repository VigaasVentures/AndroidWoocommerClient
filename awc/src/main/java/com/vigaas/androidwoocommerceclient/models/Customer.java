package com.vigaas.androidwoocommerceclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by damandeep on 07/11/16.
 */

public class Customer implements Parcelable {

    private int id;
    @SerializedName("date_created")private Date createdAt;
    @SerializedName("date_modified")private Date updatedAt;
    private String email;
    @SerializedName("first_name")private String firstName;
    @SerializedName("last_name")private String lastName;
    private String username;
    @SerializedName("last_order")private LastOrder lastOrder;
    @SerializedName("orders_count")private int ordersCount;
    @SerializedName("total_spent")private String totalSpent;
    @SerializedName("avatar_url")private String avatar;
    private BillingAddress billing;
    private ShippingAddress shipping;

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LastOrder getLastOrder() {
        return lastOrder;
    }

    public void setLastOrder(LastOrder lastOrder) {
        this.lastOrder = lastOrder;
    }

    public int getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
    }

    public String getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(String totalSpent) {
        this.totalSpent = totalSpent;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public BillingAddress getBilling() {
        return billing;
    }

    public void setBilling(BillingAddress billing) {
        this.billing = billing;
    }

    public ShippingAddress getShipping() {
        return shipping;
    }

    public void setShipping(ShippingAddress shipping) {
        this.shipping = shipping;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeLong(this.createdAt != null ? this.createdAt.getTime() : -1);
        dest.writeLong(this.updatedAt != null ? this.updatedAt.getTime() : -1);
        dest.writeString(this.email);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.username);
        dest.writeParcelable(this.lastOrder, flags);
        dest.writeInt(this.ordersCount);
        dest.writeString(this.totalSpent);
        dest.writeString(this.avatar);
        dest.writeParcelable(this.billing, flags);
        dest.writeParcelable(this.shipping, flags);
    }

    protected Customer(Parcel in) {
        this.id = in.readInt();
        long tmpCreatedAt = in.readLong();
        this.createdAt = tmpCreatedAt == -1 ? null : new Date(tmpCreatedAt);
        long tmpUpdatedAt = in.readLong();
        this.updatedAt = tmpUpdatedAt == -1 ? null : new Date(tmpUpdatedAt);
        this.email = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.username = in.readString();
        this.lastOrder = in.readParcelable(LastOrder.class.getClassLoader());
        this.ordersCount = in.readInt();
        this.totalSpent = in.readString();
        this.avatar = in.readString();
        this.billing = in.readParcelable(BillingAddress.class.getClassLoader());
        this.shipping = in.readParcelable(ShippingAddress.class.getClassLoader());
    }

    public static final Parcelable.Creator<Customer> CREATOR = new Parcelable.Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel source) {
            return new Customer(source);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };
}
