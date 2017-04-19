package com.zyl.service;

import java.util.List;

import com.zyl.domain.Appointment;
import com.zyl.exception.ValidException;

public interface AppointmentService {
	
	/**
	 * 病人预约
	 * @param patientId
	 * @param doctorId
	 * @param doctorScheduleId
	 * @param price
	 * @param clinicDate
	 * @param appointDate
	 * @param location
	 * @throws ValidException
	 */
	void makeAppointment(String patientId, String doctorId, String doctorScheduleId, float price, long clinicDate,
			long appointDate, String location) throws ValidException;
	
	/**
	 * 完成预约
	 * @param appointId
	 * @param doctorAdvice
	 * @throws ValidException
	 */
	void completeAppointment(String  appointId,String doctorAdvice) throws ValidException;
	
	/**
	 * 取消预约
	 * @param appointId
	 * @throws ValidException
	 */
	void cancelAppointment(String appointId) throws ValidException;
	
	/**
	 * 开始预约
	 * @param appointId
	 * @throws ValidException
	 */
	void startAppointment(String appointId) throws ValidException;
	
	/**
	 * 通过appointId查询预约
	 * @param appointId
	 * @return
	 * @throws ValidException
	 */
	Appointment queryByAppointId(String appointId) throws ValidException;
	
	/**
	 * 查询病人的所有预约
	 * @param patientId
	 * @return
	 * @throws ValidException
	 */
	List<Appointment> queryByPatientId(String patientId) throws ValidException;
	/**
	 * 通过状态查询病人的预约
	 * @param patientId
	 * @param status
	 * @return
	 * @throws ValidException
	 */
	List<Appointment> queryByPatientIdAndStatus(String patientId,int status) throws ValidException;
	
	
	/**
	 * 查询所有医生的预约
	 * @param doctorId
	 * @return
	 * @throws ValidException
	 */
	List<Appointment> queryByDoctorId(String doctorId) throws ValidException;
	
	/**
	 * 通过状态查询医生的预约
	 * @param doctorId
	 * @param status
	 * @return
	 * @throws ValidException
	 */
	List<Appointment> queryByDoctorIdAndStatus(String doctorId,int status) throws ValidException;
	

}	
