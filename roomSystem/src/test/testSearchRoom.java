package test;

import static org.junit.Assert.*;

import java.io.ObjectOutputStream;

import org.junit.Test;

import DataManagement.roomFile;
import Foundation.roomList;
import PhysicalArchitecture.ServerConsole;
import ProblemDomain.conferenceRoom;

public class testSearchRoom {
  
	ObjectOutputStream serverOutputStream;
	ServerConsole server = new ServerConsole(serverOutputStream);
	public roomFile testFile = new roomFile();
	public roomList testRoomList = new roomList();
	public roomList tempList = new roomList();
	public roomList expectedList = new roomList();
	
	public conferenceRoom testRoom1 = new conferenceRoom("����9ȣ��","�뱸������","�ϱ�","2015#5#14", "10", "����", "oooyat@naver.com");
	public conferenceRoom testRoom2 = new conferenceRoom("�縳ȸ�ǽ�","�뱸������","�߱�","2015#5#14", "10", "����", "oooyat@naver.com");
	public conferenceRoom testRoom3 = new conferenceRoom("�ٴ�ȸ�ǽ�","�λ걤����","�ؿ�뱸","2015#5#14", "10", "����", "oooyat@naver.com");
    public conferenceRoom testRoom4 = new conferenceRoom("����4ȣ��","�뱸������","�ϱ�","2015#5#14", "30", "����", "oooyat@naver.com");
    public conferenceRoom testRoom5 = new conferenceRoom("ȸ�ǽ�a","�뱸 ������","�ϱ�","2015#5#15", "10", "����", "oooyat@naver.com");
	       
	@Test
	public void testSearchRoom() {    
		testRoomList.addRoom(testRoom1);
	    testRoomList.addRoom(testRoom2);
	    testRoomList.addRoom(testRoom3);
	    testRoomList.addRoom(testRoom4);
	    testRoomList.addRoom(testRoom5);
	    testFile.fileSave(testRoomList);
	}

	public void testcase_searchRoom_all(){//����׸� �����Է�
		   
	    tempList = server.SearchRoom(testRoomList, "�뱸������", "�ϱ�","2015#5#14", "10", true, true, true, true);
	    expectedList.addRoom(testRoom1);
	    assertEquals(tempList,expectedList);
	}
	
	public void testcase_searchRoom_except_city_address(){//�� ���� �����Է�
		 
		tempList = server.SearchRoom(testRoomList, "�뱸 ������","", "2015#5#14", "10", false, false, true, true);
	    expectedList.addRoom(testRoom1);
	    expectedList.addRoom(testRoom2);
	    assertEquals(tempList,expectedList);
	    
	   }
	
	public void testcase_searchRoom_except_address(){//��ġ���� �����Է�
		 
	    tempList = server.SearchRoom(testRoomList, "","", "2015#5#14", "10", false, false, true, true);
	    expectedList.addRoom(testRoom1);
	    expectedList.addRoom(testRoom2);
	    expectedList.addRoom(testRoom3);
	    assertEquals(tempList,expectedList);
	    
	   }
	
	public void testcase_searchRoom_except_date(){//��¥���� �����Է�
		tempList = server.SearchRoom(testRoomList, "�뱸������", "�ϱ�", "", "30",true, true, false, true);
	    expectedList.addRoom(testRoom1);
	    expectedList.addRoom(testRoom5);
	    assertEquals(tempList,expectedList);
	    
	   }
	
	public void testcase_searchRoom_except_people(){//�����ο� ���� �����Է�
		 
	    tempList = server.SearchRoom(testRoomList, "�뱸������", "�ϱ�" ,"2015#5#14", "", true, true, true, false);
	    expectedList.addRoom(testRoom1);
	    expectedList.addRoom(testRoom4);
	    assertEquals(tempList,expectedList);
	    
	   }
	
	public void testcase_searchRoom_people(){//�����ο������� �Է� �Ҷ�
		 
	    tempList = server.SearchRoom(testRoomList, "", "" ,"", "10", true, true, true, false);
	    expectedList.addRoom(testRoom1);
	    expectedList.addRoom(testRoom2);
	    expectedList.addRoom(testRoom3);
	    expectedList.addRoom(testRoom5);
	    assertEquals(tempList,expectedList);
	    
	   }
	
	public void testcase_searchRoom_Big_people(){//�����ο������� ����� Ŭ��
		 
	    tempList = server.SearchRoom(testRoomList, "", "" ,"", "100", true, true, true, false);
	    expectedList.addRoom(testRoom1);
	    expectedList.addRoom(testRoom2);
	    expectedList.addRoom(testRoom3);
	    expectedList.addRoom(testRoom4);
	    expectedList.addRoom(testRoom5);
	    assertEquals(tempList,expectedList);
	    
	   }
	
	public void testcase_searchRoom_Small_people(){//�����ο������� ����� ���� ��
		 
	    tempList = server.SearchRoom(testRoomList, "", "" ,"", "5",  true, true, true, false);
	    assertEquals(tempList,expectedList);
	    
	   }
	    
	   public void testcase_searchRoom_except_all(){//�������� ����ä �����Է�
	 
	    tempList = server.SearchRoom(testRoomList, "", "", "", "", false, false, false, false);
	    expectedList.addRoom(testRoom1);
	    expectedList.addRoom(testRoom2);
	    expectedList.addRoom(testRoom3);
	    expectedList.addRoom(testRoom4);
	    expectedList.addRoom(testRoom5);    
	    assertEquals(tempList,expectedList);
	    
	   }
}


