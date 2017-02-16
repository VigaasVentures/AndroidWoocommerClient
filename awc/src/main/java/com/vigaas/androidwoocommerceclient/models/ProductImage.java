package com.vigaas.androidwoocommerceclient.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.Date;


public class ProductImage implements Parcelable {

	private int id;
	@SerializedName("date_created")private Date createdAt;
	@SerializedName("date_modified")private Date updatedAt;
	private String src;
	private String name;
	private String alt;
	private int position;

	public ProductImage() {}


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

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getSrcOfSize(String size) {
		int breakPoint = src.lastIndexOf(".");
		String start = src.substring(0,breakPoint);
		String end = src.substring(breakPoint,src.length());
		Log.w("START",start);
		Log.w("END",end);
		return start+"-"+size+end;
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
		dest.writeString(this.src);
		dest.writeString(this.name);
		dest.writeString(this.alt);
		dest.writeInt(this.position);
	}

	protected ProductImage(Parcel in) {
		this.id = in.readInt();
		long tmpCreatedAt = in.readLong();
		this.createdAt = tmpCreatedAt == -1 ? null : new Date(tmpCreatedAt);
		long tmpUpdatedAt = in.readLong();
		this.updatedAt = tmpUpdatedAt == -1 ? null : new Date(tmpUpdatedAt);
		this.src = in.readString();
		this.name = in.readString();
		this.alt = in.readString();
		this.position = in.readInt();
	}

	public static final Parcelable.Creator<ProductImage> CREATOR = new Parcelable.Creator<ProductImage>() {
		@Override
		public ProductImage createFromParcel(Parcel source) {
			return new ProductImage(source);
		}

		@Override
		public ProductImage[] newArray(int size) {
			return new ProductImage[size];
		}
	};
}
