package com.vigaas.androidwoocommerceclient.models;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class BillingAddress implements Parcelable {

	@SerializedName("first_name")private String firstName;
	@SerializedName("last_name")private String lastName;
	private String company;
	@SerializedName("address_1")private String address1;
	@SerializedName("address_2")private String address2;
	private String city;
	private String state;
	private String postcode;
	private String country;
	private String email;
	private String phone;

	public BillingAddress() {}

	//"first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//"last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	//"address_1")
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	//"address_2")
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.firstName);
		dest.writeString(this.lastName);
		dest.writeString(this.company);
		dest.writeString(this.address1);
		dest.writeString(this.address2);
		dest.writeString(this.city);
		dest.writeString(this.state);
		dest.writeString(this.postcode);
		dest.writeString(this.country);
		dest.writeString(this.email);
		dest.writeString(this.phone);
	}

	protected BillingAddress(Parcel in) {
		this.firstName = in.readString();
		this.lastName = in.readString();
		this.company = in.readString();
		this.address1 = in.readString();
		this.address2 = in.readString();
		this.city = in.readString();
		this.state = in.readString();
		this.postcode = in.readString();
		this.country = in.readString();
		this.email = in.readString();
		this.phone = in.readString();
	}

	public static final Creator<BillingAddress> CREATOR = new Creator<BillingAddress>() {
		@Override
		public BillingAddress createFromParcel(Parcel source) {
			return new BillingAddress(source);
		}

		@Override
		public BillingAddress[] newArray(int size) {
			return new BillingAddress[size];
		}
	};

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
