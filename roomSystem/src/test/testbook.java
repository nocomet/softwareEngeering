package test;

import DataManagement.booklistFile;
import Foundation.CbookList;
import ProblemDomain.bookedRoom;
import ProblemDomain.conferenceRoom;

public class testbook {
	public static void main(String[] args)
	{
		CbookList list=new CbookList();
		booklistFile file=new booklistFile();
		
		//list.addBook(new bookedRoom("22",2014,12,16,65));
		//list.addBook(new bookedRoom("22",2014,12,20,2));

		//list.addRoom(new conferenceRoom("1", "서울특별시금천구", "40", "17", "지재민"));
		
		file.fileSave(list);
	}
}
