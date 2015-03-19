package ProblemDomain;

import java.io.Serializable;

public class User implements Serializable{
	
	private String email;
	private String password;
	private String name;
	private String phoneNumber;
	public User(String email, String password, String name, String phoneNumber) {
		this.email = email;
		this.password = password;
		this.name=name;
		this.phoneNumber=phoneNumber;
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


	
}
