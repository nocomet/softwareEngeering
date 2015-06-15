package test;

import static org.junit.Assert.*;

import org.junit.Test;

import DataManagement.userFile;
import Foundation.userList;
import PhysicalArchitecture.ServerConsole;
import ProblemDomain.User;

public class testLogin {

	ServerConsole serverConsole = new ServerConsole(null);
	public User user = new User("nohyesung@naver.com","computer123","nonono", "01010101111");
    public userList tempUserList = new userList();
    userFile userfile = new userFile();
    
	String msg;
	String result;
    
    @Test
    public void testcase_personalUser_Login_unusal_1_1(){//기능 추가에 따른 추가적 testcase
    	
    	tempUserList.addUser(user);		
    	userfile.fileSave(tempUserList);
    	
       msg = "#join%nohyesung@naver.com%computer123";
       result = serverConsole.Login(msg);
       assertEquals("아직 승인 되지 않음.", result);
     }
    
    @Test
    public void testcase_personalUser_Login_unusal_1_2(){//기능 추가에 따른 추가적 testcase
    	
    	user.setState(2);
    	tempUserList.addUser(user);		
    	userfile.fileSave(tempUserList);
    	
       msg = "#join%nohyesung@naver.com%computer123";
       result = serverConsole.Login(msg);
       assertEquals("-----로그인되었음", result);
     }
    
    @Test
    public void testcase_personalUser_Login_unusal_1_3(){//기능 추가에 따른 추가적 testcase
    	
    	user.setState(3);
    	tempUserList.addUser(user);		
    	userfile.fileSave(tempUserList);
    	
       msg = "#join%nohyesung@naver.com%computer123";
       result = serverConsole.Login(msg);
       assertEquals("이용이 정지된 사용자 입니다.", result);
     }
    
    @Test
     public void testcase_personalUser_Login_unusal_2(){

    	tempUserList.addUser(user);		
    	userfile.fileSave(tempUserList);		
    	 
    	msg = "#join%nohyesung@naver.com%computer122";
        String result = serverConsole.Login(msg);
        assertEquals("비밀번호오류", result);
     }   
     
    @Test
     public void testcase_personalUser_Login_unusal_3(){
    	 
    	tempUserList.addUser(user);		
    	userfile.fileSave(tempUserList);		
    	 
    	msg = "#join%nohyesung@naver.com%";
       String result = serverConsole.Login(msg);
        assertEquals("비밀번호를 입력하세요", result);
     }   
     
    @Test
     public void testcase_personalUser_Login_unusal_4(){
    	 
    	tempUserList.addUser(user);		
    	userfile.fileSave(tempUserList);		  	 
        msg = "#join%%computer123";
        
        String result = serverConsole.Login(msg);
        assertEquals("아이디를 입력하세요", result);
     }   

}
