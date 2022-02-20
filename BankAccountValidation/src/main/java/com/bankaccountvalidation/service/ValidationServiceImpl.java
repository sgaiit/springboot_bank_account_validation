package com.bankaccountvalidation.service;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.bankaccountvalidation.model.Result;
import com.bankaccountvalidation.model.Source1;
import com.bankaccountvalidation.model.Source2;
import com.bankaccountvalidation.model.ValidationResponse;
import com.bankaccountvalidation.utils.Constants;

@Component
public class ValidationServiceImpl {

	@Autowired
	private DataSourceService1Impl dataSourceService1;

	@Autowired
	private DataSourceService2Impl dataSourceService2;
	
	@Autowired
	Environment env;
	
	public Result validateAccount(Integer accountNumber, List<String> sourceName) {
		Result result = new Result();
		String allowedSources = env.getProperty("source.name");
		List<String> allowedSourceList = Arrays.asList(StringUtils.split(allowedSources, ","));
		if (CollectionUtils.isEmpty(sourceName)) {
			result.addResult(new ValidationResponse(Constants.SOURCE_1, isValidDataSource1(accountNumber)));
			result.addResult(new ValidationResponse(Constants.SOURCE_2, isValidDataSource2(accountNumber)));
		} else {
			if(CollectionUtils.containsAny(sourceName, allowedSourceList)){
			if (sourceName.contains(Constants.SOURCE_1)) {
				result.addResult(new ValidationResponse(Constants.SOURCE_1, isValidDataSource1(accountNumber)));
			}
			if (sourceName.contains(Constants.SOURCE_2)) {
				result.addResult(new ValidationResponse(Constants.SOURCE_2, isValidDataSource2(accountNumber)));
			}
			} else {
				result.addResult(new ValidationResponse(Constants.SOURCE_NOT_FOUND, Boolean.FALSE));
			}
		
		}
		return result;
	}


	private boolean isValidDataSource1(int accountNumber) {
		Source1 source1 = dataSourceService1.getData(accountNumber);
		return source1.contains(accountNumber);
	}


	private boolean isValidDataSource2(int accountNumber) {
		Source2 source2 = dataSourceService2.getData(accountNumber);
		return source2.contains(accountNumber);
	}
	
	

}
