package com.bankaccountvalidation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bankaccountvalidation.model.Source2;

@Component
public class DataSourceService2Impl{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Environment env;
	
	public Source2 getData(Integer accountNumber) {
		String source2Url = env.getProperty(env.getProperty("env.lifeCycle").concat(".").concat("source2.url"));
		source2Url = source2Url + "/" + accountNumber;
		return restTemplate.getForObject(source2Url, Source2.class);
	}

}
