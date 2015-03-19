package PhysicalArchitecture;

import java.util.ArrayList;

import Foundation.CbookList;
import Foundation.roomList;
import ProblemDomain.User;

public class ClientControl {

	private ArrayList<roomList> RList;
	private ArrayList<String> SList;
	private ArrayList<User> UList;
	private ArrayList<CbookList> BList;
	private ArrayList<String> bookResult;
	
	
	public ClientControl()
	{
		RList=new ArrayList<roomList>();
		SList=new ArrayList<String>();
		UList=new ArrayList<User>();
		BList=new ArrayList<CbookList>();
		bookResult=new ArrayList<String>();
	}	
	public void addRoomList(roomList roomlist)
	{
		RList.add(roomlist);
	}
	public void addString(String string)
	{
		SList.add(string);
	}
	public void addBookResult(String result)
	{
		bookResult.add(result);
	}
	public void addUser(User user)
	{
		UList.add(user);
	}
	public void addBookList(CbookList booklist)
	{
		BList.add(booklist);
	}
	public Object getResponse()
	{
		int num=1;
		System.out.println();
		while(true)
		{
			try {
				System.out.print(num+" ");
				num++;
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!SList.isEmpty())
			{
				System.out.println();
				String string=SList.get(0);
				SList.remove(0);
				return string;
			}
			if(!RList.isEmpty())
			{
				System.out.println();
				roomList list=RList.get(0);
				RList.remove(0);
				return list;
			}
			if(!UList.isEmpty())
			{
				System.out.println();
				User user=UList.get(0);
				UList.remove(0);
				System.out.println();
				return user;
			}
		}
		
	}
	public CbookList getBookListResponce()
	{
		int num=1;
		System.out.println();
		while(true)
		{
			try {
				
				System.out.print(num+" ");
				num++;
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!BList.isEmpty())
			{
				CbookList list=BList.get(0);
				BList.remove(0);
				System.out.println();
				return list;
			}
		}
		
	}
	public String getStringResponce()
	{
		int num=1;
		System.out.println();
		while(true)
		{
			try {
				;
				System.out.print(num+" ");
				num++;
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!SList.isEmpty())
			{
				System.out.println();
				String string=SList.get(0);
				SList.remove(0);
				return string;
			}			
		}
	}
	public roomList getRoomListResponce()
	{
		int num=1;
		System.out.println();
		while(true)
		{
			try {
				
				System.out.print(num+" ");
				num++;
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!RList.isEmpty())
			{
				System.out.println();
				roomList list=RList.get(0);
				RList.remove(0);
				return list;
			}
		}
	}
	public boolean getBookResponce()
	{
		int num=1;
		System.out.println();
		while(true)
		{
			try {
				System.out.print(num+" ");
				num++;
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!bookResult.isEmpty())
			{
				System.out.println();
				String result=bookResult.get(0);
				RList.remove(0);
				if(result.equals("BOOK"))
					return true;
				if(result.equals("FAIL"))
					return false;
			}
		}
	}
	public User getUserResponce()
	{
		int num=1;
		System.out.println();
		while(true)
		{
			try {
				System.out.print(num+" ");
				num++;
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!UList.isEmpty())
			{
				System.out.println();
				User user=UList.get(0);
				UList.remove(0);
				return user;
			}
		}
	}
	public void resetAll()
	{
		RList=new ArrayList<roomList>();
		SList=new ArrayList<String>();
		UList=new ArrayList<User>();
	}
}
