package test;

import static org.junit.Assert.*;

import java.io.ObjectOutputStream;

import org.junit.Test;

import DataManagement.roomFile;
import DataManagement.userFile;
import Foundation.roomList;
import Foundation.userList;
import GUI.GUI_console;
import PhysicalArchitecture.Client;
import PhysicalArchitecture.ServerConsole;
import ProblemDomain.User;
import ProblemDomain.admin;
import ProblemDomain.personalUser;
import ProblemDomain.userStateType;

public class testAbmin {
	
    public userList tempUserList = new userList();
    userFile userfile = new userFile();
    	
	public admin testAdmin = new admin();
	public userFile testFile = new userFile();
	public userList testUserList = new userList();
	public personalUser testUser = new personalUser("oooyat@naver.com", "123123", "heanJung", "01029927967");
		
		
	 @Test
	 public void testcase_admin_approval(){		
		 
		 testUserList.addUser(testUser);
		 testFile.fileSave(testUserList);
		 
		testAdmin.doApproval(null, testUserList, testUser);
		assertEquals(userStateType.OLD, testUser.getState());	 
	}
	 
	 @Test
	 public void testcase_admin_block(){		
		 
		 testUserList.addUser(testUser);
		 testFile.fileSave(testUserList);
		 
		testAdmin.doBlock(null, testUserList, testUser);
		assertEquals(userStateType.BAD, testUser.getState());	 
	 }
	 
}
