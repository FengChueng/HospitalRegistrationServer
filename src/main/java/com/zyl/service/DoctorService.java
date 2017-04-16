package com.zyl.service;

import java.util.List;

import com.zyl.domain.Doctor;
import com.zyl.exception.ValidException;

public interface DoctorService {
	/**
	 * 根据deptId添加单个医生
	 * @param hospitalId
	 * @param department
	 */
	void addDoctorByDeptId(String deptId,Doctor doctor);
	
	/**
	 * 根据deptId添加多个医生
	 */
	void addDoctorsBydeptId(String deptId,List<Doctor> doctors);
	
	/**
	 * 根据doctorId查询
	 * @param doctorId
	 * @throws ValidException 
	 */
	Doctor queryDoctorByDoctorId(String doctorId) throws ValidException;
	
	/**
	 * 根据姓名查询
	 * @param name
	 * @return
	 * @throws ValidException 
	 */
	Doctor queryDoctorByName(String name) throws ValidException;
	
	/**
	 * 根据账号id查询
	 * @param accountId
	 * @return
	 */
	Doctor queryDoctorByAccountId(String accountId);
	
	/**
	 * 根据deptId查询多个医生
	 */
	List<Doctor> queryDoctorsByDeptId(String deptId); 
	
	
	
}
