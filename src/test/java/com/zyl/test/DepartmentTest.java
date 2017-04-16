package com.zyl.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zyl.BaseTest;
import com.zyl.exception.ValidException;
import com.zyl.service.AccountService;
import com.zyl.utils.DateUtil;


public class DepartmentTest extends BaseTest{
	@Autowired
	private AccountService accountService;
	
	private final Log logger = LogFactory.getLog(getClass());
	private String mobilePhone = "12345678901";
	private String name = "张三";
	
//	@Before
//	public void before(){
//		accountService = SpringUtil.getBean(AccountService.class);
//	}
	
	@Test @Ignore
	public void register() {
		try {
			accountService.registerAccount(mobilePhone, "123456", 0);
		} catch (ValidException e) {
			logger.error(e);
		}
	}
	

}
