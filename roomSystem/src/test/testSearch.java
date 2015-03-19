package test;
import javax.swing.ImageIcon;

import DataManagement.roomFile;
import Foundation.roomList;
import ProblemDomain.conferenceRoom;
import ProblemDomain.personalUser;

public class testSearch {
	public static void main(String[] args)
	{
		roomList list=new roomList();
		roomFile file=new roomFile();
		roomList SearchList = new roomList();

		list.addRoom(new conferenceRoom("회의실01", "서울특별시강남구", "20", "10", "지재민","company1@knu.ac.kr",0, new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("회의실02", "서울특별시강남구", "25", "10", "지재민","company2@knu.ac.kr",1,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("회의실03", "서울특별시강남구", "25", "15", "지재민","company1@knu.ac.kr",2,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("회의실04", "서울특별시강남구", "30", "10", "지재민","company2@knu.ac.kr",3,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("회의실05", "서울특별시강동구", "20", "10", "지재민","company1@knu.ac.kr",4,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("회의실06", "서울특별시강동구", "25", "10", "지재민","company2@knu.ac.kr",5,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("회의실07", "서울특별시강동구", "25", "15", "지재민","company1@knu.ac.kr",6,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("회의실08", "서울특별시강서구", "20", "10", "지재민","company2@knu.ac.kr",7,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("회의실09", "서울특별시강북구", "20", "10", "지재민","company1@knu.ac.kr",8,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("회의실10", "서울특별시강북구", "25", "10", "지재민","company2@knu.ac.kr",9,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("회의실11", "서울특별시강북구", "30", "10", "지재민","company1@knu.ac.kr",10,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("회의실12", "서울특별시강북구", "20", "20", "지재민","company2@knu.ac.kr",11,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("회의실13", "서울특별시강북구", "25", "20", "지재민","company1@knu.ac.kr",12,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("회의실14", "서울특별시강북구", "25", "25", "지재민","company2@knu.ac.kr",13,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("회의실15", "서울특별시강남구", "20", "10", "지재민","company1@knu.ac.kr",14,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("회의실16", "서울특별시강남구", "25", "10", "지재민","company2@knu.ac.kr",15,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("회의실17", "서울특별시강남구", "30", "15", "지재민","company1@knu.ac.kr",16,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("회의실18", "서울특별시강남구", "35", "20", "지재민","company2@knu.ac.kr",17,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("회의실19", "서울특별시강남구", "20", "10", "지재민","company1@knu.ac.kr",18,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("회의실20", "서울특별시강남구", "25", "20", "지재민","company2@knu.ac.kr",19,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("회의실21", "서울특별시강남구", "30", "25", "지재민","company1@knu.ac.kr",20,new ImageIcon("./src/room1.png")));
//		list.addRoom(new conferenceRoom("1", "서울특별시강북구", "20", "10", "지재민",7));
//		list.addRoom(new conferenceRoom("1", "서울특별시강남구", "20", "11", "지재민",8));
//		list.addRoom(new conferenceRoom("1", "서울특별시구로구", "20", "11", "지재민",9));
//		list.addRoom(new conferenceRoom("1", "서울특별시구로구", "20", "11", "지재민",10));
//		list.addRoom(new conferenceRoom("1", "서울특별시금천구", "20", "11", "지재민",11));
//		list.addRoom(new conferenceRoom("1", "서울특별시노원구", "20", "11", "지재민",12));
//		list.addRoom(new conferenceRoom("1", "서울특별시동대문구", "20", "12", "지재민",13));
//		list.addRoom(new conferenceRoom("1", "서울특별시도봉구", "25", "12", "지재민",14));
//		list.addRoom(new conferenceRoom("1", "서울특별시도봉구", "25", "12", "지재민",15));
//		list.addRoom(new conferenceRoom("1", "서울특별시마포구", "25", "12", "지재민",16));
//		list.addRoom(new conferenceRoom("1", "서울특별시서대문구", "25", "12", "지재민",17));
//		list.addRoom(new conferenceRoom("1", "서울특별시성동구", "25", "13", "지재민",18));
//		list.addRoom(new conferenceRoom("1", "서울특별시성북구", "25", "13", "지재민",19));
//		list.addRoom(new conferenceRoom("1", "서울특별시동작구", "25", "13", "지재민",20));
//		list.addRoom(new conferenceRoom("1", "서울특별시서초구", "25", "13", "지재민",21));
//		list.addRoom(new conferenceRoom("1", "서울특별시송파구", "25", "10", "지재민",22));
//		list.addRoom(new conferenceRoom("1", "서울특별시영등포구", "25", "10", "지재민",23));
//		list.addRoom(new conferenceRoom("1", "서울특별시용산구", "25", "10", "지재민",24));
//		list.addRoom(new conferenceRoom("1", "서울특별시양천구", "25", "11", "지재민",25));
//		list.addRoom(new conferenceRoom("1", "서울특별시은평구", "25", "11", "지재민",26));
//		list.addRoom(new conferenceRoom("1", "서울특별시종로구", "25", "11", "지재민",27));
//		list.addRoom(new conferenceRoom("1", "서울특별시중구", "25", "11", "지재민",28));
//		list.addRoom(new conferenceRoom("1", "서울특별시중랑구", "25", "11", "지재민",29));
//		list.addRoom(new conferenceRoom("1", "서울특별시강남구", "25", "11", "지재민",30));
//		list.addRoom(new conferenceRoom("1", "서울특별시관악구", "25", "11", "지재민",31));
//		list.addRoom(new conferenceRoom("1", "서울특별시광진구", "30", "12", "지재민",32));
//		list.addRoom(new conferenceRoom("1", "서울특별시구로구", "30", "12", "지재민",33));
//		list.addRoom(new conferenceRoom("1", "서울특별시금천구", "30", "12", "지재민",34));
//		list.addRoom(new conferenceRoom("1", "서울특별시강남구", "30", "12", "지재민",35));
//		list.addRoom(new conferenceRoom("1", "서울특별시강남구", "25", "12", "지재민",36));
//		list.addRoom(new conferenceRoom("1", "서울특별시강남구", "35", "12", "지재민",37));
//		list.addRoom(new conferenceRoom("1", "서울특별시강동구", "30", "13", "지재민",38));
//		list.addRoom(new conferenceRoom("1", "서울특별시강동구", "30", "13", "지재민",39));
//		list.addRoom(new conferenceRoom("1", "서울특별시강서구", "30", "13", "지재민",40));
//		list.addRoom(new conferenceRoom("1", "서울특별시강북구", "30", "13", "지재민",41));
//		list.addRoom(new conferenceRoom("1", "서울특별시강북구", "30", "13", "지재민",42));
//		list.addRoom(new conferenceRoom("1", "서울특별시강남구", "30", "13", "지재민",43));
//		list.addRoom(new conferenceRoom("1", "서울특별시구로구", "30", "13", "지재민",44));
//		list.addRoom(new conferenceRoom("1", "서울특별시구로구", "30", "13", "지재민",45));
//		list.addRoom(new conferenceRoom("1", "서울특별시금천구", "30", "13", "지재민",46));
//		list.addRoom(new conferenceRoom("1", "서울특별시노원구", "30", "14", "지재민",47));
//		list.addRoom(new conferenceRoom("1", "서울특별시동대문구", "30", "14", "지재민",48));
//		list.addRoom(new conferenceRoom("1", "서울특별시도봉구", "35", "14", "지재민",49));
//		list.addRoom(new conferenceRoom("1", "서울특별시도봉구", "35", "14", "지재민",50));
//		list.addRoom(new conferenceRoom("1", "서울특별시마포구", "35", "14", "지재민",51));
//		list.addRoom(new conferenceRoom("1", "서울특별시서대문구", "35", "14", "지재민",52));
//		list.addRoom(new conferenceRoom("1", "서울특별시성동구", "35", "14", "지재민",53));
//		list.addRoom(new conferenceRoom("1", "서울특별시성북구", "35", "14", "지재민",54));
//		list.addRoom(new conferenceRoom("1", "서울특별시동작구", "35", "14", "지재민",55));
//		list.addRoom(new conferenceRoom("1", "서울특별시서초구", "35", "14", "지재민",56));
//		list.addRoom(new conferenceRoom("1", "서울특별시송파구", "35", "14", "지재민",57));
//		list.addRoom(new conferenceRoom("1", "서울특별시영등포구", "35", "15", "지재민",58));
//		list.addRoom(new conferenceRoom("1", "서울특별시용산구", "35", "15", "지재민",59));
//		list.addRoom(new conferenceRoom("1", "서울특별시양천구", "35", "15", "지재민",60));
//		list.addRoom(new conferenceRoom("1", "서울특별시은평구", "35", "15", "지재민",61));
//		list.addRoom(new conferenceRoom("1", "서울특별시종로구", "40", "15", "지재민",62));
//		list.addRoom(new conferenceRoom("1", "서울특별시중구", "40", "16", "지재민",63));
//		list.addRoom(new conferenceRoom("1", "서울특별시중랑구", "40", "16", "지재민",64));
//		list.addRoom(new conferenceRoom("1", "서울특별시강남구", "40", "16", "지재민",65));
//		list.addRoom(new conferenceRoom("1", "서울특별시관악구", "20", "16", "지재민",66));
//		list.addRoom(new conferenceRoom("1", "서울특별시광진구", "25", "17", "지재민",67));
//		list.addRoom(new conferenceRoom("1", "서울특별시구로구", "40", "17", "지재민",68));
//		list.addRoom(new conferenceRoom("1", "서울특별시금천구", "40", "17", "지재민",69));





		file.fileSave(list);

	}
}
