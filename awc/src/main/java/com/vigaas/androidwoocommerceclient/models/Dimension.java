package com.vigaas.androidwoocommerceclient.models;


import android.os.Parcel;
import android.os.Parcelable;

public class Dimension implements Parcelable {

	private Double length;
	private Double width;
	private Double height;
	private String unit;
	
	public Dimension() {}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(this.length);
		dest.writeValue(this.width);
		dest.writeValue(this.height);
		dest.writeString(this.unit);
	}

	protected Dimension(Parcel in) {
		this.length = (Double) in.readValue(Double.class.getClassLoader());
		this.width = (Double) in.readValue(Double.class.getClassLoader());
		this.height = (Double) in.readValue(Double.class.getClassLoader());
		this.unit = in.readString();
	}

	public static final Parcelable.Creator<Dimension> CREATOR = new Parcelable.Creator<Dimension>() {
		@Override
		public Dimension createFromParcel(Parcel source) {
			return new Dimension(source);
		}

		@Override
		public Dimension[] newArray(int size) {
			return new Dimension[size];
		}
	};
}
