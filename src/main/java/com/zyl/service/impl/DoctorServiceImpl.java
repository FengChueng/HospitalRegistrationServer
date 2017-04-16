package com.zyl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Account;
import com.zyl.domain.Doctor;
import com.zyl.domain.Patient;
import com.zyl.exception.ValidException;
import com.zyl.jpa.AccountDAO;
import com.zyl.jpa.DoctorDAO;
import com.zyl.jpa.PatientDAO;
import com.zyl.service.AccountService;
import com.zyl.service.DoctorService;
import com.zyl.service.PatientService;

@Repository
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private DoctorDAO doctorDAO;

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void addDoctorByDeptId(String deptId, Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void addDoctorsBydeptId(String deptId, List<Doctor> doctors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Doctor queryDoctorByDoctorId(String doctorId) throws ValidException {
		Doctor doctor = doctorDAO.findOne(doctorId);
		if(doctor == null){
			throw new ValidException("doctor", "不存在该医生");
		}
		return doctor;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Doctor queryDoctorByName(String name) throws ValidException {
		Doctor doctor = doctorDAO.findByRealName(name);
		if(doctor == null){
			throw new ValidException("doctor", "不存在该医生");
		}
		return doctor;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Doctor queryDoctorByAccountId(String accountId) {
		
		return null;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public List<Doctor> queryDoctorsByDeptId(String deptId) {
		// TODO Auto-generated method stub
		return null;
	}

}
