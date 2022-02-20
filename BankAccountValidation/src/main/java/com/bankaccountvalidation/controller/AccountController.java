package com.bankaccountvalidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankaccountvalidation.model.AccountRequest;
import com.bankaccountvalidation.model.Result;
import com.bankaccountvalidation.service.ValidationServiceImpl;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private ValidationServiceImpl validationService;

	@PostMapping("/validateAccount")
	public Result validateAccount(@RequestBody AccountRequest accountRequest) {
		 return validationService.validateAccount(accountRequest.getAccountNumber(), accountRequest.getSources());
		
	}
}
