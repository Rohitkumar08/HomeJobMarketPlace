package com.bean;



public class Member {
	
	private  String firstName;
	private String phone;
	private String email;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	private String add;
	private  String memberType;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	

	}
