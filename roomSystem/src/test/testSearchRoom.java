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
	
	public conferenceRoom testRoom1 = new conferenceRoom("공대9호관","대구광역시","북구","2015#5#14", "10", "흔정", "oooyat@naver.com");
	public conferenceRoom testRoom2 = new conferenceRoom("사립회의실","대구광역시","중구","2015#5#14", "10", "흔정", "oooyat@naver.com");
	public conferenceRoom testRoom3 = new conferenceRoom("바다회의실","부산광역시","해운대구","2015#5#14", "10", "흔정", "oooyat@naver.com");
    public conferenceRoom testRoom4 = new conferenceRoom("공대4호관","대구광역시","북구","2015#5#14", "30", "흔정", "oooyat@naver.com");
    public conferenceRoom testRoom5 = new conferenceRoom("회의실a","대구 광역시","북구","2015#5#15", "10", "흔정", "oooyat@naver.com");
	       
	@Test
	public void testSearchRoom() {    
		testRoomList.addRoom(testRoom1);
	    testRoomList.addRoom(testRoom2);
	    testRoomList.addRoom(testRoom3);
	    testRoomList.addRoom(testRoom4);
	    testRoomList.addRoom(testRoom5);
	    testFile.fileSave(testRoomList);
	}

	public void testcase_searchRoom_all(){//모든항목에 정보입력
		   
	    tempList = server.SearchRoom(testRoomList, "대구광역시", "북구","2015#5#14", "10", true, true, true, true);
	    expectedList.addRoom(testRoom1);
	    assertEquals(tempList,expectedList);
	}
	
	public void testcase_searchRoom_except_city_address(){//구 제외 정보입력
		 
		tempList = server.SearchRoom(testRoomList, "대구 광역시","", "2015#5#14", "10", false, false, true, true);
	    expectedList.addRoom(testRoom1);
	    expectedList.addRoom(testRoom2);
	    assertEquals(tempList,expectedList);
	    
	   }
	
	public void testcase_searchRoom_except_address(){//위치제외 정보입력
		 
	    tempList = server.SearchRoom(testRoomList, "","", "2015#5#14", "10", false, false, true, true);
	    expectedList.addRoom(testRoom1);
	    expectedList.addRoom(testRoom2);
	    expectedList.addRoom(testRoom3);
	    assertEquals(tempList,expectedList);
	    
	   }
	
	public void testcase_searchRoom_except_date(){//날짜제외 정보입력
		tempList = server.SearchRoom(testRoomList, "대구광역시", "북구", "", "30",true, true, false, true);
	    expectedList.addRoom(testRoom1);
	    expectedList.addRoom(testRoom5);
	    assertEquals(tempList,expectedList);
	    
	   }
	
	public void testcase_searchRoom_except_people(){//수용인원 제외 정보입력
		 
	    tempList = server.SearchRoom(testRoomList, "대구광역시", "북구" ,"2015#5#14", "", true, true, true, false);
	    expectedList.addRoom(testRoom1);
	    expectedList.addRoom(testRoom4);
	    assertEquals(tempList,expectedList);
	    
	   }
	
	public void testcase_searchRoom_people(){//수용인원정보만 입력 할때
		 
	    tempList = server.SearchRoom(testRoomList, "", "" ,"", "10", true, true, true, false);
	    expectedList.addRoom(testRoom1);
	    expectedList.addRoom(testRoom2);
	    expectedList.addRoom(testRoom3);
	    expectedList.addRoom(testRoom5);
	    assertEquals(tempList,expectedList);
	    
	   }
	
	public void testcase_searchRoom_Big_people(){//수용인원정보가 충분히 클때
		 
	    tempList = server.SearchRoom(testRoomList, "", "" ,"", "100", true, true, true, false);
	    expectedList.addRoom(testRoom1);
	    expectedList.addRoom(testRoom2);
	    expectedList.addRoom(testRoom3);
	    expectedList.addRoom(testRoom4);
	    expectedList.addRoom(testRoom5);
	    assertEquals(tempList,expectedList);
	    
	   }
	
	public void testcase_searchRoom_Small_people(){//수용인원정보가 충분히 작을 때
		 
	    tempList = server.SearchRoom(testRoomList, "", "" ,"", "5",  true, true, true, false);
	    assertEquals(tempList,expectedList);
	    
	   }
	    
	   public void testcase_searchRoom_except_all(){//정보넣지 않은채 정보입력
	 
	    tempList = server.SearchRoom(testRoomList, "", "", "", "", false, false, false, false);
	    expectedList.addRoom(testRoom1);
	    expectedList.addRoom(testRoom2);
	    expectedList.addRoom(testRoom3);
	    expectedList.addRoom(testRoom4);
	    expectedList.addRoom(testRoom5);    
	    assertEquals(tempList,expectedList);
	    
	   }
}


