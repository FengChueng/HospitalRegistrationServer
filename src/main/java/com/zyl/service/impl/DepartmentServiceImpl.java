package com.zyl.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.zyl.domain.Department;
import com.zyl.domain.Hospital;
import com.zyl.exception.ValidException;
import com.zyl.jpa.DepartmentDAO;
import com.zyl.jpa.HospitalDAO;
import com.zyl.service.DepartmentService;

@Repository
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private HospitalDAO hospitalDAO;
	
	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void addDepartmentByHospitalName(String hospitalName, Department newDepartment) throws ValidException {
		Department department = departmentDAO.findByDeptName(newDepartment.getDeptName());
		if(department==null){
			Hospital hospital = hospitalDAO.findByHospitalName(hospitalName);
			
			Set<Department> departments = hospital.getDepartments();
			if(CollectionUtils.isEmpty(departments)){//列表为空
				departments = new HashSet<>();
			}else{
				departments.add(department);
			}
			hospital.setDepartments(departments);
			hospitalDAO.saveAndFlush(hospital);
		}else{
			throw new ValidException("department", "该科室已存在");
		}
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void addDepartmentsByHospitalName(String hospitalId, List<Department> departments) {
		
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Department queryOneByHospitalNameAndDeparName(String hospitalName, String departName) throws ValidException {
		
		Hospital hospital = hospitalDAO.findByHospitalName(hospitalName);
		if(hospital==null){
			throw new ValidException("department", "不存在该医院");
		}
		
		Set<Department> departments = hospital.getDepartments();
		if(CollectionUtils.isEmpty(departments)){//不存在
			throw new ValidException("department", "不存在该科室");
		}
		
		for (Department department : departments) {
			if(departName.equals(department.getDeptName())){
				return department;
			}
		}
		return null;
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Department queryOneByHospitalIdAndDeparName(String hospitalId, String departName) throws ValidException {
		Hospital hospital = hospitalDAO.findOne(hospitalId);
		if(hospital==null){
			throw new ValidException("department", "不存在该医院");
		}
		
		Set<Department> departments = hospital.getDepartments();
		if(CollectionUtils.isEmpty(departments)){//不存在
			throw new ValidException("department", "不存在该科室");
		}
		
		for (Department department : departments) {
			if(departName.equals(department.getDeptName())){
				return department;
			}
		}
		return null;
	}
	

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Page<Department> queryAllByHospitalId(String hospitalId, Pageable pageable) {
		
		
		
		
		return null;
	}

	

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Department queryAllByHospitalName(String hospitalName) throws ValidException {
		// TODO Auto-generated method stub
		return null;
	}

}
