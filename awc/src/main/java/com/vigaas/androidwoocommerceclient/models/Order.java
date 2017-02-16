package com.vigaas.androidwoocommerceclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by damandeep on 08/02/17.
 */

public class Order implements Parcelable {


    public enum Status {
        @SerializedName("pending")
        PENDING("pending"),

        @SerializedName("processing")
        PROCESSING("processing"),

        @SerializedName("on-hold")
        ONHOLD("on-hold"),

        @SerializedName("completed")
        COMPLETED("completed"),

        @SerializedName("cancelled")
        CANCELLED("cancelled"),

        @SerializedName("refunded")
        REFUNDED("refunded"),

        @SerializedName("failed")
        FAILED("failed");

        private String value;

        private Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    private int id;
    @SerializedName("parent_id")private int parentId;
    private Status status;
    @SerializedName("order_key")private String orderKey;
    private int number;
    private String currency;
    private String version;
    @SerializedName("prices_include_tax")private boolean priceIncludeTax;
    @SerializedName("date_created")private Date createdAt;
    @SerializedName("date_modified")private Date updatedAt;
    @SerializedName("customer_id")private int customerId;
    @SerializedName("discount_total")private String discountTotal;
    @SerializedName("discount_tax")private String discountTax;
    @SerializedName("shipping_total")private String shippingTotal;
    @SerializedName("shipping_tax")private String shippingTax;
    @SerializedName("cart_tax")private String cartTax;
    private String total;
    @SerializedName("total_tax")private String totalTax;
    private BillingAddress billing;
    private ShippingAddress shipping;
    @SerializedName("payment_method")private String paymentMethod;
    @SerializedName("payment_method_title")private String paymentMethodTitle;
    @SerializedName("set_paid")private boolean setPaid;
    @SerializedName("transaction_id")private String transactionId;
    @SerializedName("customer_ip_address")private String customerIpAddress;
    @SerializedName("customer_user_agent")private String customerUserAgent;
    @SerializedName("created_via")private String createdVia;
    @SerializedName("customer_note")private String customerNote;
    @SerializedName("date_completed")private Date completedAt;
    @SerializedName("date_paid")private Date paidAt;
    @SerializedName("cart_hash")private String cartHash;
    @SerializedName("line_items")private List<LineItem> lineItems;
    @SerializedName("tax_lines")private List<TaxLine> taxes;
    @SerializedName("shipping_lines")private List<ShippingLine> shippings;
    @SerializedName("fee_lines")private List<FeeLine> fees;
    @SerializedName("coupon_lines")private List<CouponLine> coupons;
    private List<RefundLine> refunds;


    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isPriceIncludeTax() {
        return priceIncludeTax;
    }

