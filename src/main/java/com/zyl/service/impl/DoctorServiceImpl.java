package com.zyl.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.zyl.domain.Department;
import com.zyl.domain.Doctor;
import com.zyl.exception.ValidException;
import com.zyl.jpa.DepartmentDAO;
import com.zyl.jpa.DoctorDAO;
import com.zyl.service.DoctorService;
import com.zyl.utils.Constant;
import com.zyl.utils.DateUtil;

@Repository
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDAO doctorDAO;

	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public Doctor login(String doctorAccount, String pwd) throws ValidException {
		Doctor doctor = doctorDAO.findOne(doctorAccount);
		if (doctor == null) {
			throw new ValidException("doctor", "账号未注册");
		}

		if (!pwd.equals(doctor.getPassword())) {
			throw new ValidException("doctor", "密码错误");
		}
		return doctor;
	}

	@Override
	public void modifyDoctorPwd(String doctorAccount, String oldPwd, String newPwd) throws ValidException {
		Doctor doctor = doctorDAO.findOne(doctorAccount);
		if (doctor == null) {
			throw new ValidException("patient", "账号未注册");
		}

		if (!oldPwd.equals(doctor.getPassword())) {
			throw new ValidException("patient", "密码错误");
		}
		doctor.setPassword(newPwd);
		doctorDAO.saveAndFlush(doctor);
	}

	@Override
	public void resetDoctorPwd(String doctorAccount, String newPwd) throws ValidException {
		Doctor doctor = doctorDAO.findOne(doctorAccount);
		if (doctor == null) {
			throw new ValidException("patient", "账号未注册");
		}
		doctor.setPassword(newPwd);
		doctorDAO.saveAndFlush(doctor);
	}

	@Override
	public void modifyDoctorInfo(String doctorAccount, String realName, Integer sex, Long birthDay, String portraint,
			String mobilePhone, String info, Integer level) throws ValidException {
		Doctor doctor = doctorDAO.findOne(doctorAccount);
		if (doctor == null) {
			throw new ValidException("patient", "账号未注册");
		}
		if (StringUtils.isEmpty(realName)) {
			doctor.setRealName(realName);
		}

		if (birthDay != 0) {
			doctor.setBirthDay(birthDay);
			doctor.setAge(DateUtil.getAge(birthDay));
		}
		if (sex == Constant.SEX_FEMALE || sex == Constant.SEX_MALE) {
			doctor.setSex(sex);
		}

		if (mobilePhone != null && mobilePhone.length() > 7) {
			doctor.setMobilePhone(mobilePhone);
		}

		if (StringUtils.isEmpty(portraint)) {
			doctor.setPortraint(portraint);
		}
		
		if(StringUtils.isEmpty(doctor)){
			doctor.setInfo(info);
		}
		
		if(level!=0){
			doctor.setLevel(level);
		}

		doctorDAO.saveAndFlush(doctor);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void addDoctorByDeptId(String deptId, Doctor doctor) {

	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void addDoctorsBydeptId(String deptId, List<Doctor> doctors) {

	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public Doctor queryDoctorByDoctorAccount(String doctorId) throws ValidException {
		Doctor doctor = doctorDAO.findOne(doctorId);
		if (doctor == null) {
			throw new ValidException("doctor", "不存在该医生");
		}
		return doctor;
	}


	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public List<Doctor> queryDoctorLikeName(String name) throws ValidException {
		List<Doctor> doctors = doctorDAO.findByRealNameLike(name);
		if (doctors == null || doctors.size() == 0) {
			throw new ValidException("doctor", "没有查询到符合条件");
		}
		return doctorDAO.findByRealNameLike(name);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public List<Doctor> queryDoctorsByDeptId(String deptId) throws ValidException {
		Department department = departmentDAO.findOne(deptId);
		if (department == null) {
			throw new ValidException("doctor", "没有查询到符合条件");
		}
		Set<Doctor> doctors = department.getDoctors();
		if (doctors == null) {
			throw new ValidException("doctor", "没有查询到符合条件");
		} 
		return new ArrayList<Doctor>(doctors);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public Doctor queryByDeptIdAndName(String deptId, String docName) throws ValidException {
		Department department = departmentDAO.findOne(deptId);
		if (department == null) {
			throw new ValidException("doctor", "没有查询到符合条件");
		}
		Set<Doctor> doctors = department.getDoctors();
		if (doctors != null && doctors.size() != 0) {
			for (Doctor doctor : doctors) {
				if (docName.equals(doctors)) {
					return doctor;
				}
			}
		} else {
			throw new ValidException("doctor", "没有查询到符合条件");
		}
		return null;
	}
}
