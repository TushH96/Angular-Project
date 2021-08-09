package com.tush.AngularPrj.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee")
public class Employee {

	private int id;
	private String name;
	private String mobileNo;
	private String department;
	private String status;
	private Date createddtm;
	private String createdby;
	private Date updateddtm;
	private String updatedby;
	
	@OneToOne
	private Country country;
	
	
	public Employee() {
		
	}


	public Employee(Integer id, Country country, String name, String mobileNo, String department, String status,
			Date createddtm, String createdby, Date updateddtm, String updatedby) {
		this.id = id;
		this.country = country;
		this.name = name;
		this.mobileNo = mobileNo;
		this.department = department;
		this.status = status;
		this.createddtm = createddtm;
		this.createdby = createdby;
		this.updateddtm = updateddtm;
		this.updatedby = updatedby;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", country=" + country + ", name=" + name + ", mobileNo=" + mobileNo
				+ ", department=" + department + ", status=" + status + ", createddtm=" + createddtm + ", createdby="
				+ createdby + ", updateddtm=" + updateddtm + ", updatedby=" + updatedby + "]";
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cid" ,nullable = false)
	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	@Column(name = "name",  nullable = false, length = 30)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Column(name = "mobileNo",  nullable = false, length = 13)
	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	@Column(name = "department",  nullable = false, length = 20)
	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	@Column(name = "status",  nullable = false, length = 20)
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name = "createddtm")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateddtm() {
		return createddtm;
	}


	
	public void setCreateddtm(Date createddtm) {
		this.createddtm = createddtm;
	}


	@Column(name = "createdby",  nullable = false, length = 20)
	public String getCreatedby() {
		return createdby;
	}


	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}


	@Column(name = "updateddtm")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdateddtm() {
		return updateddtm;
	}


	public void setUpdateddtm(Date updateddtm) {
		this.updateddtm = updateddtm;
	}


	@Column(name = "updatedby",  nullable = false, length = 20)
	public String getUpdatedby() {
		return updatedby;
	}


	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	
}
