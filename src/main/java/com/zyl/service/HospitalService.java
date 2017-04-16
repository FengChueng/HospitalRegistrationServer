package com.zyl.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zyl.domain.Hospital;
import com.zyl.exception.ValidException;


public interface HospitalService {
	/**
	 * 添加一个医院
	 * @param hospital
	 * @throws ValidException 
	 */
	void insertHospital(Hospital hospital) throws ValidException;
	
	/**
	 * 添加医院列表
	 * @param hospitals
	 */
	void insertHospitals(List<Hospital> hospitals) throws ValidException;
	
	/**
	 * 根据时间查询
	 * @param date
	 * @return
	 */
	Page<Hospital> queryByCreatedDate(long date,Pageable pageable);
	
	/**
	 * 按名字查询
	 * @param hospitalName
	 */
	Hospital queryByHospitalName(String hospitalName);
	
	/**
	 * 按等级查询
	 * @param level 级: 1,2,3
	 * @param grade 等: A,B,C
	 */
	Page<Hospital> queryByLevelAndGrade(int level,String grade,Pageable pageable);
	
	/**
	 * 按地理位置查询
	 * @param location
	 * @return
	 */
	Page<Hospital> queryByLocation(String location,Pageable pageable);
}
