package com.zyl.domain;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="patient")
@DynamicInsert
@DynamicUpdate
public class Patient implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "patient_account", length = 11, nullable = false, unique = true)
	private String patientAccount;// 账号
	@Column(name = "password", nullable = false)
	private String password;// 密码
	@Column(name = "real_name", nullable = true)
	private String realName;
	@Column(name = "age", nullable = true)
	private int age;
	@Column(name = "sex", nullable = true)
	private int sex;// 0表示男性,1表示女性
	@Column(name = "birth_day", nullable = true)
	private long birthDay;// 生日
	@Column(name = "mobile_phone", length = 11, nullable = false)
	private String mobilePhone;// 联系电话
	@Column(name = "portraint",nullable = true)
	private String portraint;//用户头像

	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.ALL},targetEntity=Appointment.class)
	@JoinColumn(name="patient_id",nullable=true)
	private Set<Appointment> appointments;
	
	public Patient() {
	}

	public String getPatientAccount() {
		return patientAccount;
	}

	public void setPatientAccount(String patientAccount) {
		this.patientAccount = patientAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPortraint() {
		return portraint;
	}

	public void setPortraint(String portraint) {
		this.portraint = portraint;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}
	
}
