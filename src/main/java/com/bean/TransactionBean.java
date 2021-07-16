package com.bean;

public class TransactionBean {
	
	String transactionId, transactionType, updatedBalance;
	public String getUpdatedBalance() {
		return updatedBalance;
	}
	public void setUpdatedBalance(String updatedBalance) {
		this.updatedBalance = updatedBalance;
	}
	int accountId, amount;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
