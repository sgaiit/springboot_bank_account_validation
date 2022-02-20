package com.bankaccountvalidation.model;

import java.util.List;

public class AccountRequest {
	
	private Integer accountNumber;
	private List<String> sources;
	
	
	public AccountRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public List<String> getSources() {
		return sources;
	}
	public void setSources(List<String> sources) {
		this.sources = sources;
	}
	
	

}
