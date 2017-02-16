package com.vigaas.androidwoocommerceclient.models;




public class PaymentDetails  {

	private String methodId;
	private String methodTitle;
	private boolean paid;
	private String transactionId;
	
	public PaymentDetails() {}

	//"method_id")
	public String getMethodId() {
		return methodId;
	}

	public void setMethodId(String methodId) {
		this.methodId = methodId;
	}

	//"method_title")
	public String getMethodTitle() {
		return methodTitle;
	}

	public void setMethodTitle(String methodTitle) {
		this.methodTitle = methodTitle;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	//"transaction_id")
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	
}
