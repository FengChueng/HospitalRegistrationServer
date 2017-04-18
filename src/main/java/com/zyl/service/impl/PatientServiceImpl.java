package com.zyl.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Appointment;
import com.zyl.domain.Doctor;
import com.zyl.domain.DoctorSchedule;
import com.zyl.domain.Patient;
import com.zyl.exception.ValidException;
import com.zyl.jpa.AppointmentDAO;
import com.zyl.jpa.DoctorDAO;
import com.zyl.jpa.PatientDAO;
import com.zyl.service.PatientService;
import com.zyl.utils.DateUtil;

@Repository
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientDAO patientDAO;
	
	@Autowired
	private DoctorDAO doctorDAO;
	
	@Autowired
	private AppointmentDAO appointmentDAO;

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void patientRegister(Patient newPatient) throws ValidException {
		Patient patient = patientDAO.findOne(newPatient.getPatientAccount());
		if(patient!=null){
			throw new ValidException("patient", "账号已注册");
		}
		patientDAO.saveAndFlush(newPatient);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Patient queryByPatientId(String patientId) throws ValidException {
		Patient patient = patientDAO.findOne(patientId);
		return patient;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void modifyPatientPwd(String patientId, String oldPwd, String newPwd) throws ValidException {
		Patient patient = patientDAO.findOne(patientId);
		if(patient == null){
			throw new ValidException("patient", "账号未注册");
		}
		
		if(!oldPwd.equals(patient.getPassword())){
			throw new ValidException("patient", "密码错误");
		}
		patient.setPassword(newPwd);
		patientDAO.saveAndFlush(patient);
		
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void resetPatientPwd(String patientId, String newPwd) throws ValidException {
		Patient patient = patientDAO.findOne(patientId);
		if(patient == null){
			throw new ValidException("patient", "账号未注册");
		}
		patient.setPassword(newPwd);
		patientDAO.saveAndFlush(patient);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void modifyPatientInfo(String patientId,String realName,int sex,long birthDay,String portraint) throws ValidException {
		Patient patient = patientDAO.findOne(patientId);
		if(patient == null){
			throw new ValidException("patient", "账号未注册");
		}
		if(realName!=null&&"".equals(realName)){
			patient.setRealName(realName);
		}
		
		if(birthDay!=0){
			patient.setBirthDay(birthDay);
			patient.setAge(DateUtil.getAge(birthDay));
		}
		if(sex==0||sex==1){
			patient.setSex(sex);
		}
		
		if(portraint!=null&&"".equals(portraint)){
			patient.setPortraint(portraint);
		}
		patientDAO.saveAndFlush(patient);
	}

	@Override
	public Patient login(String patientId, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}
}
