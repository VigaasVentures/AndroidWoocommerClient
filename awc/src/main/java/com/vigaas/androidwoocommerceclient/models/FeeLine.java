package com.vigaas.androidwoocommerceclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class FeeLine implements Parcelable {

	private int id;
	private String name;
	@SerializedName("tax_class")private String taxClass;
	@SerializedName("tax_status")private String taxStatus;
	private String total;
	@SerializedName("total_tax")private String totalTax;
	private List<FeeLineTax> taxes;

	
	public FeeLine() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxClass() {
		return taxClass;
	}

	public void setTaxClass(String taxClass) {
		this.taxClass = taxClass;
	}

	public String getTaxStatus() {
		return taxStatus;
	}

	public void setTaxStatus(String taxStatus) {
		this.taxStatus = taxStatus;
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
		dest.writeString(this.name);
		dest.writeString(this.taxClass);
		dest.writeString(this.taxStatus);
		dest.writeString(this.total);
		dest.writeString(this.totalTax);
		dest.writeTypedList(this.taxes);
	}

	protected FeeLine(Parcel in) {
		this.id = in.readInt();
		this.name = in.readString();
		this.taxClass = in.readString();
		this.taxStatus = in.readString();
		this.total = in.readString();
		this.totalTax = in.readString();
		this.taxes = in.createTypedArrayList(FeeLineTax.CREATOR);
	}

	public static final Parcelable.Creator<FeeLine> CREATOR = new Parcelable.Creator<FeeLine>() {
		@Override
		public FeeLine createFromParcel(Parcel source) {
			return new FeeLine(source);
		}

		@Override
		public FeeLine[] newArray(int size) {
			return new FeeLine[size];
		}
	};
}
