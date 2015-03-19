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

		list.addRoom(new conferenceRoom("ȸ�ǽ�01", "����Ư���ð�����", "20", "10", "�����","company1@knu.ac.kr",0, new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�02", "����Ư���ð�����", "25", "10", "�����","company2@knu.ac.kr",1,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�03", "����Ư���ð�����", "25", "15", "�����","company1@knu.ac.kr",2,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�04", "����Ư���ð�����", "30", "10", "�����","company2@knu.ac.kr",3,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�05", "����Ư���ð�����", "20", "10", "�����","company1@knu.ac.kr",4,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�06", "����Ư���ð�����", "25", "10", "�����","company2@knu.ac.kr",5,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�07", "����Ư���ð�����", "25", "15", "�����","company1@knu.ac.kr",6,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�08", "����Ư���ð�����", "20", "10", "�����","company2@knu.ac.kr",7,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�09", "����Ư���ð��ϱ�", "20", "10", "�����","company1@knu.ac.kr",8,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�10", "����Ư���ð��ϱ�", "25", "10", "�����","company2@knu.ac.kr",9,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�11", "����Ư���ð��ϱ�", "30", "10", "�����","company1@knu.ac.kr",10,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�12", "����Ư���ð��ϱ�", "20", "20", "�����","company2@knu.ac.kr",11,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�13", "����Ư���ð��ϱ�", "25", "20", "�����","company1@knu.ac.kr",12,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�14", "����Ư���ð��ϱ�", "25", "25", "�����","company2@knu.ac.kr",13,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�15", "����Ư���ð�����", "20", "10", "�����","company1@knu.ac.kr",14,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�16", "����Ư���ð�����", "25", "10", "�����","company2@knu.ac.kr",15,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�17", "����Ư���ð�����", "30", "15", "�����","company1@knu.ac.kr",16,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�18", "����Ư���ð�����", "35", "20", "�����","company2@knu.ac.kr",17,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�19", "����Ư���ð�����", "20", "10", "�����","company1@knu.ac.kr",18,new ImageIcon("./src/room1.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�20", "����Ư���ð�����", "25", "20", "�����","company2@knu.ac.kr",19,new ImageIcon("./src/room2.png")));
		list.addRoom(new conferenceRoom("ȸ�ǽ�21", "����Ư���ð�����", "30", "25", "�����","company1@knu.ac.kr",20,new ImageIcon("./src/room1.png")));
//		list.addRoom(new conferenceRoom("1", "����Ư���ð��ϱ�", "20", "10", "�����",7));
//		list.addRoom(new conferenceRoom("1", "����Ư���ð�����", "20", "11", "�����",8));
//		list.addRoom(new conferenceRoom("1", "����Ư���ñ��α�", "20", "11", "�����",9));
//		list.addRoom(new conferenceRoom("1", "����Ư���ñ��α�", "20", "11", "�����",10));
//		list.addRoom(new conferenceRoom("1", "����Ư���ñ�õ��", "20", "11", "�����",11));
//		list.addRoom(new conferenceRoom("1", "����Ư���ó����", "20", "11", "�����",12));
//		list.addRoom(new conferenceRoom("1", "����Ư���õ��빮��", "20", "12", "�����",13));
//		list.addRoom(new conferenceRoom("1", "����Ư���õ�����", "25", "12", "�����",14));
//		list.addRoom(new conferenceRoom("1", "����Ư���õ�����", "25", "12", "�����",15));
//		list.addRoom(new conferenceRoom("1", "����Ư���ø�����", "25", "12", "�����",16));
//		list.addRoom(new conferenceRoom("1", "����Ư���ü��빮��", "25", "12", "�����",17));
//		list.addRoom(new conferenceRoom("1", "����Ư���ü�����", "25", "13", "�����",18));
//		list.addRoom(new conferenceRoom("1", "����Ư���ü��ϱ�", "25", "13", "�����",19));
//		list.addRoom(new conferenceRoom("1", "����Ư���õ��۱�", "25", "13", "�����",20));
//		list.addRoom(new conferenceRoom("1", "����Ư���ü��ʱ�", "25", "13", "�����",21));
//		list.addRoom(new conferenceRoom("1", "����Ư���ü��ı�", "25", "10", "�����",22));
//		list.addRoom(new conferenceRoom("1", "����Ư���ÿ�������", "25", "10", "�����",23));
//		list.addRoom(new conferenceRoom("1", "����Ư���ÿ�걸", "25", "10", "�����",24));
//		list.addRoom(new conferenceRoom("1", "����Ư���þ�õ��", "25", "11", "�����",25));
//		list.addRoom(new conferenceRoom("1", "����Ư��������", "25", "11", "�����",26));
//		list.addRoom(new conferenceRoom("1", "����Ư�������α�", "25", "11", "�����",27));
//		list.addRoom(new conferenceRoom("1", "����Ư�����߱�", "25", "11", "�����",28));
//		list.addRoom(new conferenceRoom("1", "����Ư�����߶���", "25", "11", "�����",29));
//		list.addRoom(new conferenceRoom("1", "����Ư���ð�����", "25", "11", "�����",30));
//		list.addRoom(new conferenceRoom("1", "����Ư���ð��Ǳ�", "25", "11", "�����",31));
//		list.addRoom(new conferenceRoom("1", "����Ư���ñ�����", "30", "12", "�����",32));
//		list.addRoom(new conferenceRoom("1", "����Ư���ñ��α�", "30", "12", "�����",33));
//		list.addRoom(new conferenceRoom("1", "����Ư���ñ�õ��", "30", "12", "�����",34));
//		list.addRoom(new conferenceRoom("1", "����Ư���ð�����", "30", "12", "�����",35));
//		list.addRoom(new conferenceRoom("1", "����Ư���ð�����", "25", "12", "�����",36));
//		list.addRoom(new conferenceRoom("1", "����Ư���ð�����", "35", "12", "�����",37));
//		list.addRoom(new conferenceRoom("1", "����Ư���ð�����", "30", "13", "�����",38));
//		list.addRoom(new conferenceRoom("1", "����Ư���ð�����", "30", "13", "�����",39));
//		list.addRoom(new conferenceRoom("1", "����Ư���ð�����", "30", "13", "�����",40));
//		list.addRoom(new conferenceRoom("1", "����Ư���ð��ϱ�", "30", "13", "�����",41));
//		list.addRoom(new conferenceRoom("1", "����Ư���ð��ϱ�", "30", "13", "�����",42));
//		list.addRoom(new conferenceRoom("1", "����Ư���ð�����", "30", "13", "�����",43));
//		list.addRoom(new conferenceRoom("1", "����Ư���ñ��α�", "30", "13", "�����",44));
//		list.addRoom(new conferenceRoom("1", "����Ư���ñ��α�", "30", "13", "�����",45));
//		list.addRoom(new conferenceRoom("1", "����Ư���ñ�õ��", "30", "13", "�����",46));
//		list.addRoom(new conferenceRoom("1", "����Ư���ó����", "30", "14", "�����",47));
//		list.addRoom(new conferenceRoom("1", "����Ư���õ��빮��", "30", "14", "�����",48));
//		list.addRoom(new conferenceRoom("1", "����Ư���õ�����", "35", "14", "�����",49));
//		list.addRoom(new conferenceRoom("1", "����Ư���õ�����", "35", "14", "�����",50));
//		list.addRoom(new conferenceRoom("1", "����Ư���ø�����", "35", "14", "�����",51));
//		list.addRoom(new conferenceRoom("1", "����Ư���ü��빮��", "35", "14", "�����",52));
//		list.addRoom(new conferenceRoom("1", "����Ư���ü�����", "35", "14", "�����",53));
//		list.addRoom(new conferenceRoom("1", "����Ư���ü��ϱ�", "35", "14", "�����",54));
//		list.addRoom(new conferenceRoom("1", "����Ư���õ��۱�", "35", "14", "�����",55));
//		list.addRoom(new conferenceRoom("1", "����Ư���ü��ʱ�", "35", "14", "�����",56));
//		list.addRoom(new conferenceRoom("1", "����Ư���ü��ı�", "35", "14", "�����",57));
//		list.addRoom(new conferenceRoom("1", "����Ư���ÿ�������", "35", "15", "�����",58));
//		list.addRoom(new conferenceRoom("1", "����Ư���ÿ�걸", "35", "15", "�����",59));
//		list.addRoom(new conferenceRoom("1", "����Ư���þ�õ��", "35", "15", "�����",60));
//		list.addRoom(new conferenceRoom("1", "����Ư��������", "35", "15", "�����",61));
//		list.addRoom(new conferenceRoom("1", "����Ư�������α�", "40", "15", "�����",62));
//		list.addRoom(new conferenceRoom("1", "����Ư�����߱�", "40", "16", "�����",63));
//		list.addRoom(new conferenceRoom("1", "����Ư�����߶���", "40", "16", "�����",64));
//		list.addRoom(new conferenceRoom("1", "����Ư���ð�����", "40", "16", "�����",65));
//		list.addRoom(new conferenceRoom("1", "����Ư���ð��Ǳ�", "20", "16", "�����",66));
//		list.addRoom(new conferenceRoom("1", "����Ư���ñ�����", "25", "17", "�����",67));
//		list.addRoom(new conferenceRoom("1", "����Ư���ñ��α�", "40", "17", "�����",68));
//		list.addRoom(new conferenceRoom("1", "����Ư���ñ�õ��", "40", "17", "�����",69));





		file.fileSave(list);

	}
}
