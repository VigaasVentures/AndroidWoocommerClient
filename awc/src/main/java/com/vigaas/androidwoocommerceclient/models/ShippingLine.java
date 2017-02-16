package com.vigaas.androidwoocommerceclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class ShippingLine implements Parcelable {

	private int id;
	@SerializedName("method_title")private String methodTitle;
	@SerializedName("method_id")private String methodId;
	private String total;
	@SerializedName("total_tax")private String totalTax;
	private List<FeeLineTax> taxes;

	
	public ShippingLine() {}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMethodTitle() {
		return methodTitle;
	}

	public void setMethodTitle(String methodTitle) {
		this.methodTitle = methodTitle;
	}

	public String getMethodId() {
		return methodId;
	}

	public void setMethodId(String methodId) {
		this.methodId = methodId;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(String totalTax) {
		this.totalTax = totalTax;
	}

	public List<FeeLineTax> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<FeeLineTax> taxes) {
		this.taxes = taxes;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.id);
		dest.writeString(this.methodTitle);
		dest.writeString(this.methodId);
		dest.writeString(this.total);
		dest.writeString(this.totalTax);
		dest.writeTypedList(this.taxes);
	}

	protected ShippingLine(Parcel in) {
		this.id = in.readInt();
		this.methodTitle = in.readString();
		this.methodId = in.readString();
		this.total = in.readString();
		this.totalTax = in.readString();
		this.taxes = in.createTypedArrayList(FeeLineTax.CREATOR);
	}

	public static final Parcelable.Creator<ShippingLine> CREATOR = new Parcelable.Creator<ShippingLine>() {
		@Override
		public ShippingLine createFromParcel(Parcel source) {
			return new ShippingLine(source);
		}

		@Override
		public ShippingLine[] newArray(int size) {
			return new ShippingLine[size];
		}
	};
}
