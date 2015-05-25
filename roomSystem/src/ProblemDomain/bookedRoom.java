package ProblemDomain;

import java.io.Serializable;

public class bookedRoom implements Serializable, bookStateType
{
	private String ownerEmail;
	private String email;
	private int year;
	private int month;
	private int day;
	private int roomNum;
	private int state;

	
	public bookedRoom(String email, String ownerEmail,int year, int month, int day, int roomNum)
	{
		this.email = email;
		this.ownerEmail=ownerEmail;
		this.year = year;
		this.month = month;
		this.day =day;
		this.roomNum = roomNum;	
		this.state = waitCharge;
	}	
	public boolean equalBook(bookedRoom room)
	{
		boolean result=false;
		if(year==room.getyear()&&month==room.getmonth()&&day==room.getday()&&roomNum==room.getroomNum())
		{
			System.out.println("result가 ture인게 실행댐");
			result = true;
		}
		
		return result;
	}
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getmonth() {
		return month;
	}
	public void setmonth(int month) {
		this.month = month;
	}
	public int getyear() {
		return year;
	}
	public void setyear(int year) {
		this.year = year;
	}
	public int getday() {
		return day;
	}
	public void setday(int day) {
		this.day = day;
	}
	public int getroomNum() {
		return roomNum;
	}
	public void setroomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
}