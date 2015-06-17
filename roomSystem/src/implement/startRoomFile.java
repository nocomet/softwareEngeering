package implement;
import javax.swing.ImageIcon;		
		
import DataManagement.roomFile;		
import Foundation.roomList;		
import ProblemDomain.conferenceRoom;		
import ProblemDomain.personalUser;		
	
public class startRoomFile{		
	public static void main(String[] args)		
	{		
		roomList list=new roomList();		
		roomFile file=new roomFile();				
		
		// 회의실명 , 시, 구, 수용인원, 값, 소유자명, email
		list.addRoom(new conferenceRoom("자취방 회의실", "대구 광역시", "북구", "30", "10", "노혜성","nxsung@naver.com",3,new ImageIcon("./src/회의실01.png")));		
		list.addRoom(new conferenceRoom("도서관", "대구 광역시", "동구", "20", "10", "노혜성","nxsung@naver.com",4,new ImageIcon("./src/room1.png")));		
		list.addRoom(new conferenceRoom("대구 메르스 대피소", "대구 광역시", "남구", "25", "10", "노혜성","nxsung@naver.com",5,new ImageIcon("./src/room2.png")));		
		list.addRoom(new conferenceRoom("경산의 땅", "대구 광역시", "달성구", "25", "15", "이신영","lsy8795@gmail.com",6,new ImageIcon("./src/회의실02.png")));		
		list.addRoom(new conferenceRoom("기숙사 휴게소", "대구 광역시", "중구", "20", "10", "이신영","lsy8795@gmail.com",7,new ImageIcon("./src/room2.png")));		
		list.addRoom(new conferenceRoom("부산 메르스 대피소", "부산 광역시", "동구", "20", "10", "이신영","lsy8795@gmail.com",8,new ImageIcon("./src/room1.png")));		
		list.addRoom(new conferenceRoom("메스르 병원_회의실", "서울 특별시", "강남구", "20", "10", "이흔정","oooyat@naver.com",0, new ImageIcon("./src/room1.png")));		
		list.addRoom(new conferenceRoom("안전지역_회의실", "서울 특별시", "강동구", "25", "10", "이흔정","oooyat@naver.com",1,new ImageIcon("./src/room2.png")));		
		list.addRoom(new conferenceRoom("공대 9호관", "대구 광역시", "북구", "25", "15", "이흔정","coooyat@naver.com",2,new ImageIcon("./src/room1.png")));		
		
		file.fileSave(list);				
	}		
}