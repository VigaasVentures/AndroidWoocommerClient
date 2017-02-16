package com.vigaas.androidwoocommerceclient.models;


import android.os.Parcel;
import android.os.Parcelable;

public class TaxesMeta implements Parcelable {
	private int id;
	private double subtotal;
	private double total;
	
	public TaxesMeta() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.id);
		dest.writeDouble(this.subtotal);
		dest.writeDouble(this.total);
	}

	protected TaxesMeta(Parcel in) {
		this.id = in.readInt();
		this.subtotal = in.readDouble();
		this.total = in.readDouble();
	}

	public static final Parcelable.Creator<TaxesMeta> CREATOR = new Parcelable.Creator<TaxesMeta>() {
		@Override
		public TaxesMeta createFromParcel(Parcel source) {
			return new TaxesMeta(source);
		}

		@Override
		public TaxesMeta[] newArray(int size) {
			return new TaxesMeta[size];
		}
	};
}