    public void setPriceIncludeTax(boolean priceIncludeTax) {
        this.priceIncludeTax = priceIncludeTax;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDiscountTotal() {
        return discountTotal;
    }

    public void setDiscountTotal(String discountTotal) {
        this.discountTotal = discountTotal;
    }

    public String getDiscountTax() {
        return discountTax;
    }

    public void setDiscountTax(String discountTax) {
        this.discountTax = discountTax;
    }

    public String getShippingTotal() {
        return shippingTotal;
    }

    public void setShippingTotal(String shippingTotal) {
        this.shippingTotal = shippingTotal;
    }

    public String getShippingTax() {
        return shippingTax;
    }

    public void setShippingTax(String shippingTax) {
        this.shippingTax = shippingTax;
    }

    public String getCartTax() {
        return cartTax;
    }

    public void setCartTax(String cartTax) {
        this.cartTax = cartTax;
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

    public BillingAddress getBilling() {
        return billing;
    }

    public void setBilling(BillingAddress billing) {
        this.billing = billing;
    }

    public ShippingAddress getShipping() {
        return shipping;
    }

    public void setShipping(ShippingAddress shipping) {
        this.shipping = shipping;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethodTitle() {
        return paymentMethodTitle;
    }

    public void setPaymentMethodTitle(String paymentMethodTitle) {
        this.paymentMethodTitle = paymentMethodTitle;
    }

    public boolean isSetPaid() {
        return setPaid;
    }

    public void setSetPaid(boolean setPaid) {
        this.setPaid = setPaid;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerIpAddress() {
        return customerIpAddress;
    }

    public void setCustomerIpAddress(String customerIpAddress) {
        this.customerIpAddress = customerIpAddress;
    }

    public String getCustomerUserAgent() {
        return customerUserAgent;
    }

    public void setCustomerUserAgent(String customerUserAgent) {
        this.customerUserAgent = customerUserAgent;
    }

    public String getCreatedVia() {
        return createdVia;
    }

    public void setCreatedVia(String createdVia) {
        this.createdVia = createdVia;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }

    public Date getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Date paidAt) {
        this.paidAt = paidAt;
    }

    public String getCartHash() {
        return cartHash;
    }

    public void setCartHash(String cartHash) {
        this.cartHash = cartHash;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public List<TaxLine> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<TaxLine> taxes) {
        this.taxes = taxes;
    }

    public List<ShippingLine> getShippings() {
        return shippings;
    }

    public void setShippings(List<ShippingLine> shippings) {
        this.shippings = shippings;
    }

    public List<FeeLine> getFees() {
        return fees;
    }

    public void setFees(List<FeeLine> fees) {
        this.fees = fees;
    }

    public List<CouponLine> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<CouponLine> coupons) {
        this.coupons = coupons;
    }

    public List<RefundLine> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<RefundLine> refunds) {
        this.refunds = refunds;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.parentId);
        dest.writeInt(this.status == null ? -1 : this.status.ordinal());
        dest.writeString(this.orderKey);
        dest.writeInt(this.number);
        dest.writeString(this.currency);
        dest.writeString(this.version);
        dest.writeByte(this.priceIncludeTax ? (byte) 1 : (byte) 0);
        dest.writeLong(this.createdAt != null ? this.createdAt.getTime() : -1);
        dest.writeLong(this.updatedAt != null ? this.updatedAt.getTime() : -1);
        dest.writeInt(this.customerId);
        dest.writeString(this.discountTotal);
        dest.writeString(this.discountTax);
        dest.writeString(this.shippingTotal);
        dest.writeString(this.shippingTax);
        dest.writeString(this.cartTax);
        dest.writeString(this.total);
        dest.writeString(this.totalTax);
        dest.writeParcelable(this.billing, flags);
        dest.writeParcelable(this.shipping, flags);
        dest.writeString(this.paymentMethod);
        dest.writeString(this.paymentMethodTitle);
        dest.writeByte(this.setPaid ? (byte) 1 : (byte) 0);
        dest.writeString(this.transactionId);
        dest.writeString(this.customerIpAddress);
        dest.writeString(this.customerUserAgent);
        dest.writeString(this.createdVia);
        dest.writeString(this.customerNote);
        dest.writeLong(this.completedAt != null ? this.completedAt.getTime() : -1);
        dest.writeLong(this.paidAt != null ? this.paidAt.getTime() : -1);
        dest.writeString(this.cartHash);
        dest.writeTypedList(this.lineItems);
        dest.writeTypedList(this.taxes);
        dest.writeTypedList(this.shippings);
        dest.writeTypedList(this.fees);
        dest.writeTypedList(this.coupons);
        dest.writeTypedList(this.refunds);
    }

    protected Order(Parcel in) {
        this.id = in.readInt();
        this.parentId = in.readInt();
        int tmpStatus = in.readInt();
        this.status = tmpStatus == -1 ? null : Status.values()[tmpStatus];
        this.orderKey = in.readString();
        this.number = in.readInt();
        this.currency = in.readString();
        this.version = in.readString();
        this.priceIncludeTax = in.readByte() != 0;
        long tmpCreatedAt = in.readLong();
        this.createdAt = tmpCreatedAt == -1 ? null : new Date(tmpCreatedAt);
        long tmpUpdatedAt = in.readLong();
        this.updatedAt = tmpUpdatedAt == -1 ? null : new Date(tmpUpdatedAt);
        this.customerId = in.readInt();
        this.discountTotal = in.readString();
        this.discountTax = in.readString();
        this.shippingTotal = in.readString();
        this.shippingTax = in.readString();
        this.cartTax = in.readString();
        this.total = in.readString();
        this.totalTax = in.readString();
        this.billing = in.readParcelable(BillingAddress.class.getClassLoader());
        this.shipping = in.readParcelable(ShippingAddress.class.getClassLoader());
        this.paymentMethod = in.readString();
        this.paymentMethodTitle = in.readString();
        this.setPaid = in.readByte() != 0;
        this.transactionId = in.readString();
        this.customerIpAddress = in.readString();
        this.customerUserAgent = in.readString();
        this.createdVia = in.readString();
        this.customerNote = in.readString();
        long tmpCompletedAt = in.readLong();
        this.completedAt = tmpCompletedAt == -1 ? null : new Date(tmpCompletedAt);
        long tmpPaidAt = in.readLong();
        this.paidAt = tmpPaidAt == -1 ? null : new Date(tmpPaidAt);
        this.cartHash = in.readString();
        this.lineItems = in.createTypedArrayList(LineItem.CREATOR);
        this.taxes = in.createTypedArrayList(TaxLine.CREATOR);
        this.shippings = in.createTypedArrayList(ShippingLine.CREATOR);
        this.fees = in.createTypedArrayList(FeeLine.CREATOR);
        this.coupons = in.createTypedArrayList(CouponLine.CREATOR);
        this.refunds = in.createTypedArrayList(RefundLine.CREATOR);
    }

    public static final Parcelable.Creator<Order> CREATOR = new Parcelable.Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
}
