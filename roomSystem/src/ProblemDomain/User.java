package ProblemDomain;

import java.io.Serializable;

public class User implements Serializable, userStateType{
	
	private String email;
	private String password;
	private String name;
	private String phoneNumber;
	
	//# 가입 승인 여부를 나타내는 변수, enum 타입 추가
	private int state;

	public User(String email, String password, String name, String phoneNumber) {
		this.email = email;
		this.password = password;
		this.name=name;
		this.phoneNumber=phoneNumber;
		state=userStateType.NEW;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
