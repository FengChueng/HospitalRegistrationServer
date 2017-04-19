package com.zyl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.bean.ResponseEntity;
import com.zyl.domain.Department;
import com.zyl.exception.ValidException;
import com.zyl.service.DepartmentService;
import com.zyl.utils.Constant;

/**
 * 科室Controller(http)
 * 
 * @author Administrator
 *
 */
@RestController
public class DepartmentController {

	// @Autowired
	// private DoctorService doctorService;
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("/department")
	public String index() {
		return "department";
	}

	/**
	 * 根据HospitalId查询所有科室
	 * 
	 * @param hospitalId
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/hospital/queryByHospitalId", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Department>> queryByhospitalId(
			@RequestParam(value = "hospitalId", required = true) String hospitalId,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "30") int size) {
		ResponseEntity<List<Department>> responseEntity = new ResponseEntity<>();
		List<Department> departments = null;
		try {
			departments = departmentService.queryAllByHospitalId(hospitalId);
			List<Department> departmentsList = new ArrayList<>();
			for (Department department : departments) {
				department.setDoctors(null);//避免返回给客户端数据过多
				departmentsList.add(department);
			}
			responseEntity.setData(departments);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

	@RequestMapping(value = "/hospital/queryByDeptId", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Department> queryByDeptId(@RequestParam(value = "deptId", required = true) String deptId,
			@RequestParam(value = "page",defaultValue="0") int page,
			@RequestParam(value = "size",defaultValue="30") int size) {
		ResponseEntity<Department> responseEntity = new ResponseEntity<>();
		try {
			Department department = departmentService.queryOneDepartId(deptId);
			department.setDoctors(null);//避免返回给客户端数据过多
			responseEntity.setData(department);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/hospital/queryByHospitalIdAndDepartName", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Department> queryByHospitalIdAndDepartName(@RequestParam(value = "hospitalId", required = true) String hospitalId,
			@RequestParam(value = "departName", required = true) String departName,
			@RequestParam(value = "page",defaultValue="0") int page,
			@RequestParam(value = "size",defaultValue="30") int size) {
		ResponseEntity<Department> responseEntity = new ResponseEntity<>();
		try {
			Department department = departmentService.queryOneByHospitalIdAndDepartName(hospitalId, departName);
			department.setDoctors(null);//避免返回给客户端数据过多
			responseEntity.setData(department);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value = "/hospital/queryByHospitalNameAndDepartName", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Department> queryByHospitalNameAndDepartName(@RequestParam(value = "hospitalName", required = true) String hospitalName,
			@RequestParam(value = "departName", required = true) String departName,
			@RequestParam(value = "page",defaultValue="0") int page,
			@RequestParam(value = "size",defaultValue="30") int size) {
		ResponseEntity<Department> responseEntity = new ResponseEntity<>();
		try {
			Department department = departmentService.queryOneByHospitalNameAndDepartName(hospitalName, departName);
			department.setDoctors(null);//避免返回给客户端数据过多
			responseEntity.setData(department);
			responseEntity.setMsg("查询成功");
		} catch (ValidException e) {
			responseEntity.setStatus(Constant.FIAL);
			responseEntity.setMsg(e.getMessage());
		}
		return responseEntity;
	}

}
