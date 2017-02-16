package com.vigaas.androidwoocommerceclient.models;

import java.util.Date;



public class ProductReview  {

	private int id;
	private Date createdAt;
	private String rating;
	private String reviewerName;
	private boolean verified;
	
	public ProductReview() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//"created_at")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
	
}
