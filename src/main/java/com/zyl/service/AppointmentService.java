package com.zyl.service;

import java.util.List;

import com.zyl.bean.AppointmentDetail;
import com.zyl.domain.Appointment;
import com.zyl.exception.ValidException;

public interface AppointmentService {

	/**
	 * 预约
	 * @param patientId
	 * @param doctorId
	 * @param doctorScheduleId
	 * @param appointDate
	 * @throws ValidException 
	 */
	void makeAppointment(String hospitalId,String deptId,String patientId, String doctorId, String doctorScheduleId) throws ValidException;
	
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
	
	void timeOutAppointment(String appointId) throws ValidException;
	
	/**
	 * 通过appointId查询预约
	 * @param appointId
	 * @return
	 * @throws ValidException
	 */
	AppointmentDetail queryByAppointId(String appointId) throws ValidException;
	
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

	/**
	 * 预生成预约
	 * @param hospitalId
	 * @param deptId
	 * @param patientId
	 * @param doctorId
	 * @param doctorScheduleId
	 * @return
	 * @throws ValidException
	 */
	AppointmentDetail appointmentInfo(String hospitalId, String deptId, String patientId, String doctorId,
			String doctorScheduleId) throws ValidException;
	

}	
