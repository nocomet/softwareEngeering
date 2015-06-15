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
    public void testcase_personalUser_Login_unusal_1_1(){//��� �߰��� ���� �߰��� testcase
    	
    	tempUserList.addUser(user);		
    	userfile.fileSave(tempUserList);
    	
       msg = "#join%nohyesung@naver.com%computer123";
       result = serverConsole.Login(msg);
       assertEquals("���� ���� ���� ����.", result);
     }
    
    @Test
    public void testcase_personalUser_Login_unusal_1_2(){//��� �߰��� ���� �߰��� testcase
    	
    	user.setState(2);
    	tempUserList.addUser(user);		
    	userfile.fileSave(tempUserList);
    	
       msg = "#join%nohyesung@naver.com%computer123";
       result = serverConsole.Login(msg);
       assertEquals("-----�α��εǾ���", result);
     }
    
    @Test
    public void testcase_personalUser_Login_unusal_1_3(){//��� �߰��� ���� �߰��� testcase
    	
    	user.setState(3);
    	tempUserList.addUser(user);		
    	userfile.fileSave(tempUserList);
    	
       msg = "#join%nohyesung@naver.com%computer123";
       result = serverConsole.Login(msg);
       assertEquals("�̿��� ������ ����� �Դϴ�.", result);
     }
    
    @Test
     public void testcase_personalUser_Login_unusal_2(){

    	tempUserList.addUser(user);		
    	userfile.fileSave(tempUserList);		
    	 
    	msg = "#join%nohyesung@naver.com%computer122";
        String result = serverConsole.Login(msg);
        assertEquals("��й�ȣ����", result);
     }   
     
    @Test
     public void testcase_personalUser_Login_unusal_3(){
    	 
    	tempUserList.addUser(user);		
    	userfile.fileSave(tempUserList);		
    	 
    	msg = "#join%nohyesung@naver.com%";
       String result = serverConsole.Login(msg);
        assertEquals("��й�ȣ�� �Է��ϼ���", result);
     }   
     
    @Test
     public void testcase_personalUser_Login_unusal_4(){
    	 
    	tempUserList.addUser(user);		
    	userfile.fileSave(tempUserList);		  	 
        msg = "#join%%computer123";
        
        String result = serverConsole.Login(msg);
        assertEquals("���̵� �Է��ϼ���", result);
     }   

}
