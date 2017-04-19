package com.zyl.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Appointment;


/**
 * 操作Appointment表的DAO层
 * @author Administrator
 *
 */
@Transactional(rollbackFor=Exception.class)
public interface AppointmentDAO extends JpaRepository<Appointment, String>{

	List<Appointment> findByPatientIdAndStatus(String patientId, int status);

	List<Appointment> findByDoctorIdAndStatus(String doctorId, int status);

}
