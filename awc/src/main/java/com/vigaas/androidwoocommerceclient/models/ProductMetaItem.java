package com.vigaas.androidwoocommerceclient.models;


import android.os.Parcel;
import android.os.Parcelable;

public class ProductMetaItem implements Parcelable {

	private String key;
	private String label;
	private String value;
	
	public ProductMetaItem() {}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.key);
		dest.writeString(this.label);
		dest.writeString(this.value);
	}

	protected ProductMetaItem(Parcel in) {
		this.key = in.readString();
		this.label = in.readString();
		this.value = in.readString();
	}

	public static final Parcelable.Creator<ProductMetaItem> CREATOR = new Parcelable.Creator<ProductMetaItem>() {
		@Override
		public ProductMetaItem createFromParcel(Parcel source) {
			return new ProductMetaItem(source);
		}

		@Override
		public ProductMetaItem[] newArray(int size) {
			return new ProductMetaItem[size];
		}
	};
}
