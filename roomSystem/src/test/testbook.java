package test;

import DataManagement.booklistFile;
import Foundation.CbookList;
import ProblemDomain.bookedRoom;
import ProblemDomain.conferenceRoom;

//
// ������ ������ �����ϱ� ���� �ڵ�
//
public class testbook {
	public static void main(String[] args)
	{
		CbookList list=new CbookList();
		booklistFile file=new booklistFile();
		
		//list.addBook(new bookedRoom("22",2014,12,16,65));
		//list.addBook(new bookedRoom("22",2014,12,20,2));

		//list.addRoom(new conferenceRoom("1", "����Ư���ñ�õ��", "40", "17", "�����"));
		
		file.fileSave(list);
	}
}
