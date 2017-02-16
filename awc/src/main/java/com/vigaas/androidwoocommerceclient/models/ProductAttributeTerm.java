package com.vigaas.androidwoocommerceclient.models;





public class ProductAttributeTerm  {

	private int id;
	private String name;
	private String slug;
	private int count;
	
	public ProductAttributeTerm() {}

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
