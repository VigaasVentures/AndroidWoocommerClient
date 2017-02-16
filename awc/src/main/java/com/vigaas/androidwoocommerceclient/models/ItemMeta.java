package com.vigaas.androidwoocommerceclient.models;

import java.util.Date;




public class ItemMeta {
	private int id;
	private Date date;

	public ItemMeta(){}	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
