package com.bean;

public class BranchBean {

	int branchId, overDraftIntRate, overDraftLimit;
	String branchName;
	int loanIntRate;

	public int getLoanIntRate() {
		return loanIntRate;
	}

	public void setLoanIntRate(int loanIntRate) {
		this.loanIntRate = loanIntRate;
	}

	public int getOverDraftIntRate() {
		return overDraftIntRate;
	}

	public void setOverDraftIntRate(int overDraftIntRate) {
		this.overDraftIntRate = overDraftIntRate;
	}

	public int getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(int overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

}
