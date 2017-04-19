package com.zyl.service;

import java.util.List;

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
	Department queryOneByHospitalNameAndDepartName(String hospitalName,String departName) throws ValidException;
	
	Department queryOneByHospitalIdAndDepartName(String hospitalId,String departName) throws ValidException;
	
	/**
	 * 根据hospitalId查询所有
	 * @param hospitalId
	 * @param page
	 * @return
	 */
	List<Department> queryAllByHospitalId(String hospitalId) throws ValidException;

	/**
	 * 根据id查询
	 * @param deptId
	 * @return
	 * @throws ValidException
	 */
	Department queryOneDepartId(String deptId) throws ValidException;
	
}
