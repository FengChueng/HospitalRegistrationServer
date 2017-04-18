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
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 科室表
 * @author Administrator
 *
 */
@Entity
@Table(name="department")
@DynamicUpdate
@DynamicInsert
public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="dept_id")
	private String deptId;
	@Column(name="dept_name",nullable=false,unique=true)
	private String deptName;//科室名称
	@Column(name="info",nullable=false)
	private String info;//简介
	@Column(name="create_date",nullable=false)
	private long createDate;//成立时间
	
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.ALL},targetEntity=Doctor.class)
	@JoinColumn(name="depart_id",nullable=true)	
	private Set<Doctor> doctors;
	
	public Department() {
		deptId = UUID.randomUUID().toString();
	}

	public String getDeptId() {
		return deptId;
	}



	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}



	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}
}
