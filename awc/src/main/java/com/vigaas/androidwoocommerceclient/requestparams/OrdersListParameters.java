package com.vigaas.androidwoocommerceclient.requestparams;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;



public class OrdersListParameters {

    private HashMap<String,String> params;

    public OrdersListParameters() {
        params = new HashMap<>();
    }

    public enum OrderType {
        ASCENDING("asc"),
        DESCENDING("desc");
        private String value;

        private OrderType(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum OrderBy {
        DATE("date"),
        ID("id"),
        INCLUDE("include"),
        TITLE("title"),
        SLUG("slug");
        private String value;

        private OrderBy(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum Status {
        ANY("any"),
        PENDING("pending"),
        PROCESSING("processing"),
        ONHOLD("on-hold"),
        COMPLETED("completed"),
        CANCELLED("cancelled"),
        REFUNDED("refunded"),
        FAILED("failed");

        private String value;

        private Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

    }

    private int page;
    private int perPage;
    private String searchText;
    private Date publishedAfter;
    private Date publishedBefore;
    private String excludIds;
    private String includeIds;
    private int offset;
    private OrderType orderType = OrderType.ASCENDING;
    private OrderBy orderBy = OrderBy.DATE;
    private Status status = Status.ANY;
    private String customer;
    private String product;
    private int decimalPlaces;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        params.put("page",page+"");
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        params.put("per_page",perPage+"");
        this.perPage = perPage;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        params.put("search",searchText);
        this.searchText = searchText;
    }

    public Date getPublishedAfter() {
        return publishedAfter;
    }

    public void setPublishedAfter(Date publishedAfter) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault()); // Quoted "Z" to indicate UTC, no timezone offset
        String nowAsISO = df.format(publishedAfter);
        params.put("after",nowAsISO);
        this.publishedAfter = publishedAfter;
    }

    public Date getPublishedBefore() {
        return publishedBefore;
    }

    public void setPublishedBefore(Date publishedBefore) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault()); // Quoted "Z" to indicate UTC, no timezone offset
        String nowAsISO = df.format(publishedAfter);
        params.put("before",nowAsISO);
        this.publishedBefore = publishedBefore;
    }

    public String getExcludIds() {
        return excludIds;
    }

    public void setExcludIds(String excludIds) {
        params.put("exclude",excludIds);
        this.excludIds = excludIds;
    }

    public String getIncludeIds() {
        return includeIds;
    }

    public void setIncludeIds(String includeIds) {
        params.put("include",includeIds);
        this.includeIds = includeIds;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        params.put("offset",offset+"");
        this.offset = offset;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        params.put("order",orderType.getValue());
        this.orderType = orderType;
    }

    public OrderBy getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(OrderBy orderBy) {
        params.put("orderby",orderBy.getValue());
        this.orderBy = orderBy;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        params.put("status",status.getValue());
        this.status = status;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        params.put("customer",customer);
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        params.put("product",product);
        this.product = product;
    }

    public int getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(int decimalPlaces) {
        params.put("dp",decimalPlaces+"");
        this.decimalPlaces = decimalPlaces;
    }

    public void clearAll() {
        this.params.clear();
    }

    public HashMap<String,String> getParams() {
        return params;
    }
}
