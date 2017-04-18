package com.zyl.service;

import com.zyl.domain.Patient;
import com.zyl.exception.ValidException;

public interface PatientService {
	
	Patient login(String patientId,String pwd);
	
	Patient queryByPatientId(String patientId) throws ValidException;

	void patientRegister(Patient newPatient) throws ValidException;
	
	void modifyPatientPwd(String patientId,String oldPwd,String newPwd) throws ValidException;
	
	void resetPatientPwd(String patientId,String newPwd) throws ValidException;
	
	void modifyPatientInfo(String patientId, String realName, int sex, long birthDay, String portraint)
			throws ValidException;
}	
