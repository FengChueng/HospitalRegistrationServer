package com.zyl.test;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zyl.BaseTest;
import com.zyl.domain.Appointment;
import com.zyl.domain.Doctor;
import com.zyl.domain.Patient;
import com.zyl.exception.ValidException;
import com.zyl.jpa.AppointmentDAO;
import com.zyl.service.AccountService;
import com.zyl.service.AppointmentService;
import com.zyl.service.DoctorService;
import com.zyl.service.PatientService;
import com.zyl.utils.DateUtil;

public class PatientTest extends BaseTest{
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Test 
	public void addAccount(){
		String mobilePhone = "18380586504";
		String password = "123456";
		int role = 0;
		
		Date birthDay = DateUtil.parseStrToDate("1995-09-27");
		int age = DateUtil.getAge(birthDay);
		Patient patient = new Patient();
		patient.setRealName("张应龙");
		patient.setSex(0);
		patient.setMobilePhone(mobilePhone);
		patient.setAge(age);
		patient.setBirthDay(birthDay.getTime());
		
		try {
			//accountService.registerAccount(mobilePhone, password, role);
			patientService.bindAccountByMobilePhone(mobilePhone,patient);
		} catch (ValidException e) {
			e.printStackTrace();
		}
	}
	
	@Test//预约
	public void addAppointment(){
		Appointment appointment = new Appointment();
		appointment.setPrice(100);
		appointment.setStatus(0);
		appointment.setAppointDate(new Date().getTime());
		appointment.setClinicDate(new Date().getTime());
		
		try {
			Patient patient = patientService.queryByPatientId("fa5710e3-a55f-4c9e-8984-f8be7b453d8b");
			Doctor doctor = doctorService.queryDoctorByDoctorId("025b493e-617f-4d6e-94c8-ef74fc24c518");
			appointmentService.makeAppointment(appointment, patient, doctor);
		} catch (ValidException e) {
			e.printStackTrace();
		}
	}
}
