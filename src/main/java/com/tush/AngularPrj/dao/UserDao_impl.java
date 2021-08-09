package com.tush.AngularPrj.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tush.AngularPrj.entity.*;

import com.tush.AngularPrj.service.*;


@Repository
public class UserDao_impl implements UserDao_i{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User loginUser(User user) {

		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", user.getEmail()));
		criteria.add(Restrictions.eq("password", user.getPassword()));
		User user1=(User) criteria.uniqueResult();
		System.out.println("user is "+user1);
		return user1;
	}
	
	
	@Override
	public List<Employee> getAllEmployee() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> list=criteria.list();
       
		return list;
	}
	
	
	@Override
	public List<Country> getAllCountry() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Country.class);
		List<Country> list=criteria.list();
		return list;
	}

	@Override
	public String addEmployee(Employee employee) {
		Session session=sessionFactory.getCurrentSession();
		String msg="Not inserted";
		session.save(employee);
		msg="Daya inserted";
		 return msg;
	}
	
	@Override
	public Employee getEmployeeId(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", id));
		Employee result = (Employee) criteria.uniqueResult();
		return result;
	}
	
	public String updateemployee(Employee emp) {
		Session session=sessionFactory.getCurrentSession();
		String msg="Not Updated";
		 session.update(emp);
		 msg="Updated Successfully";
		return msg;
	}

	@Override
	public String deleteemployee(int id) {
		Session session=sessionFactory.getCurrentSession();
		String msg="Not Deleted";
		Employee user = session.get(Employee.class, id);
		session.remove(user);
		msg="Deleted Successfully";
		return msg;
	}
	
//	@Override
//	public String changeStatus(int id, Employee emp) {
//		Session session=sessionFactory.getCurrentSession();
//	
//		if(emp.getId().equals(id))
//		{
//			emp.getStatus();
//			String emostatus= (String) session.save(emp);
//		}

}
