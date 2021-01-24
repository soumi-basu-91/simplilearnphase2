package com.travelbyair.pojoclasses;

public class User {
	public User(int id, String fname, String lname, String userid, String password, String dob, String city,
			String moblie, String gender, String email) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.userid = userid;
		this.password = password;
		this.dob = dob;
		this.city = city;
		this.moblie = moblie;
		this.gender = gender;
		this.email = email;
	}
	private int id;
	private String fname,lname,userid,password,dob,city,moblie,gender,email;
	private byte[] image;
	public User(){	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMoblie() {
		return moblie;
	}
	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
}
