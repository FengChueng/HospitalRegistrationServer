package com.zyl.service;

import java.util.List;

import com.zyl.domain.Doctor;
import com.zyl.exception.ValidException;

public interface DoctorService {

	Doctor login(String doctorAccount, String pwd) throws ValidException;

	void modifyDoctorPwd(String doctorAccount,String oldPwd,String newPwd) throws ValidException;
	
	void resetDoctorPwd(String doctorAccount,String newPwd) throws ValidException;
	
	/**
	 * 
	 * @param doctorAccount
	 * @param realName
	 * @param sex
	 * @param birthDay
	 * @param portraint
	 * @param mobilePhone
	 * @param info
	 * @param level		默认参数0
	 * @throws ValidException
	 */
	void modifyDoctorInfo(String doctorAccount, String realName, Integer sex, Long birthDay, String portraint,
			String mobilePhone, String info, Integer level) throws ValidException;
	
	
	
	/**
	 * 根据deptId添加单个医生
	 * 
	 * @param hospitalId
	 * @param department
	 */
	void addDoctorByDeptId(String deptId, Doctor doctor);

	/**
	 * 根据deptId添加多个医生
	 */
	void addDoctorsBydeptId(String deptId, List<Doctor> doctors);

	/**
	 * 根据doctorId查询
	 * 
	 * @param doctorId
	 * @throws ValidException
	 */
	Doctor queryDoctorByDoctorAccount(String doctorId) throws ValidException;

	/**
	 * 模糊查询
	 * 
	 * @param name
	 * @return
	 * @throws ValidException
	 */
	List<Doctor> queryDoctorLikeName(String name) throws ValidException;

	/**
	 * 根据deptId查询多个医生
	 */
	List<Doctor> queryDoctorsByDeptId(String deptId) throws ValidException;

	Doctor queryByDeptIdAndName(String deptId, String docName) throws ValidException;

}
