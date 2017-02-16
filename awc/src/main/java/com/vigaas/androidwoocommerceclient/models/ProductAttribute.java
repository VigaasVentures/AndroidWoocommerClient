package com.vigaas.androidwoocommerceclient.models;



public class ProductAttribute  {

	public enum Type {
		SELECT("select"),
		TEXT("text");
		
		private String value;

	    private Type(final String json) {
	        this.value = json;
	    }

	    public String getValue() {
	        return this.value;
	    }
	}
	
	public enum OrderBy {
		MENU_ORDER("menu_order"), 
		NAME("name"), 
		NAME_NUM("name_num"), 
		ID("id");
		
		private String value;

	    private OrderBy(final String json) {
	        this.value = json;
	    }

	    public String getValue() {
	        return this.value;
	    }
	}
	
	private int id;
	private String name;
	private String slug;
	private Type type;
	private OrderBy orderBy;
	private boolean hasArchives;
	
	public ProductAttribute() {}

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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	//"order_by")
	public OrderBy getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(OrderBy orderBy) {
		this.orderBy = orderBy;
	}

	//"has_archives")
	public boolean isHasArchives() {
		return hasArchives;
	}

	public void setHasArchives(boolean hasArchives) {
		this.hasArchives = hasArchives;
	}
	
	
}
