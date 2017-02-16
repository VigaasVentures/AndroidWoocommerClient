package com.vigaas.androidwoocommerceclient.models;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TaxLine implements Parcelable {

	private int id;
	@SerializedName("rate_code")private String rateCode;
	@SerializedName("rate_id")private int rateId;
	private String label;
	private boolean compound;
	@SerializedName("tax_total")private String taxTotal;
	@SerializedName("shipping_tax_total")private String shippingTaxTotal;

	public TaxLine() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRateCode() {
		return rateCode;
	}

	public void setRateCode(String rateCode) {
		this.rateCode = rateCode;
	}

	public int getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isCompound() {
		return compound;
	}

	public void setCompound(boolean compound) {
		this.compound = compound;
	}

	public String getTaxTotal() {
		return taxTotal;
	}

	public void setTaxTotal(String taxTotal) {
		this.taxTotal = taxTotal;
	}

	public String getShippingTaxTotal() {
		return shippingTaxTotal;
	}

	public void setShippingTaxTotal(String shippingTaxTotal) {
		this.shippingTaxTotal = shippingTaxTotal;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.id);
		dest.writeString(this.rateCode);
		dest.writeInt(this.rateId);
		dest.writeString(this.label);
		dest.writeByte(this.compound ? (byte) 1 : (byte) 0);
		dest.writeString(this.taxTotal);
		dest.writeString(this.shippingTaxTotal);
	}

	protected TaxLine(Parcel in) {
		this.id = in.readInt();
		this.rateCode = in.readString();
		this.rateId = in.readInt();
		this.label = in.readString();
		this.compound = in.readByte() != 0;
		this.taxTotal = in.readString();
		this.shippingTaxTotal = in.readString();
	}

	public static final Parcelable.Creator<TaxLine> CREATOR = new Parcelable.Creator<TaxLine>() {
		@Override
		public TaxLine createFromParcel(Parcel source) {
			return new TaxLine(source);
		}

		@Override
		public TaxLine[] newArray(int size) {
			return new TaxLine[size];
		}
	};
}
