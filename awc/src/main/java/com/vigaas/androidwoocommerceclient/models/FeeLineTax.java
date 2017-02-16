package com.vigaas.androidwoocommerceclient.models;


import android.os.Parcel;
import android.os.Parcelable;

public class FeeLineTax implements Parcelable {
	private int id;
	private String total;
	private String subtotal;

	public FeeLineTax(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.id);
		dest.writeString(this.total);
		dest.writeString(this.subtotal);
	}

	protected FeeLineTax(Parcel in) {
		this.id = in.readInt();
		this.total = in.readString();
		this.subtotal = in.readString();
	}

	public static final Parcelable.Creator<FeeLineTax> CREATOR = new Parcelable.Creator<FeeLineTax>() {
		@Override
		public FeeLineTax createFromParcel(Parcel source) {
			return new FeeLineTax(source);
		}

		@Override
		public FeeLineTax[] newArray(int size) {
			return new FeeLineTax[size];
		}
	};
}
