package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import DataManagement.userFile;
import Foundation.userList;
import ProblemDomain.User;

public class testJoin {

	@Test
	public void test(){
		User user = new User("lsy8795@naver.com", "qwerasdf!!","이신영","01055678795");
	}
	
	@Test
	public void testEmail() {
	
		User getUser = null;
		User user = new User("lsy8795@naver.com", "qwerasdf!!","이신영","01055678795");
		userFile userfile = new userFile();
		userList userlist = new userList();
		userlist.addUser(user);
		userfile.fileSave(userlist);
		
		getUser = userfile.fileRead().getUser(userlist.size()-1);
		assertEquals(getUser.getEmail(), "lsy8795@naver.com");
		
	}
	@Test
	public void testPwd() {
		
		User getUser = null;
		User user = new User("ooyat@naver.com", "1234567","이흔정","01029927967");
		userFile userfile = new userFile();
		userList userlist = new userList();
		userlist.addUser(user);
		userfile.fileSave(userlist);
		
		getUser = userfile.fileRead().getUser(userlist.size()-1);
		assertEquals(getUser.getPassword(), "1234567");
		
	}
	@Test
	public void testName() {
		
		User getUser = null;
		User user = new User("ncomet@naver.com", "101010101010","노혜성","0104949193");
		userFile userfile = new userFile();
		userList userlist = new userList();
		userlist.addUser(user);
		userfile.fileSave(userlist);
		
		getUser = userfile.fileRead().getUser(userlist.size()-1);
		assertEquals(getUser.getName(), "노혜성");
		
	}
	
	@Test
	public void testPhoneNum() {
		
		User getUser = null;
		User user = new User("tlsdud8795@naver.com", "tlsdud8795","이신영","01034525678");
		userFile userfile = new userFile();
		userList userlist = new userList();
		userlist.addUser(user);
		userfile.fileSave(userlist);
		
		getUser = userfile.fileRead().getUser(userlist.size()-1);
		assertEquals(getUser.getPhoneNumber(), "01034525678");
		
		
	}
	
	

}
