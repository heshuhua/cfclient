package com.vanceinfo.cfclient.model;

public class Transaction {
	
	long transactionId;
	int customerId ;
	String location;
	int amount;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	
	public Transaction(long transactionId,int customerId, String location, int amount) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.location = location;
		this.amount = amount;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomer(int customer) {
		this.customerId = customer;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	

}
