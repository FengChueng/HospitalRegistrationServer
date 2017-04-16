package com.zyl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Appointment;
import com.zyl.domain.Doctor;
import com.zyl.domain.Patient;
import com.zyl.exception.ValidException;
import com.zyl.jpa.AppointmentDAO;
import com.zyl.service.AppointmentService;

@Repository
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentDAO appointmentDAO;
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void makeAppointment(Appointment appointment, Patient patient, Doctor doctor) throws ValidException {
		appointment.setPatient(patient);
		appointment.setDoctor(doctor);
		appointmentDAO.saveAndFlush(appointment);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void completeAppointment(Appointment appointment) throws ValidException {
		
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void completeAppointment(String appointId) throws ValidException {
		Appointment appointment = appointmentDAO.findOne(appointId);
		if(appointment == null){
			throw new ValidException("appointment", "该预约不存在");
		}
		appointment.setStatus(1);//完成
		appointmentDAO.saveAndFlush(appointment);
		
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void cancelAppointment(Appointment appointment) throws ValidException {
		
		
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void cancelAppointment(String appointId) throws ValidException {
		Appointment appointment = appointmentDAO.findOne(appointId);
		if(appointment == null){
			throw new ValidException("appointment", "该预约不存在");
		}
		appointmentDAO.delete(appointId);
	}

}
