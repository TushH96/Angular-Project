package com.tush.AngularPrj.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tush.AngularPrj.entity.*;
import com.tush.AngularPrj.service.*;
import java.util.HashMap;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService_i service;
	
//	@CrossOrigin(origins = "http://localhost:8080")
	
	
	//PostMapping
	
	@PostMapping("/logincheck")
	public HashMap loginUser(@RequestBody User user) {
		HashMap hm=service.loginUser(user);
		
		return hm;
		
	}
	
	@PostMapping("/addemployee")
	public String addUser(@RequestBody Employee emp)
	{
		String msg=service.addEmployee(emp);
		return msg;
	}
	
	
	
	 //getmapping
	
		@GetMapping("/getallemployee")
		public List<Employee> getallData()
		{
			List<Employee> list=service.getAllEmployee();
			return list;
		}
		
		@GetMapping("/getallcountry")
		public List<Country> getCountry()
		{
			List<Country> list=service.getAllCountry();
			return list;
		}
		
		@GetMapping("/getemployeebyid/{id}")
		public Employee getemployeebyid(@PathVariable int id) {
			
			Employee emp= service.getEmployeeId(id);
			return emp;
				
		}
		
		@PutMapping("/updateemployee")
		public String updateEmployee(@RequestBody Employee emp)
		{
			String msg = service.updateAllEmployee(emp);
			return msg;
			
		}
		
		@DeleteMapping("/deleteEmployee/{id}")
	    public String deleteEmployee(@PathVariable int id)
	    {
			String msg=service.deleteEmp(id);
			return msg;

	    }
		
		@PutMapping("/changestatus/{id}")	
	    public String changeStatus(@PathVariable int id)
		{
			String empstatus = service.changeStatus(id);
			return empstatus;
			
		}
		
		
}
