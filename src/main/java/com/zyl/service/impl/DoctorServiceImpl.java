package com.zyl.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Department;
import com.zyl.domain.Doctor;
import com.zyl.exception.ValidException;
import com.zyl.jpa.DepartmentDAO;
import com.zyl.jpa.DoctorDAO;
import com.zyl.service.DoctorService;

@Repository
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorDAO doctorDAO;
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void addDoctorByDeptId(String deptId, Doctor doctor) {
		
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void addDoctorsBydeptId(String deptId, List<Doctor> doctors) {
		
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
	public Doctor queryDoctorByAccountId(String doctorId) throws ValidException {
		Doctor doctor = doctorDAO.findOne(doctorId);
		if(doctor == null){
			throw new ValidException("doctor", "没有查询到符合条件");
		}
		return doctor;
	}
	
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public List<Doctor> queryDoctorLikeName(String name) throws ValidException{
		List<Doctor> doctors = doctorDAO.findByRealNameLike(name);
		if(doctors==null||doctors.size()==0){
			throw new ValidException("doctor", "没有查询到符合条件");
		}
		return doctorDAO.findByRealNameLike(name);
	}

	

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public List<Doctor> queryDoctorsByDeptId(String deptId) throws ValidException {
		Department department = departmentDAO.findOne(deptId);
		if(department == null){
			throw new ValidException("doctor", "没有查询到符合条件");
		}
		Set<Doctor> doctors = department.getDoctors();
		if(doctors==null){
			return null;
		}else{
			return new ArrayList<Doctor>(doctors);
		}
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Doctor queryByDeptIdAndName(String deptId,String docName) throws ValidException{
		Department department = departmentDAO.findOne(deptId);
		if(department==null){
			throw new ValidException("doctor", "没有查询到符合条件");
		}
		Set<Doctor> doctors = department.getDoctors();
		if(doctors != null && doctors.size()!=0){
			for (Doctor doctor : doctors) {
				if(docName.equals(doctors)){
					return doctor;
				}
			}
		}else{
			throw new ValidException("doctor", "没有查询到符合条件");
		}
		return null;
	}
}
