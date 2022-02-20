package com.bankaccountvalidation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bankaccountvalidation.model.Source1;

@Component
public class DataSourceService1Impl{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	Environment env;

	
	public Source1 getData(Integer accountNumber) {
		String source1Url = env.getProperty(env.getProperty("env.lifeCycle").concat(".").concat("source1.url"));
		source1Url = source1Url + "/" + accountNumber;
		return restTemplate.getForObject(source1Url, Source1.class);
	}
	
	

}
