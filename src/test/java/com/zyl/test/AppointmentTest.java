package com.zyl.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;

import com.zyl.BaseTest;
import com.zyl.exception.ValidException;
import com.zyl.utils.DateUtil;


public class AppointmentTest extends BaseTest{
	
	
	private final Log logger = LogFactory.getLog(getClass());
	private String mobilePhone = "12345678901";
	private String name = "张三";
	
//	@Before
//	public void before(){
//		accountService = SpringUtil.getBean(AccountService.class);
//	}
	
	@Test @Ignore
	public void updateAccountInfo(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;
		try {
			date = dateFormat.parse("1995-9-27");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		int age = DateUtil.getAge(date);//根据出生日期计算年龄
		int sex = 0;
		long birthDay = date==null?0:date.getTime();
//		try {
//			
//		} catch (ValidException e) {
//			e.printStackTrace();
//		}
		
		//绑定角色表,病人,医生
	}
	

}
