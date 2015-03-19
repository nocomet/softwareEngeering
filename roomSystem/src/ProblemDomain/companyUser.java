package ProblemDomain;

import java.io.Serializable;

public class companyUser extends User implements Serializable{

	private String BusinessNumber;

	public companyUser(String email, String pass, String name, String phoneNumber,String BusinessNumber) {
		super(email,pass,name,phoneNumber);
		this.BusinessNumber=BusinessNumber;
	}
	public String getBusinessNumber() {
		return BusinessNumber;
	}
	public void setBusinessNumber(String businessNumber) {
		BusinessNumber = businessNumber;
	}
}
