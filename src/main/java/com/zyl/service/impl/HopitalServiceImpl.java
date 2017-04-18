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
	public Page<Hospital> queryByCreatedDate(long date,Pageable pageable) {
		return hospitalDAO.findByCreateDate(date,pageable);
	}

	

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Page<Hospital> queryByLevel(int level,Pageable pageable) throws ValidException {
		Page<Hospital> hpPage = hospitalDAO.findByLevel(level,pageable);
		
		if(hpPage == null){
			throw new ValidException("hospital", "无数据");
		}
		
		return hpPage;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Page<Hospital> queryByLocation(String location,Pageable pageable) {
		return hospitalDAO.findByLocationLike(location,pageable);
	}
}
