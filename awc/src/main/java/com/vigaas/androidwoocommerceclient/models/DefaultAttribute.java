package com.vigaas.androidwoocommerceclient.models;


import android.os.Parcel;
import android.os.Parcelable;

public class DefaultAttribute implements Parcelable {

	private Integer id;
	private String name;
	private String slug;
	private String option;
	
	public DefaultAttribute() {}

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

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(this.id);
		dest.writeString(this.name);
		dest.writeString(this.slug);
		dest.writeString(this.option);
	}

	protected DefaultAttribute(Parcel in) {
		this.id = (Integer) in.readValue(Integer.class.getClassLoader());
		this.name = in.readString();
		this.slug = in.readString();
		this.option = in.readString();
	}

	public static final Parcelable.Creator<DefaultAttribute> CREATOR = new Parcelable.Creator<DefaultAttribute>() {
		@Override
		public DefaultAttribute createFromParcel(Parcel source) {
			return new DefaultAttribute(source);
		}

		@Override
		public DefaultAttribute[] newArray(int size) {
			return new DefaultAttribute[size];
		}
	};
}
