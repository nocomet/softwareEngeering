package ProblemDomain;

import java.io.Serializable;

public class personalUser extends User implements Serializable{

	public personalUser(String email, String pass, String name, String phoneNumber) {
		super(email,pass,name,phoneNumber);
	}
	

}
