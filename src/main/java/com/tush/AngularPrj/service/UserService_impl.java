package com.tush.AngularPrj.service;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tush.AngularPrj.dao.*;

import com.tush.AngularPrj.entity.*;
@Service
@Transactional
public class UserService_impl implements UserService_i {
	
	@Autowired
	private UserDao_i dao;

	@Override
	public HashMap loginUser(User user) {

		System.out.println("service login check");
		User user1=dao.loginUser(user);
		HashMap hm=new HashMap();
		if(user1==null) {
			hm.put("msg", "Invalid User");
			hm.put("user", user1);
			
		}else {
			//hm.put("msg", "Login Success");
		//	String msg="login success";
			hm.put("msg", "valid user");
			hm.put("user",user1);
			
		}
		return hm;
	}
	
	
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list =dao.getAllEmployee();
		return list;
	}
	
	@Override
	public List<Country> getAllCountry() {
		List<Country> list=dao.getAllCountry();
		return list;
	}

	@Override
	public String addEmployee(Employee employee) {
		String msg =dao.addEmployee(employee);
		
//		if(emp!=null) {
//			return "Employee Added Successfully";
//		}else {
		return msg;
		}
	
	@Override
	public Employee getEmployeeId(int id) {
		Employee emp=dao.getEmployeeId(id);
		return emp;
		
	}


	@Override
	public String updateAllEmployee(Employee employee) {
		
		String msg=dao.updateemployee(employee);
		return msg;
	}


	@Override
	public String deleteEmp(int id) {
	
		String msg=dao.deleteemployee(id);
		return msg;
		
	}
	
	   public String changeStatus(int id) {
		   String msg="";
			Employee e=dao.getEmployeeId(id);
			String status= e.getStatus();
			if(status.equalsIgnoreCase("active")) {
				
				e.setStatus("Inactive");
				dao.updateemployee(e);
				msg="Employee status change successfully";
				
			}else if(status.equalsIgnoreCase("Inactive")) {
				
				e.setStatus("active");
				dao.updateemployee(e);
				msg="Employee status change successfully";
			}else {
				
				msg="Employe is alredy suspended";
			}
			return msg;
			
		}
	
	}


