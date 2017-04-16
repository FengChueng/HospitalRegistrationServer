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


public class AccountTest extends BaseTest{
	@Autowired
	private AccountService accountService;
	
	private final Log logger = LogFactory.getLog(getClass());
	private String mobilePhone = "18380586504";
	private String name = "张三";
	
//	@Before
//	public void before(){
//		accountService = SpringUtil.getBean(AccountService.class);
//	}
	
	@Test
	public void register() {
		try {
			accountService.registerAccount(mobilePhone, "123456", 0);
		} catch (ValidException e) {
			logger.error(e);
		}
	}
	
	@Test @Ignore
	public void updateAccountInfo(){
		
		try {
			accountService.updatePwd(mobilePhone,"123456");
		} catch (ValidException e) {
			e.printStackTrace();
		}
		//绑定角色表,病人,医生
	}
	

}
