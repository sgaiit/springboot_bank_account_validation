package com.bankaccountvalidation.model;

public class AccountDetails {
	
	private Integer accountNumber;

	public AccountDetails(Integer accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "AccountDetails [accountNumber=" + accountNumber + "]";
	}
	
	

}
