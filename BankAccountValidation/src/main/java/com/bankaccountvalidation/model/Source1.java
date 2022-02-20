package com.bankaccountvalidation.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class Source1 {
	
	private String sourceName;
	private List<AccountDetails> accountDetailList;
	
	
	public Source1(String sourceName, List<AccountDetails> accountDetailList) {
		super();
		this.sourceName = sourceName;
		this.accountDetailList = accountDetailList;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public List<AccountDetails> getAccountDetailList() {
		if(CollectionUtils.isEmpty(accountDetailList)) {
			return new ArrayList<AccountDetails>();
		}
		return accountDetailList;
	}
	public void setAccountDetailList(List<AccountDetails> accountDetailList) {
		this.accountDetailList = accountDetailList;
	}
	@Override
	public String toString() {
		return "Source1 [sourceName=" + sourceName + ", accountDetailList=" + accountDetailList + "]";
	}
	public boolean contains(Integer accountNumber) {
		return accountDetailList.stream().anyMatch(i->i.getAccountNumber().equals(accountNumber));
	}
	
	
	
	

}
