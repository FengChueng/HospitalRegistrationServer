package com.zyl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.bean.ResponseEntity;
import com.zyl.domain.Hospital;
import com.zyl.exception.ValidException;
import com.zyl.service.HospitalService;
import com.zyl.utils.Constant;

/**
 * 医院Controller(http请求)
 * 
 * @author Administrator
 *
 */
@RestController
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@RequestMapping("/hospital")
	public String index() {
		return "hospital";
	}

	// 病人controller
	@RequestMapping(value = "/hospital/queryByHospitalName", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Hospital> queryByHospitalName(@RequestParam(value = "hospitalName", required = true) String hospitalName) {
		ResponseEntity<Hospital> responseEntity = new ResponseEntity<>();
		try {
			Hospital hospital = hospitalService.queryByHospitalName(hospitalName);
			hospital.setDepartments(null);//避免返回给客户端数据过多
			responseEntity.setData(hospital);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

	@RequestMapping(value = "/hospital/queryByLevel", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Hospital>> queryByLevel(@RequestParam(value = "level", required = true) int level,
			@RequestParam(value = "page",defaultValue="0") int page,
			@RequestParam(value = "size",defaultValue="30") int size) {
		ResponseEntity<List<Hospital>> responseEntity = new ResponseEntity<>();
		List<Hospital> hospitals = new ArrayList<>();
		try {
			Sort sort = new Sort(Sort.Direction.DESC, "realName");  
		    Pageable pageable = new PageRequest(page, size, sort);
		    Page<Hospital> hospitalPage = hospitalService.queryByLevel(level, pageable);
		    for (Hospital hospital : hospitalPage) {
		    	hospital.setDepartments(null);//避免返回给客户端数据过多
				hospitals.add(hospital);
			}
			responseEntity.setData(hospitals);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/hospital/queryByLocation", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Hospital>> queryByLocation(@RequestParam(value = "location", required = true) String location,
			@RequestParam(value = "page",defaultValue="0") int page,
			@RequestParam(value = "size",defaultValue="30") int size) {
		ResponseEntity<List<Hospital>> responseEntity = new ResponseEntity<>();
		List<Hospital> hospitals = new ArrayList<>();
		try {
			Sort sort = new Sort(Sort.Direction.DESC, "realName");  
		    Pageable pageable = new PageRequest(page, size, sort);
		    Page<Hospital> hospitalPage = hospitalService.queryByLocation(location, pageable);
		    for (Hospital hospital : hospitalPage) {
		    	hospital.setDepartments(null);//避免返回给客户端数据过多
				hospitals.add(hospital);
			}
			responseEntity.setData(hospitals);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}
}
