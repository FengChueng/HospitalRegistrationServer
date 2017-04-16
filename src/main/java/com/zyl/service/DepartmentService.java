package com.zyl.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zyl.domain.Department;
import com.zyl.exception.ValidException;

public interface DepartmentService {
	/**
	 * 根据hospitalName添加单个科室
	 * @param hospitalName
	 * @param department
	 * @throws ValidException 
	 */
	void addDepartmentByHospitalName(String hospitalName,Department department) throws ValidException;
	
	/**
	 * 根据hospitalName添加多个科室
	 */
	void addDepartmentsByHospitalName(String hospitalName,List<Department> departments);
	
	/**
	 * 根据hospitalName和departName查询科室
	 * @param hospitalName
	 * @param departName
	 * @return
	 * @throws ValidException 
	 */
	Department queryOneByHospitalNameAndDeparName(String hospitalName,String departName) throws ValidException;
	
	Department queryOneByHospitalIdAndDeparName(String hospitalId,String departName) throws ValidException;
	
	/**
	 * 根据hospitalId查询所有
	 * @param hospitalId
	 * @param page
	 * @return
	 */
	Department queryAllByHospitalName(String hospitalName) throws ValidException;

	Page<Department> queryAllByHospitalId(String hospitalId, Pageable pageable) throws ValidException;
	
}
