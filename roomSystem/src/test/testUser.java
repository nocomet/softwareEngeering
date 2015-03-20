package test;

import java.io.ObjectInputStream.GetField;

import DataManagement.userFile;
import Foundation.userList;
import ProblemDomain.companyUser;
import ProblemDomain.conferenceRoom;
import ProblemDomain.personalUser;


//
//데이터 파일을 생성하기 위한 코드
//

public class testUser {
	public static void main(String[] args)
	{
		userList list=new userList();
		userFile file=new userFile();
		
		personalUser hysung1=new personalUser("nxsung@naver.com","1","노혜성","010-4949-7193");
		personalUser hysung2=new personalUser("comat@knu.ac.kr","1","노혜성","010-4949-7193");
		//personalUser hysung2=new personalUser("1","1","노혜성","010-4949-7193");
		companyUser hysung3=new companyUser("company1@knu.ac.kr","1","지재민","010-1234-1234","111-1234567");
		companyUser hysung4=new companyUser("company2@knu.ac.kr","1","지재민","010-1234-1234","111-1234567");
		//companyUser hysung4=new companyUser("2","2","지재민","010-1234-1234","111-1234567");
		
		list.addUser(hysung1);
		list.addUser(hysung2);
		list.addUser(hysung3);
		list.addUser(hysung4);
		
		file.fileSave(list);
		
		list=file.fileRead();
		for(int i = 0 ; i < list.size();i++)
		{
			System.out.println(list.getUser(i).getEmail()+"//"+list.getUser(i).getPassword());
		}
	}
	
}
