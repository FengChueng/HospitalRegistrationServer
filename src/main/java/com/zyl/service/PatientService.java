package com.zyl.service;

import com.zyl.domain.Patient;
import com.zyl.exception.ValidException;

public interface PatientService {
	
	void bindAccountByMobilePhone(String mobilePhone,Patient patient) throws ValidException;
	
	void bindAccountById(String accountId,Patient patient) throws ValidException;
	
	/**
	 * 修改信息
	 * @param mobilePhone
	 * @param name
	 * @param age
	 * @param sex
	 * @param birthDay
	 */
	void updateInfoByMobilePhone(String mobilePhone,String name,int age,int sex,long birthDay) throws ValidException;
	
	void updateInfoById(String accountId,String name,int age,int sex,long birthDay) throws ValidException;
	
	Patient queryByPatientId(String patientId) throws ValidException;
	
	Patient queryByAccountId(String accountId) throws ValidException;
	
	
}	
