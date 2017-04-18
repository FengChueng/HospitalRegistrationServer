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

import com.zyl.domain.Appointment;
import com.zyl.domain.Doctor;
import com.zyl.domain.DoctorSchedule;
import com.zyl.domain.Patient;
import com.zyl.exception.ValidException;
import com.zyl.jpa.AppointmentDAO;
import com.zyl.jpa.DoctorDAO;
import com.zyl.jpa.DoctorScheduleDAO;
import com.zyl.jpa.PatientDAO;
import com.zyl.service.AppointmentService;
import com.zyl.utils.Constant;

@Repository
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentDAO appointmentDAO;
	
	@Autowired
	private PatientDAO patientDAO;
	
	@Autowired
	private DoctorDAO doctorDAO;
	
	@Autowired
	private DoctorScheduleDAO doctorScheduleDAO;
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void startAppointment(String appointId) throws ValidException {
		Appointment appointment = appointmentDAO.findOne(appointId);
		if(appointment == null){
			throw new ValidException("appointment", "该预约不存在");
		}
		appointment.setStatus(Constant.APPOINT_HANDLE_ING);//诊断中
		appointmentDAO.saveAndFlush(appointment);
	}
	

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void completeAppointment(String appointId,String doctorAdvice) throws ValidException {
		Appointment appointment = appointmentDAO.findOne(appointId);
		if(appointment == null){
			throw new ValidException("appointment", "该预约不存在");
		}
		appointment.setStatus(Constant.APPOINT_COMPLETED);//完成
		appointment.setDoctorAdvice(doctorAdvice);
		appointmentDAO.saveAndFlush(appointment);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void cancelAppointment(String appointId) throws ValidException {
		Appointment appointment = appointmentDAO.findOne(appointId);
		if(appointment == null){
			throw new ValidException("appointment", "该预约不存在");
		}
		appointment.setStatus(Constant.APPOINT_CANCEL);//取消		
		appointmentDAO.saveAndFlush(appointment);
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Appointment queryByAppointId(String appointId) throws ValidException{
		Appointment appointment = appointmentDAO.findOne(appointId);
		if(appointment == null){
			throw new ValidException("appointment", "该预约不存在");
		}
		return appointment;
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public List<Appointment> queryByPatientId(String patientId) throws ValidException{
		Patient patient = patientDAO.findOne(patientId);
		if(patient == null){
			throw new ValidException("appointment", "不存在该病人记录");
		}
		Set<Appointment> appointments = patient.getAppointments();
		if(appointments!=null){
			return new ArrayList<>(appointments);
		}
		return null;
	}
	
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public List<Appointment> queryByDoctorId(String doctorId) throws ValidException{
		Doctor doctor = doctorDAO.findOne(doctorId);
		if(doctor == null){
			throw new ValidException("appointment", "不存在该医生记录");
		}
		Set<Appointment> appointments = doctor.getAppointments();
		if(appointments!=null){
			return new ArrayList<>(appointments);
		}
		return null;
		
	}
	
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void makeAppointment(String patientId, String doctorId,String doctorScheduleId ,float price, long clinicDate, long appointDate,
			String location) throws ValidException {
		Patient patient = patientDAO.findOne(patientId);
		if(patient == null){
			throw new ValidException("patient", "用户不存在");
		}
		Doctor doctor = doctorDAO.findOne(doctorId);
		if(doctor == null){
			throw new ValidException("patient", "医生不存在");
		}
		DoctorSchedule doctorSchedule = doctorScheduleDAO.findOne(doctorScheduleId);
		if(doctorSchedule.getStatus()==Constant.DOCTOR_SCHEDULE_POSSIBLE&&
				doctorSchedule.getMaxAppointmentCount()>0){//可以预约
			doctorSchedule.setMaxAppointmentCount(doctorSchedule.getMaxAppointmentCount()-1);
			doctor.setOrderCount(doctor.getOrderCount()+1);
		}else{
			throw new ValidException("appointment", "该医生预约已满");
		}
		Appointment appointment = new Appointment();
//		appointment.setDoctorId(doctorId);
//		appointment.setPatientId(patientId);
		appointment.setLocation(location);
		appointment.setPrice(price);
		appointment.setClinicDate(clinicDate);
		appointment.setAppointDate(appointDate);
		Set<Appointment> appointments = patient.getAppointments();
		if(appointments == null){
			appointments = new HashSet<>();
		}
		appointments.add(appointment);
		patient.setAppointments(appointments);
		doctor.setAppointments(appointments);
		doctorDAO.saveAndFlush(doctor);
		patientDAO.saveAndFlush(patient);
	}
}
