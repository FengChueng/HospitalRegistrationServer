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
	@Column(name="doctor_schedule_id")
	private String doctorScheduleId;
	@Column(name="status",nullable=false)
	private int status;//预约状态，3001表示预约已满,不可预约、3002表示可以被预约、3003表示休息,不可预约
	
	@Column(name="max_appointment_count",nullable=false)
	private int maxAppointmentCount;//当天最多被预约次数
	
	@Column(name="schedule_date",nullable=false)
	private long scheduleDate;//时间
	
	@Column(name="price",nullable=false)
	private int price;
	
	@Column(name="location",nullable=false)
	private String location;
	
	public DoctorSchedule() {
		doctorScheduleId = UUID.randomUUID().toString();
	}
	public String getDoctorScheduleId() {
		return doctorScheduleId;
	}

	public void setDoctorScheduleId(String doctorScheduleId) {
		this.doctorScheduleId = doctorScheduleId;
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
	public int getMaxAppointmentCount() {
		return maxAppointmentCount;
	}
	public void setMaxAppointmentCount(int maxAppointmentCount) {
		this.maxAppointmentCount = maxAppointmentCount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
