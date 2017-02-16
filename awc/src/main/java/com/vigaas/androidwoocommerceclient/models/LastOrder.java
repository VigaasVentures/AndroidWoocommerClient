package com.vigaas.androidwoocommerceclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by damandeep on 07/11/16.
 */

public class LastOrder implements Parcelable {

    private int id;
    private Date date;

    public LastOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
    }

    protected LastOrder(Parcel in) {
        this.id = in.readInt();
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
    }

    public static final Parcelable.Creator<LastOrder> CREATOR = new Parcelable.Creator<LastOrder>() {
        @Override
        public LastOrder createFromParcel(Parcel source) {
            return new LastOrder(source);
        }

        @Override
        public LastOrder[] newArray(int size) {
            return new LastOrder[size];
        }
    };
}
