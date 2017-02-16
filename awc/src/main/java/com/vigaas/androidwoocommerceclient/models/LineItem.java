package com.vigaas.androidwoocommerceclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class LineItem implements Parcelable {

	private int id;
	private String name;
	private String sku;
	@SerializedName("product_id")private int productId;
	@SerializedName("variation_id")private int variationId;
	private int quantity;
	@SerializedName("tax_class")private String taxClass;
	private String price;
	private String subtotal;
	@SerializedName("subtotal_tax")private String subtotalTax;
	private String total;
	@SerializedName("total_tax")private String totalTax;
	private List<TaxesMeta> taxes;
	private List<ProductMetaItem> meta;

	public LineItem() {}

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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getVariationId() {
		return variationId;
	}

	public void setVariationId(int variationId) {
		this.variationId = variationId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTaxClass() {
		return taxClass;
	}

	public void setTaxClass(String taxClass) {
		this.taxClass = taxClass;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getSubtotalTax() {
		return subtotalTax;
	}

	public void setSubtotalTax(String subtotalTax) {
		this.subtotalTax = subtotalTax;
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

	public List<TaxesMeta> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<TaxesMeta> taxes) {
		this.taxes = taxes;
	}

	public List<ProductMetaItem> getMeta() {
		return meta;
	}

	public void setMeta(List<ProductMetaItem> meta) {
		this.meta = meta;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.id);
		dest.writeString(this.name);
		dest.writeString(this.sku);
		dest.writeInt(this.productId);
		dest.writeInt(this.variationId);
		dest.writeInt(this.quantity);
		dest.writeString(this.taxClass);
		dest.writeString(this.price);
		dest.writeString(this.subtotal);
		dest.writeString(this.subtotalTax);
		dest.writeString(this.total);
		dest.writeString(this.totalTax);
		dest.writeTypedList(this.taxes);
		dest.writeTypedList(this.meta);
	}

	protected LineItem(Parcel in) {
		this.id = in.readInt();
		this.name = in.readString();
		this.sku = in.readString();
		this.productId = in.readInt();
		this.variationId = in.readInt();
		this.quantity = in.readInt();
		this.taxClass = in.readString();
		this.price = in.readString();
		this.subtotal = in.readString();
		this.subtotalTax = in.readString();
		this.total = in.readString();
		this.totalTax = in.readString();
		this.taxes = in.createTypedArrayList(TaxesMeta.CREATOR);
		this.meta = in.createTypedArrayList(ProductMetaItem.CREATOR);
	}

	public static final Parcelable.Creator<LineItem> CREATOR = new Parcelable.Creator<LineItem>() {
		@Override
		public LineItem createFromParcel(Parcel source) {
			return new LineItem(source);
		}

		@Override
		public LineItem[] newArray(int size) {
			return new LineItem[size];
		}
	};
}
