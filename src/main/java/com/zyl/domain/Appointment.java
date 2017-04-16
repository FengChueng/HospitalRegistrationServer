package com.zyl.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	private String orderId;//订单id
	@Column(name="price",nullable=true)
	private int price;//价格
	@Column(name="clinic_date",nullable=true)
	private long clinicDate;//就诊时间
	@Column(name="appoint_date",nullable=true)
	private long appointDate;//预约时间 提前1-3天开始预约
	@Column(name="status",nullable=true)
	private int status;//0未处理,1已处理,2超时未处理,3已取消预约
	@Column(name="loc",nullable=true)
	private String location;
	
	@OneToOne(fetch=FetchType.EAGER,cascade={CascadeType.ALL},targetEntity=Doctor.class)
	@JoinColumn(name="doctor_id",nullable=false)
	private Doctor doctor;//医生
	@OneToOne(fetch=FetchType.EAGER,cascade={CascadeType.ALL},targetEntity=Patient.class)
	@JoinColumn(name="patient_id",nullable=false)
	private Patient patient;//病人
	
	public Appointment() {
		this.orderId = UUID.randomUUID().toString();
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
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
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
