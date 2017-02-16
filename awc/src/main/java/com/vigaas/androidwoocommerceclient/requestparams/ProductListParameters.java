package com.vigaas.androidwoocommerceclient.requestparams;

import com.vigaas.androidwoocommerceclient.models.Product;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by damandeep on 19/10/16.
 */

public class ProductListParameters {

    private HashMap<String,String> params;

    public ProductListParameters() {
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
        DRAFT("draft"),
        PUBLISH("publish"),
        TRASH("trash"),
        PRIVATE("private");private String value;

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
    private String slug;
    private Status status = Status.ANY;
    private String categoryIds;
    private String tagIds;
    private String shippingClassIds;
    private String attribute;
    private String attributeTerm;
    private String sku;

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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        params.put("slug",slug);
        this.slug = slug;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        params.put("status",status.getValue());
        this.status = status;
    }

    public String getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(String categoryIds) {
        params.put("category",categoryIds);
        this.categoryIds = categoryIds;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        params.put("tag",tagIds);
        this.tagIds = tagIds;
    }

    public String getShippingClassIds() {
        return shippingClassIds;
    }

    public void setShippingClassIds(String shippingClassIds) {
        params.put("shipping_class",shippingClassIds);
        this.shippingClassIds = shippingClassIds;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        params.put("attribute",attribute);
        this.attribute = attribute;
    }

    public String getAttributeTerm() {
        return attributeTerm;
    }

    public void setAttributeTerm(String attributeTerm) {
        params.put("attribute_term",attributeTerm);
        this.attributeTerm = attributeTerm;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        params.put("sku",sku);
        this.sku = sku;
    }

    public void clearAll() {
        this.params.clear();
    }

    public HashMap<String,String> getParams() {
        return params;
    }
}
