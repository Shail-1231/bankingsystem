package com.bean;

public class AccountBean {
	
	int accountId, userId, branchId;
	String accountNumber;
	int accountTypeId;
	int balance;
	int overDraft;
	int overDraftLimit;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getOverDraft() {
		return overDraft;
	}
	public void setOverDraft(int overDraft) {
		this.overDraft = overDraft;
	}
	public int getOverDraftLimit() {
		return overDraftLimit;
	}
	public void setOverDraftLimit(int overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}
	
	
	

}
