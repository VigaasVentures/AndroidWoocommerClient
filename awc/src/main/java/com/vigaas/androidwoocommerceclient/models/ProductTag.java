package com.vigaas.androidwoocommerceclient.models;


import android.os.Parcel;
import android.os.Parcelable;

public class ProductTag implements Parcelable {

	private int id;
	private String name;
	private String slug;
	private String description;
	private int count;
	
	public ProductTag() {}

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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.id);
		dest.writeString(this.name);
		dest.writeString(this.slug);
		dest.writeString(this.description);
		dest.writeInt(this.count);
	}

	protected ProductTag(Parcel in) {
		this.id = in.readInt();
		this.name = in.readString();
		this.slug = in.readString();
		this.description = in.readString();
		this.count = in.readInt();
	}

	public static final Parcelable.Creator<ProductTag> CREATOR = new Parcelable.Creator<ProductTag>() {
		@Override
		public ProductTag createFromParcel(Parcel source) {
			return new ProductTag(source);
		}

		@Override
		public ProductTag[] newArray(int size) {
			return new ProductTag[size];
		}
	};
}
