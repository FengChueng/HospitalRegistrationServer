package com.zyl.service;

import java.util.List;

import com.zyl.domain.Appointment;
import com.zyl.exception.ValidException;

public interface AppointmentService {
	void completeAppointment(String  appointId,String doctorAdvice) throws ValidException;
	
	void cancelAppointment(String appointId) throws ValidException;

	void startAppointment(String appointId) throws ValidException;

	Appointment queryByAppointId(String appointId) throws ValidException;
	
	void makeAppointment(String patientId,String doctorId,float price,long clinicDate,long appointDate,String location) throws ValidException;

	List<Appointment> queryByPatientId(String patientId) throws ValidException;

	List<Appointment> queryByDoctorId(String doctorId) throws ValidException;
}	
