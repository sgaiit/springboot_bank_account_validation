package com.bankaccountvalidation.model;

public class ValidationResponse {
	
	private String source;
	private boolean isValid;
	
	
	public ValidationResponse(String source, boolean isValid) {
		super();
		this.source = source;
		this.isValid = isValid;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	@Override
	public String toString() {
		return "ValidationResponse [source=" + source + ", isValid=" + isValid + "]";
	}
	
	
	
	

}
