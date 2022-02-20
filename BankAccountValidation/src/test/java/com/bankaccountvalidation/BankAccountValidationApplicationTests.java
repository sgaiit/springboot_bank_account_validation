package com.bankaccountvalidation;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bankaccountvalidation.controller.AccountController;
import com.bankaccountvalidation.model.AccountDetails;
import com.bankaccountvalidation.model.Source1;
import com.bankaccountvalidation.model.Source2;
import com.bankaccountvalidation.service.DataSourceService1Impl;
import com.bankaccountvalidation.service.DataSourceService2Impl;
import com.bankaccountvalidation.service.ValidationServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
class BankAccountValidationApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ValidationServiceImpl validationServiceImpl;
	
	@InjectMocks
	private AccountController accountController;
	
	private Source1 source1 = createTestDataSource1();
	
	private Source2 source2 = createTestDataSource2();
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
	}

	private Source1 createTestDataSource1() {
		AccountDetails accountDetails1 = new AccountDetails(12345678); 
		AccountDetails accountDetails2 = new AccountDetails(12345679); 
		AccountDetails accountDetails3 = new AccountDetails(12345670); 
		List<AccountDetails> accountDetailsList = new ArrayList<>();
		accountDetailsList.add(accountDetails1);
		accountDetailsList.add(accountDetails2);
		accountDetailsList.add(accountDetails3); 
		return new Source1("source1",accountDetailsList);
	}
	
	private Source2 createTestDataSource2() {
		AccountDetails accountDetails1 = new AccountDetails(12345678); 
		AccountDetails accountDetails5 = new AccountDetails(12345677); 
		AccountDetails accountDetails6 = new AccountDetails(12345676); 
		List<AccountDetails> accountDetailsList2 = new ArrayList<>();
		accountDetailsList2.add(accountDetails1);
		accountDetailsList2.add(accountDetails5);
		accountDetailsList2.add(accountDetails6); 
		return new Source2("source2",accountDetailsList2);	
	}

	@Test
	void testValidateAccountWithoutSource() throws Exception {
		ClassLoader classLoader = this.getClass().getClassLoader();
		File requestFile = new File(classLoader.getResource("requestWithoutSource.json").getFile());
		String resquestWithoutSource = new String(Files.readAllBytes(requestFile.toPath()));
		DataSourceService1Impl mockDataSourceService1Impl = mock(DataSourceService1Impl.class);
		DataSourceService2Impl mockDataSourceService2Impl = mock(DataSourceService2Impl.class);
		FieldUtils.writeField(validationServiceImpl, "dataSourceService1", mockDataSourceService1Impl, true);
		FieldUtils.writeField(validationServiceImpl, "dataSourceService2", mockDataSourceService2Impl, true);
		doReturn(source1).when(mockDataSourceService1Impl).getData(anyInt());
		doReturn(source2).when(mockDataSourceService2Impl).getData(anyInt());
		MvcResult mvcResult = mockMvc
		.perform(post("/account/validateAccount")
		.contentType(MediaType.APPLICATION_JSON)
		.content(resquestWithoutSource))
		.andExpect(status().isOk())
		.andReturn();
		
		File responseFile = new File(classLoader.getResource("responseWithoutSource.json").getFile());
		String responseWithoutSource = new String(Files.readAllBytes(responseFile.toPath()));
		
		JSONAssert.assertEquals(responseWithoutSource, mvcResult.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	void testValidateAccountWithSource1() throws Exception {
		ClassLoader classLoader = this.getClass().getClassLoader();
		File requestFile = new File(classLoader.getResource("requestWithSource1.json").getFile());
		String resquestWithoutSource = new String(Files.readAllBytes(requestFile.toPath()));
		DataSourceService1Impl mockDataSourceService1Impl = mock(DataSourceService1Impl.class);
		DataSourceService2Impl mockDataSourceService2Impl = mock(DataSourceService2Impl.class);
		FieldUtils.writeField(validationServiceImpl, "dataSourceService1", mockDataSourceService1Impl, true);
		FieldUtils.writeField(validationServiceImpl, "dataSourceService2", mockDataSourceService2Impl, true);
		doReturn(source1).when(mockDataSourceService1Impl).getData(anyInt());
		doReturn(source2).when(mockDataSourceService2Impl).getData(anyInt());
		MvcResult mvcResult = mockMvc
		.perform(post("/account/validateAccount")
		.contentType(MediaType.APPLICATION_JSON)
		.content(resquestWithoutSource))
		.andExpect(status().isOk())
		.andReturn();
		
		File responseFile = new File(classLoader.getResource("responseWithSource1.json").getFile());
		String responseWithoutSource = new String(Files.readAllBytes(responseFile.toPath()));
		
		JSONAssert.assertEquals(responseWithoutSource, mvcResult.getResponse()
				.getContentAsString(), false);	
	}
	
	@Test
	void testValidateAccountWithSource2() throws Exception {
		ClassLoader classLoader = this.getClass().getClassLoader();
		File requestFile = new File(classLoader.getResource("requestWithSource2.json").getFile());
		String resquestWithoutSource = new String(Files.readAllBytes(requestFile.toPath()));
		DataSourceService1Impl mockDataSourceService1Impl = mock(DataSourceService1Impl.class);
		DataSourceService2Impl mockDataSourceService2Impl = mock(DataSourceService2Impl.class);
		FieldUtils.writeField(validationServiceImpl, "dataSourceService1", mockDataSourceService1Impl, true);
		FieldUtils.writeField(validationServiceImpl, "dataSourceService2", mockDataSourceService2Impl, true);
		doReturn(source1).when(mockDataSourceService1Impl).getData(anyInt());
		doReturn(source2).when(mockDataSourceService2Impl).getData(anyInt());
		MvcResult mvcResult = mockMvc
		.perform(post("/account/validateAccount")
		.contentType(MediaType.APPLICATION_JSON)
		.content(resquestWithoutSource))
		.andExpect(status().isOk())
		.andReturn();
		
		File responseFile = new File(classLoader.getResource("responseWithSource2.json").getFile());
		String responseWithoutSource = new String(Files.readAllBytes(responseFile.toPath()));
		
		JSONAssert.assertEquals(responseWithoutSource, mvcResult.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	void testValidateAccountWithWrongSource() throws Exception {
		ClassLoader classLoader = this.getClass().getClassLoader();
		File requestFile = new File(classLoader.getResource("requestWithWrongSource.json").getFile());
		String resquestWithoutSource = new String(Files.readAllBytes(requestFile.toPath()));
		DataSourceService1Impl mockDataSourceService1Impl = mock(DataSourceService1Impl.class);
		DataSourceService2Impl mockDataSourceService2Impl = mock(DataSourceService2Impl.class);
		FieldUtils.writeField(validationServiceImpl, "dataSourceService1", mockDataSourceService1Impl, true);
		FieldUtils.writeField(validationServiceImpl, "dataSourceService2", mockDataSourceService2Impl, true);
		doReturn(source1).when(mockDataSourceService1Impl).getData(anyInt());
		doReturn(source2).when(mockDataSourceService2Impl).getData(anyInt());
		MvcResult mvcResult = mockMvc
		.perform(post("/account/validateAccount")
		.contentType(MediaType.APPLICATION_JSON)
		.content(resquestWithoutSource))
		.andExpect(status().isOk())
		.andReturn();
		
		File responseFile = new File(classLoader.getResource("responseForWrongSource.json").getFile());
		String responseWithoutSource = new String(Files.readAllBytes(responseFile.toPath()));
		
		JSONAssert.assertEquals(responseWithoutSource, mvcResult.getResponse()
				.getContentAsString(), false);
	}

}
