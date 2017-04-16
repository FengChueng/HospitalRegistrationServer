package com.zyl.service;

import com.zyl.domain.Appointment;
import com.zyl.domain.Doctor;
import com.zyl.domain.Patient;
import com.zyl.exception.ValidException;

public interface AppointmentService {
	/**
	 * 预约
	 * @param appointment
	 * @param patient
	 * @param doctor
	 * @throws ValidException
	 */
	void makeAppointment(Appointment appointment,Patient patient,Doctor doctor) throws ValidException;
	
	
	void completeAppointment(Appointment appointment) throws ValidException;
	void completeAppointment(String  appointId) throws ValidException;
	
	void cancelAppointment(Appointment appointment) throws ValidException;
	void cancelAppointment(String appointId) throws ValidException;
}	
