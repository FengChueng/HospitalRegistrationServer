package com.zyl.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 医生工作日程
 * @author Administrator
 *
 */
@Entity
@Table(name="doctor_schedule")
@DynamicUpdate
@DynamicInsert
public class DoctorSchedule implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private String id;
	@Column(name="status",nullable=false)
	private int status;//预约状态，0表示预约已满,不可预约、1表示可以被预约、2表示休息,不可预约
	@Column(name="schedule_date",nullable=false)
	private long scheduleDate;//时间
	
	public DoctorSchedule() {
		id = UUID.randomUUID().toString();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(long scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	
}
