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
	Page<Hospital> queryByCreatedDate(long date,Pageable pageable) throws ValidException;
	
	
	/**
	 * 按id查询
	 * @param hospitalName
	 * @throws ValidException 
	 */
	Hospital queryByHospitalId(String hospitalId) throws ValidException;
	
	
	/**
	 * 按名字查询
	 * @param hospitalName
	 * @throws ValidException 
	 */
	Hospital queryByHospitalName(String hospitalName) throws ValidException;
	
	/**
	 * 按等级查询
	 * @param level 常量表：5001-5009
	 */
	Page<Hospital> queryByLevel(int level,Pageable pageable) throws ValidException;
	
	/**
	 * 按地理位置查询
	 * @param location
	 * @return
	 */
	Page<Hospital> queryByLocation(String location,Pageable pageable) throws ValidException;
}
