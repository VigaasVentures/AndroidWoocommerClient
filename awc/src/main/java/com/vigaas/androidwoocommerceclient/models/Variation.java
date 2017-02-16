package com.vigaas.androidwoocommerceclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Variation implements Parcelable {

	private int id;
	@SerializedName("date_created")private Date createdAt;
	@SerializedName("date_modified")private Date updatedAt;
	private String permalink;
	private String sku;
	private String price;
	@SerializedName("regular_price")private String regularPrice;
	@SerializedName("sale_price")private String salePrice;
	@SerializedName("date_on_sale_from")private Date salePriceDatesFrom;
	@SerializedName("date_on_sale_to")private Date salePriceDatesTo;
	@SerializedName("on_sale")private boolean onSale;
	private boolean purchasable;
	private boolean virtual;
	private boolean downloadable;
	private List<Download> downloads;
	@SerializedName("download_limit")private int downloadLimit;
	@SerializedName("download_expiry")private int downloadExpiry;
	@SerializedName("tax_status")private Product.TaxStatus taxStatus;
	@SerializedName("tax_class")private String taxClass;
	@SerializedName("manage_stock")private boolean managingStock;
	@SerializedName("stock_quantity")private int stockQuantity;
	@SerializedName("in_stock")private boolean inStock;
	private Product.BackorderType backorders;
	@SerializedName("backorders_allowed")private boolean backordersAllowed;
	private boolean backordered;
	private String weight;
	private Dimension dimensions;
	@SerializedName("shipping_class")private String shippingClass;
	@SerializedName("shipping_class_id")private int shippingClassId;
	private List<ProductImage> image;
	private List<Attribute> attributes;


	public Variation() {}


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

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(String regularPrice) {
		this.regularPrice = regularPrice;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public Date getSalePriceDatesFrom() {
		return salePriceDatesFrom;
	}

	public void setSalePriceDatesFrom(Date salePriceDatesFrom) {
		this.salePriceDatesFrom = salePriceDatesFrom;
	}

	public Date getSalePriceDatesTo() {
		return salePriceDatesTo;
	}

	public void setSalePriceDatesTo(Date salePriceDatesTo) {
		this.salePriceDatesTo = salePriceDatesTo;
	}

	public boolean isOnSale() {
		return onSale;
	}

	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}

	public boolean isPurchasable() {
		return purchasable;
	}

	public void setPurchasable(boolean purchasable) {
		this.purchasable = purchasable;
	}

	public boolean isVirtual() {
		return virtual;
	}

	public void setVirtual(boolean virtual) {
		this.virtual = virtual;
	}

	public boolean isDownloadable() {
		return downloadable;
	}

	public void setDownloadable(boolean downloadable) {
		this.downloadable = downloadable;
	}

	public List<Download> getDownloads() {
		return downloads;
	}

	public void setDownloads(List<Download> downloads) {
		this.downloads = downloads;
	}

	public int getDownloadLimit() {
		return downloadLimit;
	}

	public void setDownloadLimit(int downloadLimit) {
		this.downloadLimit = downloadLimit;
	}

	public int getDownloadExpiry() {
		return downloadExpiry;
	}

	public void setDownloadExpiry(int downloadExpiry) {
		this.downloadExpiry = downloadExpiry;
	}

	public Product.TaxStatus getTaxStatus() {
		return taxStatus;
	}

	public void setTaxStatus(Product.TaxStatus taxStatus) {
		this.taxStatus = taxStatus;
	}

	public String getTaxClass() {
		return taxClass;
	}

	public void setTaxClass(String taxClass) {
		this.taxClass = taxClass;
	}

	public boolean isManagingStock() {
		return managingStock;
	}

	public void setManagingStock(boolean managingStock) {
		this.managingStock = managingStock;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public Product.BackorderType getBackorders() {
		return backorders;
	}

	public void setBackorders(Product.BackorderType backorders) {
		this.backorders = backorders;
	}

	public boolean isBackordersAllowed() {
		return backordersAllowed;
	}

	public void setBackordersAllowed(boolean backordersAllowed) {
		this.backordersAllowed = backordersAllowed;
	}

	public boolean isBackordered() {
		return backordered;
	}

	public void setBackordered(boolean backordered) {
		this.backordered = backordered;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Dimension getDimensions() {
		return dimensions;
	}

	public void setDimensions(Dimension dimensions) {
		this.dimensions = dimensions;
	}

	public String getShippingClass() {
		return shippingClass;
	}

	public void setShippingClass(String shippingClass) {
		this.shippingClass = shippingClass;
	}

	public int getShippingClassId() {
		return shippingClassId;
	}

	public void setShippingClassId(int shippingClassId) {
		this.shippingClassId = shippingClassId;
	}

	public List<ProductImage> getImage() {
		return image;
	}

	public void setImage(List<ProductImage> image) {
		this.image = image;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
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
		dest.writeString(this.permalink);
		dest.writeString(this.sku);
		dest.writeString(this.price);
		dest.writeString(this.regularPrice);
		dest.writeString(this.salePrice);
		dest.writeLong(this.salePriceDatesFrom != null ? this.salePriceDatesFrom.getTime() : -1);
		dest.writeLong(this.salePriceDatesTo != null ? this.salePriceDatesTo.getTime() : -1);
		dest.writeByte(this.onSale ? (byte) 1 : (byte) 0);
		dest.writeByte(this.purchasable ? (byte) 1 : (byte) 0);
		dest.writeByte(this.virtual ? (byte) 1 : (byte) 0);
		dest.writeByte(this.downloadable ? (byte) 1 : (byte) 0);
		dest.writeList(this.downloads);
		dest.writeInt(this.downloadLimit);
		dest.writeInt(this.downloadExpiry);
		dest.writeInt(this.taxStatus == null ? -1 : this.taxStatus.ordinal());
		dest.writeString(this.taxClass);
		dest.writeByte(this.managingStock ? (byte) 1 : (byte) 0);
		dest.writeInt(this.stockQuantity);
		dest.writeByte(this.inStock ? (byte) 1 : (byte) 0);
		dest.writeInt(this.backorders == null ? -1 : this.backorders.ordinal());
		dest.writeByte(this.backordersAllowed ? (byte) 1 : (byte) 0);
		dest.writeByte(this.backordered ? (byte) 1 : (byte) 0);
		dest.writeString(this.weight);
		dest.writeParcelable(this.dimensions, flags);
		dest.writeString(this.shippingClass);
		dest.writeInt(this.shippingClassId);
		dest.writeTypedList(this.image);
		dest.writeTypedList(this.attributes);
	}

	protected Variation(Parcel in) {
		this.id = in.readInt();
		long tmpCreatedAt = in.readLong();
		this.createdAt = tmpCreatedAt == -1 ? null : new Date(tmpCreatedAt);
		long tmpUpdatedAt = in.readLong();
		this.updatedAt = tmpUpdatedAt == -1 ? null : new Date(tmpUpdatedAt);
		this.permalink = in.readString();
		this.sku = in.readString();
		this.price = in.readString();
		this.regularPrice = in.readString();
		this.salePrice = in.readString();
		long tmpSalePriceDatesFrom = in.readLong();
		this.salePriceDatesFrom = tmpSalePriceDatesFrom == -1 ? null : new Date(tmpSalePriceDatesFrom);
		long tmpSalePriceDatesTo = in.readLong();
		this.salePriceDatesTo = tmpSalePriceDatesTo == -1 ? null : new Date(tmpSalePriceDatesTo);
		this.onSale = in.readByte() != 0;
		this.purchasable = in.readByte() != 0;
		this.virtual = in.readByte() != 0;
		this.downloadable = in.readByte() != 0;
		this.downloads = new ArrayList<Download>();
		in.readList(this.downloads, Download.class.getClassLoader());
		this.downloadLimit = in.readInt();
		this.downloadExpiry = in.readInt();
		int tmpTaxStatus = in.readInt();
		this.taxStatus = tmpTaxStatus == -1 ? null : Product.TaxStatus.values()[tmpTaxStatus];
		this.taxClass = in.readString();
		this.managingStock = in.readByte() != 0;
		this.stockQuantity = in.readInt();
		this.inStock = in.readByte() != 0;
		int tmpBackorders = in.readInt();
		this.backorders = tmpBackorders == -1 ? null : Product.BackorderType.values()[tmpBackorders];
		this.backordersAllowed = in.readByte() != 0;
		this.backordered = in.readByte() != 0;
		this.weight = in.readString();
		this.dimensions = in.readParcelable(Dimension.class.getClassLoader());
		this.shippingClass = in.readString();
		this.shippingClassId = in.readInt();
		this.image = in.createTypedArrayList(ProductImage.CREATOR);
		this.attributes = in.createTypedArrayList(Attribute.CREATOR);
	}

	public static final Parcelable.Creator<Variation> CREATOR = new Parcelable.Creator<Variation>() {
		@Override
		public Variation createFromParcel(Parcel source) {
			return new Variation(source);
		}

		@Override
		public Variation[] newArray(int size) {
			return new Variation[size];
		}
	};
}
