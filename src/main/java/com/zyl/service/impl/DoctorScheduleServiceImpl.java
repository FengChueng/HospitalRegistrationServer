package com.zyl.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.zyl.domain.Doctor;
import com.zyl.domain.DoctorSchedule;
import com.zyl.exception.ValidException;
import com.zyl.jpa.DoctorDAO;
import com.zyl.jpa.DoctorScheduleDAO;
import com.zyl.service.DoctorScheduleService;
@Repository
public class DoctorScheduleServiceImpl implements DoctorScheduleService{

	@Autowired
	private DoctorDAO doctorDAO;
	
	@Autowired
	private DoctorScheduleDAO doctorScheduleDAO;
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void addScheduleByDoctorAccount(String doctorAccount,int status,int maxAppointmentCount,long scheduleDate) throws ValidException {
		Doctor doctor = doctorDAO.findOne(doctorAccount);
		if(doctor == null){
			throw new ValidException("doctor_schedule", "无该医生信息");
		}
		Set<DoctorSchedule> doctorSchedules = doctor.getDoctorSchedules();

		if(doctorSchedules == null){
			doctorSchedules = new HashSet<>();
		}
		DoctorSchedule doctorSchedule = new DoctorSchedule();
		doctorSchedule.setScheduleDate(scheduleDate);
		doctorSchedule.setStatus(status);
		doctorSchedule.setMaxAppointmentCount(maxAppointmentCount);
		doctorSchedules.add(doctorSchedule);
		doctorDAO.saveAndFlush(doctor);
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void updateScheduleById(String scheduleId,int status,long scheduleDate) throws ValidException{
		
		DoctorSchedule doctorSchedule = doctorScheduleDAO.findOne(scheduleId);
		if(doctorSchedule==null){
			throw new ValidException("doctor_schedule", "没有工作日程");
		}
		
		DoctorSchedule doctorSchedule2 = doctorScheduleDAO.findByScheduleDate(scheduleDate);
		if(doctorSchedule2 != null){
			throw new ValidException("doctor_schedule", "当天已有工作安排");
		}
		doctorSchedule.setStatus(status);
		doctorSchedule.setScheduleDate(scheduleDate);
		doctorScheduleDAO.saveAndFlush(doctorSchedule);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public List<DoctorSchedule> queryAllScheduleByDoctorAccount(String doctorAccount) throws ValidException {
		Doctor doctor = doctorDAO.findOne(doctorAccount);
		if(doctor == null){
			throw new ValidException("doctor_schedule", "医生不存在");
		}
		Set<DoctorSchedule> doctors = doctor.getDoctorSchedules();
		if(CollectionUtils.isEmpty(doctors)){
			throw new ValidException("doctor_schedule", "没有工作日程");
		}else{
			return new ArrayList<>(doctors);
		}
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public DoctorSchedule queryScheduleById(String doctorScheduleId) throws ValidException {
		DoctorSchedule doctorSchedule = doctorScheduleDAO.findOne(doctorScheduleId);
		if(doctorSchedule==null){
			throw new ValidException("doctor_schedule", "没有工作日程");
		}
		return doctorSchedule;
	}
}
