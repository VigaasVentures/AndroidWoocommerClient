package com.vigaas.androidwoocommerceclient.requestparams;


import java.util.HashMap;


/**
 * Created by damandeep on 19/10/16.
 */

public class ProductCategoryListParameters {

    private HashMap<String,String> params;

    public ProductCategoryListParameters() {
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
        ID("id"),
        INCLUDE("include"),
        NAME("name"),
        SLUG("slug"),
        TERMGROUP("term_group"),
        DESCRIPTION("description"),
        COUNT("count");
        private String value;

        private OrderBy(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }


    private int page;
    private int perPage;
    private String searchText;
    private String excludIds;
    private String includeIds;
    private OrderType orderType = OrderType.ASCENDING;
    private OrderBy orderBy = OrderBy.NAME;
    private boolean hideEmpty = false;
    private int parentId;
    private int productId;
    private String slug;


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

    public boolean isHideEmpty() {
        return hideEmpty;
    }

    public void setHideEmpty(boolean hideEmpty) {
        if(hideEmpty) {
            params.put("hide_empty","true");
        }
        else {
            params.put("hide_empty","false");
        }
        this.hideEmpty = hideEmpty;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        params.put("parent",parentId+"");
        this.parentId = parentId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        params.put("product",productId+"");
        this.productId = productId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        params.put("slug",slug);
        this.slug = slug;
    }

    public void clearAll() {
        this.params.clear();
    }


    public HashMap<String,String> getParams() {
        return params;
    }
}
