package com.tush.AngularPrj.dao;


import java.util.List;

import com.tush.AngularPrj.entity.*;

public interface UserDao_i {

	public User loginUser(User user);
	List<Employee> getAllEmployee();
	List<Country> getAllCountry();

	String addEmployee(Employee employee);
	Employee getEmployeeId(int id);
	String updateemployee(Employee emp);

	String deleteemployee(int id);

	
}
