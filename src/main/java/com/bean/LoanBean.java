package com.bean;

public class LoanBean {

	int loanId, userId, rateOfInterest, processingFee, balanceAmount, principalAmount;

	public int getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(int principalAmount) {
		this.principalAmount = principalAmount;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(int rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public int getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(int processingFee) {
		this.processingFee = processingFee;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

}
