package com.bankaccountvalidation.model;

import java.util.ArrayList;
import java.util.List;

public class Result {

	private List<ValidationResponse> result;

	public List<ValidationResponse> getResult() {
		return result;
	}

	public void addResult(ValidationResponse validationResponse) {
		if (this.result == null) {
			result = new ArrayList<>();
		}
		result.add(validationResponse);
	}

}
