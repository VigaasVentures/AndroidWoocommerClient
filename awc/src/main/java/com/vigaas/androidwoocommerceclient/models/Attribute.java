package com.vigaas.androidwoocommerceclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


public class Attribute implements Parcelable {
	private int id;
	private String name;
	private String slug;
	private int position;
	private boolean visible;
	private boolean variation;
	private List<String> options;
	private String option; //only for variable product attribute

	
	public Attribute() {}

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

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVariation() {
		return variation;
	}

	public void setVariation(boolean variation) {
		this.variation = variation;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//only for variable product attribute
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public boolean isEqualToAttribute(Attribute a) {
		if(this.name.equalsIgnoreCase(a.name) && this.option.equalsIgnoreCase(a.option)) {
			return true;
		}
		else {
			return false;
		}
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
		dest.writeInt(this.position);
		dest.writeByte(this.visible ? (byte) 1 : (byte) 0);
		dest.writeByte(this.variation ? (byte) 1 : (byte) 0);
		dest.writeStringList(this.options);
		dest.writeString(this.option);
	}

	protected Attribute(Parcel in) {
		this.id = in.readInt();
		this.name = in.readString();
		this.slug = in.readString();
		this.position = in.readInt();
		this.visible = in.readByte() != 0;
		this.variation = in.readByte() != 0;
		this.options = in.createStringArrayList();
		this.option = in.readString();
	}

	public static final Parcelable.Creator<Attribute> CREATOR = new Parcelable.Creator<Attribute>() {
		@Override
		public Attribute createFromParcel(Parcel source) {
			return new Attribute(source);
		}

		@Override
		public Attribute[] newArray(int size) {
			return new Attribute[size];
		}
	};
}
