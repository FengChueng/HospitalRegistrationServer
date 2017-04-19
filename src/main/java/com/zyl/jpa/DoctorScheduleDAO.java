package com.zyl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.DoctorSchedule;

/**
 * 操作DoctorSchedule表的DAO层
 * @author Administrator
 *
 */
@Transactional(rollbackFor=Exception.class)
public interface DoctorScheduleDAO extends JpaRepository<DoctorSchedule, String>{
	/**
	 * 按预约时间查找
	 * @param scheduleDate
	 * @return
	 */
	DoctorSchedule findByScheduleDate(long scheduleDate);

}
