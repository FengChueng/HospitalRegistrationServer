package com.zyl.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="appointment")
@DynamicUpdate
@DynamicInsert
public class Appointment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="appoint_id")
	private String appointId;//预约id
	@Column(name="price",nullable=true)
	private float price;//价格
	@Column(name="clinic_date",nullable=true)
	private long clinicDate;//就诊时间
	@Column(name="appoint_date",nullable=true)
	private long appointDate;//预约时间 提前1-3天开始预约
	@Column(name="status",nullable=true)
	private int status;//0未处理,1已处理,2超时未处理,3已取消预约
	@Column(name="loc",nullable=true)
	private String location;
	
	@Column(name="patient_id",nullable=true)
	private String patientId;
	@Column(name="doctor_id",nullable=true)
	private String doctorId;
	
	@Column(name="doctor_advice",nullable=true)
	private String doctorAdvice;//医嘱
	
	public Appointment() {
		this.appointId = UUID.randomUUID().toString();
	}
	public String getAppointId() {
		return appointId;
	}

	public void setAppointId(String appointId) {
		this.appointId = appointId;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public long getClinicDate() {
		return clinicDate;
	}
	public void setClinicDate(long clinicDate) {
		this.clinicDate = clinicDate;
	}
	public long getAppointDate() {
		return appointDate;
	}
	public void setAppointDate(long appointDate) {
		this.appointDate = appointDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDoctorAdvice() {
		return doctorAdvice;
	}
	public void setDoctorAdvice(String doctorAdvice) {
		this.doctorAdvice = doctorAdvice;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
}
