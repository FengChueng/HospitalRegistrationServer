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
 * 医院表
 * @author Administrator
 *
 */
@Entity
@Table(name="hospital")
@DynamicUpdate
@DynamicInsert
public class Hospital implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private String id;
	@Column(name="hospital_name",nullable=false,unique=true)
	private String hospitalName;
	@Column(name="info",nullable=false)
	private String info;//简介
	@Column(name="grade",nullable=false)
	private String grade;//等 A,B,C
	@Column(name="level",nullable=false)
	private int level;//级 1,2,3
	@Column(name="create_date",nullable=false)
	private long createDate;//创建时间;
	
	@Column(name="loc",nullable=true)
	private String location;//地理位置
	@Column(name="longitude",nullable=true)
	private float longitude;//经度
	@Column(name="latitude",nullable=true)
	private float latitude;//纬度
	
	@Column(name="img",nullable=true)
	private String img;
	
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.ALL},targetEntity=Department.class)
	@JoinColumn(name="hospital_id",nullable=true)
	private Set<Department> departments;//科室
	
	public Hospital() {
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}
}
