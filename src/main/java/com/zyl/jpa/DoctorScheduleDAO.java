package com.zyl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.DoctorSchedule;
@Transactional(rollbackFor=Exception.class)
public interface DoctorScheduleDAO extends JpaRepository<DoctorSchedule, String>{

	DoctorSchedule findByScheduleDate(long scheduleDate);

}
