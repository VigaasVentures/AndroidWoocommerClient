package com.vigaas.androidwoocommerceclient.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;


public class CategoryImage {

	private int id;
	@SerializedName("date_created")private Date createdAt;
	@SerializedName("date_modified")private Date updatedAt;
	private String src;
	private String name;
	private String alt;

	public CategoryImage() {}


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

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

}
