package com.vigaas.androidwoocommerceclient.models;


import android.os.Parcel;
import android.os.Parcelable;

public class RefundLine implements Parcelable {

	private int id;
	private String reason;
	private String total;

	public RefundLine() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.id);
		dest.writeString(this.reason);
		dest.writeString(this.total);
	}

	protected RefundLine(Parcel in) {
		this.id = in.readInt();
		this.reason = in.readString();
		this.total = in.readString();
	}

	public static final Parcelable.Creator<RefundLine> CREATOR = new Parcelable.Creator<RefundLine>() {
		@Override
		public RefundLine createFromParcel(Parcel source) {
			return new RefundLine(source);
		}

		@Override
		public RefundLine[] newArray(int size) {
			return new RefundLine[size];
		}
	};
}
