package com.zyl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zyl.domain.Hospital;
import com.zyl.exception.ValidException;
import com.zyl.jpa.HospitalDAO;
import com.zyl.service.HospitalService;

@Repository
public class HopitalServiceImpl implements HospitalService{

	@Autowired
	private HospitalDAO hospitalDAO;
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void insertHospital(Hospital newHospital) throws ValidException {
		Hospital hospital = hospitalDAO.findByHospitalName(newHospital.getHospitalName());
		if(hospital!=null){
			throw new ValidException("hospital", "医院名字重复,请更换名字");
		}
		hospitalDAO.saveAndFlush(newHospital);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public void insertHospitals(List<Hospital> hospitals) throws ValidException{
		for (int i = 0; i < hospitals.size(); i++) {
			Hospital newHospital = hospitals.get(i);
			Hospital hospital = hospitalDAO.findByHospitalName(newHospital.getHospitalName());
			if(hospital!=null){
				throw new ValidException("hospital", "医院名字重复,请更换名字");
			}
			hospitalDAO.saveAndFlush(newHospital);
		}
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Hospital queryByHospitalName(String hospitalName) throws ValidException {
		Hospital hospital = hospitalDAO.findByHospitalName(hospitalName);
		if(hospital == null){
			throw new ValidException("hospital", "未查找到该医院");
		}
		
		return hospital;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Page<Hospital> queryByCreatedDate(long date,Pageable pageable) throws ValidException {
		Page<Hospital> hpPage = hospitalDAO.findByCreateDate(date,pageable);
		if(hpPage != null&&hpPage.getSize()!=0){
			return hpPage;
		}else{
			throw new ValidException("hospital", "无数据");
		}
	}

	

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Page<Hospital> queryByLevel(int level,Pageable pageable) throws ValidException {
		Page<Hospital> hpPage = hospitalDAO.findByLevel(level,pageable);
		if(hpPage != null&&hpPage.getSize()!=0){
			return hpPage;
		}else{
			throw new ValidException("hospital", "无数据");
		}
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Page<Hospital> queryByLocation(String location,Pageable pageable) throws ValidException {
		Page<Hospital> hpPage = hospitalDAO.findByLocationLike(location,pageable);
		if(hpPage != null&&hpPage.getSize()!=0){
			return hpPage;
		}else{
			throw new ValidException("hospital", "无数据");
		}
	}

	@Override
	public Hospital queryByHospitalId(String hospitalId) throws ValidException {
		Hospital hospital = hospitalDAO.findOne(hospitalId);
		if(hospital == null){
			throw new ValidException("hospital", "未查找到该医院");
		}
		return hospital;
	}

	@Override
	public Page<Hospital> queryAll(Pageable pageable) throws ValidException {
		Page<Hospital> hpPage = hospitalDAO.findAll(pageable);
		if(hpPage != null&&hpPage.getSize()!=0){
			return hpPage;
		}else{
			throw new ValidException("hospital", "无数据");
		}
	}
}
