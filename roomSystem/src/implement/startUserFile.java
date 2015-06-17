package implement;
import java.io.ObjectInputStream.GetField;		
		
import DataManagement.userFile;		
import Foundation.userList;		
import ProblemDomain.companyUser;		
import ProblemDomain.conferenceRoom;		
import ProblemDomain.personalUser;

public class startUserFile {
	public static void main(String[] args)		
		{		
			userList list=new userList();		
			userFile file=new userFile();		
					
			personalUser forTestPersonlUser=new personalUser("1","1","³ëÇý¼º","010-4949-7193");
			companyUser forTestCompanyUser=new companyUser("2","2","ÁöÀç¹Î","010-1234-1234","111-1234567");
						
			companyUser hysung=new companyUser("nxsung@naver.com","1","³ëÇý¼º","010-4949-9494","111-1234567");		
			companyUser synyoung=new companyUser("lsy8795@gmail.com","1","ÀÌ½Å¿µ","010-4123-7777","111-1234567");						
			companyUser heanjung=new companyUser("oooyat@naver.com","1","ÀÌÈçÁ¤","010-2992-1234","111-1234567");		
						
			list.addUser(forTestPersonlUser);		
			list.addUser(forTestCompanyUser);			
						
			list.addUser(hysung);		
			list.addUser(synyoung);		
			list.addUser(heanjung);		
						
			file.fileSave(list);	
			
			//test¿ë ÄÚµå		
			list=file.fileRead();		
			for(int i = 0 ; i < list.size();i++)		
			{		
				System.out.println(list.getUser(i).getEmail()+"//"+list.getUser(i).getPassword());		
			}		
		}		
		
}
