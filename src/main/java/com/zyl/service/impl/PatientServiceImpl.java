package com.zyl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.zyl.domain.Patient;
import com.zyl.exception.ValidException;
import com.zyl.jpa.PatientDAO;
import com.zyl.service.PatientService;
import com.zyl.utils.Constant;
import com.zyl.utils.DateUtil;

@Repository
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientDAO patientDAO;
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Patient register(String patientAccount, String pwd) throws ValidException {
		Patient patient = patientDAO.findOne(patientAccount);
		if(patient!=null){
			throw new ValidException("patient", "账号已注册");
		}
		patient = new Patient();
		patient.setPatientAccount(patientAccount);
		patient.setMobilePhone(patientAccount);
		patient.setPassword(pwd);
		patientDAO.saveAndFlush(patient);
		
		
		return new Patient(patientAccount,pwd);
	}
	
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Patient login(String patientId, String pwd) throws ValidException {
		Patient patient = patientDAO.findOne(patientId);
		if(patient == null){
			throw new ValidException("patient", "账号未注册");
		}
		
		if(!pwd.equals(patient.getPassword())){
			throw new ValidException("patient", "密码错误");
		}
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
	public void modifyPatientInfo(String patientId,String realName,Integer sex,Long birthDay,String portraint,String mobilePhone) throws ValidException {
		Patient patient = patientDAO.findOne(patientId);
		if(patient == null){
			throw new ValidException("patient", "账号未注册");
		}
		if(!StringUtils.isEmpty(realName)){
			patient.setRealName(realName);
		}
		
		if(birthDay!=null){
			patient.setBirthDay(birthDay);
			patient.setAge(DateUtil.getAge(birthDay));
		}
		if(sex != null){
			patient.setSex(sex);
		}
		
		if(!StringUtils.isEmpty(mobilePhone)){
			patient.setMobilePhone(mobilePhone);
		}
		
		if(!StringUtils.isEmpty(portraint)){
			patient.setPortraint(portraint);
		}
		patientDAO.saveAndFlush(patient);
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Patient queryByPatientId(String patientId) throws ValidException {
		Patient patient = patientDAO.findOne(patientId);
		if(patient==null){
			throw new ValidException("patient", "账号未注册");
		}
		return patient;
	}

}
