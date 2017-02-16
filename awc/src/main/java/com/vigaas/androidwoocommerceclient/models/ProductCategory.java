package com.vigaas.androidwoocommerceclient.models;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory implements Parcelable {

	public enum Display {
		@SerializedName("default")
		DEFAULT("default"),

		@SerializedName("products")
		PRODUCTS("products"),

		@SerializedName("subcategories")
		SUBCATEGORIES("subcategories"),

		@SerializedName("both")
		BOTH("both");
		
		private String value;

	    private Display(final String json) {
	        this.value = json;
	    }

	    public String getValue() {
	        return this.value;
	    }
		
	}
	
	private int id;
	private String name;
	private String slug;
	private int parent;
	private String description;
	private Display display;
	private List<CategoryImage> image;
	@SerializedName("menu_order")private int menuOrder;
	private int count;
	
	public ProductCategory() {}

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

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public int getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<CategoryImage> getImage() {
		return image;
	}

	public void setImage(List<CategoryImage> image) {
		this.image = image;
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
		dest.writeInt(this.parent);
		dest.writeString(this.description);
		dest.writeInt(this.display == null ? -1 : this.display.ordinal());
		dest.writeList(this.image);
		dest.writeInt(this.menuOrder);
		dest.writeInt(this.count);
	}

	protected ProductCategory(Parcel in) {
		this.id = in.readInt();
		this.name = in.readString();
		this.slug = in.readString();
		this.parent = in.readInt();
		this.description = in.readString();
		int tmpDisplay = in.readInt();
		this.display = tmpDisplay == -1 ? null : Display.values()[tmpDisplay];
		this.image = new ArrayList<CategoryImage>();
		in.readList(this.image, CategoryImage.class.getClassLoader());
		this.menuOrder = in.readInt();
		this.count = in.readInt();
	}

	public static final Parcelable.Creator<ProductCategory> CREATOR = new Parcelable.Creator<ProductCategory>() {
		@Override
		public ProductCategory createFromParcel(Parcel source) {
			return new ProductCategory(source);
		}

		@Override
		public ProductCategory[] newArray(int size) {
			return new ProductCategory[size];
		}
	};
}
