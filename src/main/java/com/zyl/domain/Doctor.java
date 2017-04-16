package com.zyl.domain;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="doctor")
@DynamicInsert
@DynamicUpdate
public class Doctor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="doctor_id")
	private String doctorId;
	
	@Column(name="info",nullable=false)
	private String info;//简介
	@Column(name="level",nullable=false)
	private int level;//0普通,1专家
	@Column(name="order_count",nullable=false)
	private int orderCount;//被预约次数
	
	
	@Column(name = "real_name", nullable = true)
	private String realName;
	@Column(name = "age", nullable = true)
	private int age;
	@Column(name = "sex", nullable = true)
	private int sex;// 0表示男性,1表示女性
	@Column(name = "birth_day", nullable = true)
	private long birthDay;// 生日
	@Column(name = "mobile_phone", length = 11, nullable = true)
	private String mobilePhone;// 联系电话
	
	
	@OneToOne(fetch=FetchType.EAGER,cascade={CascadeType.ALL},targetEntity=Account.class)
	@JoinColumn(name="account_id",nullable=false)
	private Account account;//与账号关联 一对一

	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.ALL},targetEntity=DoctorSchedule.class)
	@JoinColumn(name="doctor_id",nullable=true)
	private Set<DoctorSchedule> doctorSchedules;
	
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.ALL},targetEntity=Appointment.class)
	@JoinColumn(name="doctor_id",nullable=true)
	private Set<Appointment> appointments;

	public Doctor() {
		doctorId = UUID.randomUUID().toString();
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public long getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(long birthDay) {
		this.birthDay = birthDay;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<DoctorSchedule> getDoctorSchedules() {
		return doctorSchedules;
	}

	public void setDoctorSchedules(Set<DoctorSchedule> doctorSchedules) {
		this.doctorSchedules = doctorSchedules;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

}
