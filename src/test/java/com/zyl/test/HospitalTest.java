package com.zyl.test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.BaseTest;
import com.zyl.domain.Account;
import com.zyl.domain.Department;
import com.zyl.domain.Doctor;
import com.zyl.domain.DoctorSchedule;
import com.zyl.domain.Hospital;
import com.zyl.exception.ValidException;
import com.zyl.service.HospitalService;
import com.zyl.utils.DateUtil;


public class HospitalTest extends BaseTest{
	@Autowired
	private HospitalService hospitalService;
	
	private final Log logger = LogFactory.getLog(getClass());
	
//	@Before
//	public void before(){
//		accountService = SpringUtil.getBean(AccountService.class);
//	}
	
	@Test
	@Transactional
	public void insertHospital() {
		try {
			//科室
			Set<Department> departments = new HashSet<>();
			for (int i = 0; i < 10; i++) {
				Department department = new Department();
				department.setCreateDate(DateUtil.StrToDate("2010-10-20 00:00:00").getTime());
				department.setDeptName("科室"+i);
				department.setInfo("科室"+i+"简介");
				//医生
				Set<Doctor> doctors = new HashSet<>();
				for (int j = 0; j < 5; j++) {
					//账号
					Account account = new Account();
					account.setMobilePhone("100000000"+i+""+j);
					account.setPassword("123456");
					account.setRole(1);//医生
					
					String birthday = "198"+i+"-1-1 00:00:00";
					int age = DateUtil.getAge(birthday);//根据出生日期计算年龄
					Date date = DateUtil.StrToDate(birthday);
					long birthDay = date==null?0:date.getTime();
					
					Set<DoctorSchedule> doctorSchedules = new HashSet<>();
					for (int k = 1; k <= 3; k++) {
						Calendar calendar = Calendar.getInstance();
						calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+k);
						calendar.set(Calendar.HOUR_OF_DAY, 0);
						calendar.set(Calendar.MINUTE, 0);
						calendar.set(Calendar.SECOND, 0);
						long scheduleDate = calendar.getTimeInMillis();
						
						//初始化
						DoctorSchedule doctorSchedule = new DoctorSchedule();
						doctorSchedule.setScheduleDate(scheduleDate);
						doctorSchedule.setStatus(i%2);
						//添加
						doctorSchedules.add(doctorSchedule);
					}	
					
					//初始化
					Doctor doctor = new Doctor();
					doctor.setAccount(account);
					doctor.setAge(age);
					doctor.setBirthDay(birthDay);
					doctor.setLevel(j%2);
					doctor.setMobilePhone(account.getMobilePhone());
					doctor.setInfo("doctor"+j+"简介");
					doctor.setRealName("doctor"+j);
					doctor.setOrderCount(100*j+1);
					doctor.setSex(j%2);
					doctor.setDoctorSchedules(doctorSchedules);
					//添加
					doctors.add(doctor);
				}
				department.setDoctors(doctors);
				//初始化
				departments.add(department);
			}
			
			Hospital hospital = new Hospital();
			hospital.setHospitalName("绵阳精神病院");
			hospital.setLatitude(30.123f);
			hospital.setLongitude(10.123f);
			hospital.setLocation("四川成都");
			hospital.setInfo("hello word");
			hospital.setLevel(3);
			hospital.setGrade("A");
			hospital.setCreateDate(DateUtil.StrToDate("2010-10-20 00:00:00").getTime());
			hospital.setDepartments(departments);
			//插入
			hospitalService.insertHospital(hospital);
		} catch (ValidException e) {
			logger.error(e);
		}
	}
	
	
}
