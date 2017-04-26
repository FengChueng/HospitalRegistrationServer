package com.zyl.service;

import com.zyl.domain.Patient;
import com.zyl.exception.ValidException;

public interface PatientService {
	
	Patient login(String patientId,String pwd) throws ValidException;
	
	Patient register(String patientId,String pwd) throws ValidException;
	
	Patient queryByPatientId(String patientId) throws ValidException;

	void modifyPatientPwd(String patientId,String oldPwd,String newPwd) throws ValidException;
	
	void resetPatientPwd(String patientId,String newPwd) throws ValidException;

	void modifyPatientInfo(String patientId, String realName, Integer sex, Long birthDay, String portraint,
			String mobilePhone) throws ValidException;

}	
