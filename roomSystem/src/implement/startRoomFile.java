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
		
		// ȸ�ǽǸ� , ��, ��, �����ο�, ��, �����ڸ�, email
		list.addRoom(new conferenceRoom("����� ȸ�ǽ�", "�뱸 ������", "�ϱ�", "30", "10", "������","nxsung@naver.com",3,new ImageIcon("./src/ȸ�ǽ�01.png")));		
		list.addRoom(new conferenceRoom("������", "�뱸 ������", "����", "20", "10", "������","nxsung@naver.com",4,new ImageIcon("./src/room1.png")));		
		list.addRoom(new conferenceRoom("�뱸 �޸��� ���Ǽ�", "�뱸 ������", "����", "25", "10", "������","nxsung@naver.com",5,new ImageIcon("./src/room2.png")));		
		list.addRoom(new conferenceRoom("����� ��", "�뱸 ������", "�޼���", "25", "15", "�̽ſ�","lsy8795@gmail.com",6,new ImageIcon("./src/ȸ�ǽ�02.png")));		
		list.addRoom(new conferenceRoom("����� �ްԼ�", "�뱸 ������", "�߱�", "20", "10", "�̽ſ�","lsy8795@gmail.com",7,new ImageIcon("./src/room2.png")));		
		list.addRoom(new conferenceRoom("�λ� �޸��� ���Ǽ�", "�λ� ������", "����", "20", "10", "�̽ſ�","lsy8795@gmail.com",8,new ImageIcon("./src/room1.png")));		
		list.addRoom(new conferenceRoom("�޽��� ����_ȸ�ǽ�", "���� Ư����", "������", "20", "10", "������","oooyat@naver.com",0, new ImageIcon("./src/room1.png")));		
		list.addRoom(new conferenceRoom("��������_ȸ�ǽ�", "���� Ư����", "������", "25", "10", "������","oooyat@naver.com",1,new ImageIcon("./src/room2.png")));		
		list.addRoom(new conferenceRoom("���� 9ȣ��", "�뱸 ������", "�ϱ�", "25", "15", "������","coooyat@naver.com",2,new ImageIcon("./src/room1.png")));		
		
		file.fileSave(list);				
	}		
}