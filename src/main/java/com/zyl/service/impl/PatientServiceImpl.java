package com.zyl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Account;
import com.zyl.domain.Patient;
import com.zyl.exception.ValidException;
import com.zyl.jpa.AccountDAO;
import com.zyl.jpa.PatientDAO;
import com.zyl.service.AccountService;
import com.zyl.service.PatientService;

@Repository
public class PatientServiceImpl implements PatientService{

	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private PatientDAO patientDAO;

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void bindAccountByMobilePhone(String mobilePhone, Patient newPatient) throws ValidException {
		Account account = accountDAO.findByMobilePhone(mobilePhone);
		Patient patient = patientDAO.findByMobilePhone(mobilePhone);
		if(account == null){
			throw new ValidException("patient", "账号未注册");
		}
		
		if(patient!=null){
			throw new ValidException("patient", "账号已注册");
		}
		
		newPatient.setAccount(account);
		patientDAO.saveAndFlush(newPatient);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void bindAccountById(String accountId, Patient patient) throws ValidException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void updateInfoByMobilePhone(String mobilePhone, String name, int age, int sex, long birthDay)
			throws ValidException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void updateInfoById(String accountId, String name, int age, int sex, long birthDay) throws ValidException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Patient queryByPatientId(String patientId) throws ValidException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Patient queryByAccountId(String accountId) throws ValidException {
		// TODO Auto-generated method stub
		return null;
	}

}
