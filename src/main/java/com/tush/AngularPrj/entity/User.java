package com.tush.AngularPrj.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="registration",uniqueConstraints = {@UniqueConstraint(columnNames = {"email"} )} )
public class User {
	
	public User() {

		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_Id;
	
	@Column(unique = true)
	private String email;
	
	private String fname;
	private String lname;
	private String phone;
	private String password;
	private String gender;
	private String address;
	private String username;
	private String DateTime;
	private String status;
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDateTime() {
		return DateTime;
	}
	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User(int user_Id, String email, String fname, String lname, String phone, String password, String gender,
			String address, String username, String dateTime, String status) {
		super();
		this.user_Id = user_Id;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.password = password;
		this.gender = gender;
		this.address = address;
		this.username = username;
		DateTime = dateTime;
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", email=" + email + ", fname=" + fname + ", lname=" + lname + ", phone="
				+ phone + ", password=" + password + ", gender=" + gender + ", address=" + address + ", username="
				+ username + ", DateTime=" + DateTime + ", status=" + status + "]";
	}
	
	
	
}
