package com.vigaas.androidwoocommerceclient.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Product implements Parcelable {

    private int id;
    private String name;
    private String slug;
    @SerializedName("date_created")private Date createdAt;
    @SerializedName("date_modified")private Date updatedAt;
    private Type type;
    private Status status;
    private boolean featured;
    @SerializedName("catalog_visibility")private CatalogVisibility catalogVisibility;
    private String description;
    @SerializedName("short_description")private String shortDescription;
    private String sku;
    private String price;
    @SerializedName("regular_price")private String regularPrice;
    @SerializedName("sale_price")private String salePrice;
    @SerializedName("date_on_sale_from")private Date salePriceDatesFrom;
    @SerializedName("date_on_sale_to")private Date salePriceDatesTo;
    @SerializedName("price_html")private String priceHtml;
    @SerializedName("on_sale")private boolean onSale;
    private boolean purchasable;
    @SerializedName("total_sales")private int totalSales;
    private boolean virtual;
    private boolean downloadable;
    private List<Download> downloads;
    @SerializedName("download_limit")private int downloadLimit;
    @SerializedName("download_expiry")private int downloadExpiry;
    @SerializedName("download_type")private DownloadType downloadType;
    @SerializedName("external_url")private String externalUrl;
    @SerializedName("button_text")private String buttonText;
    @SerializedName("tax_status")private TaxStatus taxStatus;
    @SerializedName("tax_class")private String taxClass;
    @SerializedName("manage_stock")private boolean managingStock;
    @SerializedName("stock_quantity")private int stockQuantity;
    @SerializedName("in_stock")private boolean inStock;
    private BackorderType backorders;
    @SerializedName("backorders_allowed")private boolean backordersAllowed;
    private boolean backordered;
    @SerializedName("sold_individually")private boolean soldIndividually;
    private String weight;
    private Dimension dimensions;
    @SerializedName("shipping_required")private boolean shippingRequired;
    @SerializedName("shipping_taxable")private boolean shippingTaxable;
    @SerializedName("shipping_class")private String shippingClass;
    @SerializedName("shipping_class_id")private int shippingClassId;
    @SerializedName("reviews_allowed")private boolean reviewsAllowed;
    @SerializedName("average_rating")private String averageRating;
    @SerializedName("rating_count")private int ratingCount;
    @SerializedName("related_ids")private List<Integer> relatedIds;
    @SerializedName("upsell_ids")private List<Integer> upsellIds;
    @SerializedName("cross_sell_ids")private List<Integer> crossSellIds;
    @SerializedName("parent_id")private int parentId;
    @SerializedName("purchase_note")private String purchaseNote;
    private List<ProductCategory> categories;
    private List<ProductTag> tags;
    private List<ProductImage> images;
    private List<Attribute> attributes;
    @SerializedName("default_attributes")private List<DefaultAttribute> defaultAttributes;
    private List<Variation> variations;
    @SerializedName("grouped_products")private List<String> groupedProducts;
    @SerializedName("menu_order")private int menuOrder;


    public Product() {}


    public enum Type {
		@SerializedName("simple")
		SIMPLE("simple"),

		@SerializedName("grouped")
		GROUPED("grouped"),

		@SerializedName("external")
		EXTERNAL("external"),

		@SerializedName("variable")
		VARIABLE("variable");

		private String value;

		private Type(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	public enum BackorderType {
		@SerializedName("no")
		NO("no"),

		@SerializedName("notify")
		NOTIFY("notify"),

		@SerializedName("yes")
		YES("yes");
		private String value;

		private BackorderType(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	public enum CatalogVisibility {
		@SerializedName("visible")
		VISIBLE("visible"),

		@SerializedName("catalog")
		CATALOG("catalog"),

		@SerializedName("search")
		SEARCH("search"),

		@SerializedName("hidden")
		HIDDEN("hidden");
		private String value;

		private CatalogVisibility(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	public enum Status {
		@SerializedName("draft")
		DRAFT("draft"),

		@SerializedName("publish")
		PUBLISH("publish"),

		@SerializedName("trash")
		TRASH("trash"),

		@SerializedName("private")
		PRIVATE("private");

        private String value;

		private Status(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}

	}

	public enum TaxStatus {
		@SerializedName("taxable")
		TAXABLE("taxable"),

		@SerializedName("shipping")
		SHIPPING("shipping"),

		@SerializedName("none")
		NONE("none");
		private String value;

		private TaxStatus(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}
	public enum DownloadType {
		@SerializedName("standard")
		STANDARD("standard"),

		@SerializedName("application")
		APPLICATION("application"),

		@SerializedName("music")
		MUSIC("music");
		private String value;

		private DownloadType(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public CatalogVisibility getCatalogVisibility() {
        return catalogVisibility;
    }

    public void setCatalogVisibility(CatalogVisibility catalogVisibility) {
        this.catalogVisibility = catalogVisibility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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

    public String getPriceHtml() {
        return priceHtml;
    }

    public void setPriceHtml(String priceHtml) {
        this.priceHtml = priceHtml;
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

    public int getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
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

    public DownloadType getDownloadType() {
        return downloadType;
    }

    public void setDownloadType(DownloadType downloadType) {
        this.downloadType = downloadType;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public TaxStatus getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(TaxStatus taxStatus) {
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

    public BackorderType getBackorders() {
        return backorders;
    }

    public void setBackorders(BackorderType backorders) {
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

    public boolean isSoldIndividually() {
        return soldIndividually;
    }

    public void setSoldIndividually(boolean soldIndividually) {
        this.soldIndividually = soldIndividually;
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

    public boolean isShippingRequired() {
        return shippingRequired;
    }

    public void setShippingRequired(boolean shippingRequired) {
        this.shippingRequired = shippingRequired;
    }

    public boolean isShippingTaxable() {
        return shippingTaxable;
    }

    public void setShippingTaxable(boolean shippingTaxable) {
        this.shippingTaxable = shippingTaxable;
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

    public boolean isReviewsAllowed() {
        return reviewsAllowed;
    }

    public void setReviewsAllowed(boolean reviewsAllowed) {
        this.reviewsAllowed = reviewsAllowed;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public List<Integer> getRelatedIds() {
        return relatedIds;
    }

    public void setRelatedIds(List<Integer> relatedIds) {
        this.relatedIds = relatedIds;
    }

    public List<Integer> getUpsellIds() {
        return upsellIds;
    }

    public void setUpsellIds(List<Integer> upsellIds) {
        this.upsellIds = upsellIds;
    }

    public List<Integer> getCrossSellIds() {
        return crossSellIds;
    }

    public void setCrossSellIds(List<Integer> crossSellIds) {
        this.crossSellIds = crossSellIds;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getPurchaseNote() {
        return purchaseNote;
    }

    public void setPurchaseNote(String purchaseNote) {
        this.purchaseNote = purchaseNote;
    }

    public List<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ProductCategory> categories) {
        this.categories = categories;
    }

    public List<ProductTag> getTags() {
        return tags;
    }

    public void setTags(List<ProductTag> tags) {
        this.tags = tags;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<DefaultAttribute> getDefaultAttributes() {
        return defaultAttributes;
    }

    public void setDefaultAttributes(List<DefaultAttribute> defaultAttributes) {
        this.defaultAttributes = defaultAttributes;
    }

    public List<Variation> getVariations() {
        return variations;
    }

    public void setVariations(List<Variation> variations) {
        this.variations = variations;
    }

    public List<String> getGroupedProducts() {
        return groupedProducts;
    }

    public void setGroupedProducts(List<String> groupedProducts) {
        this.groupedProducts = groupedProducts;
    }

    public int getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(int menuOrder) {
        this.menuOrder = menuOrder;
    }

    public float getAverageRatingAsFloat() {
        try {
            float ret = Float.parseFloat(averageRating);
            return ret;
        }
        catch (Exception e) {
            return 0;
        }
    }

    public Variation getVariationFromAttributes(List<Attribute> attributeList) {
        for (Variation v : this.variations) {
//            Log.d("VV", v.getSku());
            int counter = 0;
            for (Attribute a: v.getAttributes()) {

//                    Log.d("LEFTSIDE",a.getOption());
//                    Log.d("RIGHTSIDE",attributeList.get(counter).getOption());
//                    Log.d("LEFTSIDE",a.getName());
//                    Log.d("RIGHTSIDE",attributeList.get(counter).getName());
                    if (a.isEqualToAttribute(attributeList.get(counter))) {
                        counter++;
                        if (counter == attributeList.size()) {
                            return v;
                        }
                    }

            }
        }
        return null;
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
        dest.writeLong(this.createdAt != null ? this.createdAt.getTime() : -1);
        dest.writeLong(this.updatedAt != null ? this.updatedAt.getTime() : -1);
        dest.writeInt(this.type == null ? -1 : this.type.ordinal());
        dest.writeInt(this.status == null ? -1 : this.status.ordinal());
        dest.writeByte(this.featured ? (byte) 1 : (byte) 0);
        dest.writeInt(this.catalogVisibility == null ? -1 : this.catalogVisibility.ordinal());
        dest.writeString(this.description);
        dest.writeString(this.shortDescription);
        dest.writeString(this.sku);
        dest.writeString(this.price);
        dest.writeString(this.regularPrice);
        dest.writeString(this.salePrice);
        dest.writeLong(this.salePriceDatesFrom != null ? this.salePriceDatesFrom.getTime() : -1);
        dest.writeLong(this.salePriceDatesTo != null ? this.salePriceDatesTo.getTime() : -1);
        dest.writeString(this.priceHtml);
        dest.writeByte(this.onSale ? (byte) 1 : (byte) 0);
        dest.writeByte(this.purchasable ? (byte) 1 : (byte) 0);
        dest.writeInt(this.totalSales);
        dest.writeByte(this.virtual ? (byte) 1 : (byte) 0);
        dest.writeByte(this.downloadable ? (byte) 1 : (byte) 0);
        dest.writeList(this.downloads);
        dest.writeInt(this.downloadLimit);
        dest.writeInt(this.downloadExpiry);
        dest.writeInt(this.downloadType == null ? -1 : this.downloadType.ordinal());
        dest.writeString(this.externalUrl);
        dest.writeString(this.buttonText);
        dest.writeInt(this.taxStatus == null ? -1 : this.taxStatus.ordinal());
        dest.writeString(this.taxClass);
        dest.writeByte(this.managingStock ? (byte) 1 : (byte) 0);
        dest.writeInt(this.stockQuantity);
        dest.writeByte(this.inStock ? (byte) 1 : (byte) 0);
        dest.writeInt(this.backorders == null ? -1 : this.backorders.ordinal());
        dest.writeByte(this.backordersAllowed ? (byte) 1 : (byte) 0);
        dest.writeByte(this.backordered ? (byte) 1 : (byte) 0);
        dest.writeByte(this.soldIndividually ? (byte) 1 : (byte) 0);
        dest.writeString(this.weight);
        dest.writeParcelable(this.dimensions, flags);
        dest.writeByte(this.shippingRequired ? (byte) 1 : (byte) 0);
        dest.writeByte(this.shippingTaxable ? (byte) 1 : (byte) 0);
        dest.writeString(this.shippingClass);
        dest.writeInt(this.shippingClassId);
        dest.writeByte(this.reviewsAllowed ? (byte) 1 : (byte) 0);
        dest.writeString(this.averageRating);
        dest.writeInt(this.ratingCount);
        dest.writeList(this.relatedIds);
        dest.writeList(this.upsellIds);
        dest.writeList(this.crossSellIds);
        dest.writeInt(this.parentId);
        dest.writeString(this.purchaseNote);
        dest.writeList(this.categories);
        dest.writeList(this.tags);
        dest.writeList(this.images);
        dest.writeList(this.attributes);
        dest.writeList(this.defaultAttributes);
        dest.writeList(this.variations);
        dest.writeStringList(this.groupedProducts);
        dest.writeInt(this.menuOrder);
    }

    protected Product(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.slug = in.readString();
        long tmpCreatedAt = in.readLong();
        this.createdAt = tmpCreatedAt == -1 ? null : new Date(tmpCreatedAt);
        long tmpUpdatedAt = in.readLong();
        this.updatedAt = tmpUpdatedAt == -1 ? null : new Date(tmpUpdatedAt);
        int tmpType = in.readInt();
        this.type = tmpType == -1 ? null : Type.values()[tmpType];
        int tmpStatus = in.readInt();
        this.status = tmpStatus == -1 ? null : Status.values()[tmpStatus];
        this.featured = in.readByte() != 0;
        int tmpCatalogVisibility = in.readInt();
        this.catalogVisibility = tmpCatalogVisibility == -1 ? null : CatalogVisibility.values()[tmpCatalogVisibility];
        this.description = in.readString();
        this.shortDescription = in.readString();
        this.sku = in.readString();
        this.price = in.readString();
        this.regularPrice = in.readString();
        this.salePrice = in.readString();
        long tmpSalePriceDatesFrom = in.readLong();
        this.salePriceDatesFrom = tmpSalePriceDatesFrom == -1 ? null : new Date(tmpSalePriceDatesFrom);
        long tmpSalePriceDatesTo = in.readLong();
        this.salePriceDatesTo = tmpSalePriceDatesTo == -1 ? null : new Date(tmpSalePriceDatesTo);
        this.priceHtml = in.readString();
        this.onSale = in.readByte() != 0;
        this.purchasable = in.readByte() != 0;
        this.totalSales = in.readInt();
        this.virtual = in.readByte() != 0;
        this.downloadable = in.readByte() != 0;
        this.downloads = new ArrayList<Download>();
        in.readList(this.downloads, Download.class.getClassLoader());
        this.downloadLimit = in.readInt();
        this.downloadExpiry = in.readInt();
        int tmpDownloadType = in.readInt();
        this.downloadType = tmpDownloadType == -1 ? null : DownloadType.values()[tmpDownloadType];
        this.externalUrl = in.readString();
        this.buttonText = in.readString();
        int tmpTaxStatus = in.readInt();
        this.taxStatus = tmpTaxStatus == -1 ? null : TaxStatus.values()[tmpTaxStatus];
        this.taxClass = in.readString();
        this.managingStock = in.readByte() != 0;
        this.stockQuantity = in.readInt();
        this.inStock = in.readByte() != 0;
        int tmpBackorders = in.readInt();
        this.backorders = tmpBackorders == -1 ? null : BackorderType.values()[tmpBackorders];
        this.backordersAllowed = in.readByte() != 0;
        this.backordered = in.readByte() != 0;
        this.soldIndividually = in.readByte() != 0;
        this.weight = in.readString();
        this.dimensions = in.readParcelable(Dimension.class.getClassLoader());
        this.shippingRequired = in.readByte() != 0;
        this.shippingTaxable = in.readByte() != 0;
        this.shippingClass = in.readString();
        this.shippingClassId = in.readInt();
        this.reviewsAllowed = in.readByte() != 0;
        this.averageRating = in.readString();
        this.ratingCount = in.readInt();
        this.relatedIds = new ArrayList<Integer>();
        in.readList(this.relatedIds, Integer.class.getClassLoader());
        this.upsellIds = new ArrayList<Integer>();
        in.readList(this.upsellIds, Integer.class.getClassLoader());
        this.crossSellIds = new ArrayList<Integer>();
        in.readList(this.crossSellIds, Integer.class.getClassLoader());
        this.parentId = in.readInt();
        this.purchaseNote = in.readString();
        this.categories = new ArrayList<ProductCategory>();
        in.readList(this.categories, ProductCategory.class.getClassLoader());
        this.tags = new ArrayList<ProductTag>();
        in.readList(this.tags, ProductTag.class.getClassLoader());
        this.images = new ArrayList<ProductImage>();
        in.readList(this.images, ProductImage.class.getClassLoader());
        this.attributes = new ArrayList<Attribute>();
        in.readList(this.attributes, Attribute.class.getClassLoader());
        this.defaultAttributes = new ArrayList<DefaultAttribute>();
        in.readList(this.defaultAttributes, DefaultAttribute.class.getClassLoader());
        this.variations = new ArrayList<Variation>();
        in.readList(this.variations, Variation.class.getClassLoader());
        this.groupedProducts = in.createStringArrayList();
        this.menuOrder = in.readInt();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
