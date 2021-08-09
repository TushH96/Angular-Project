package com.tush.AngularPrj.service;

import java.util.HashMap;
import java.util.List;

import com.tush.AngularPrj.entity.*;

public interface UserService_i {

	public HashMap loginUser(User user);
	List<Employee> getAllEmployee();
	List<Country> getAllCountry();

	String addEmployee(Employee employee);
	Employee getEmployeeId(int id);
	String updateAllEmployee(Employee employee);
	String deleteEmp(int id);
String changeStatus(int id);

	
}
