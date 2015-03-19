package ProblemDomain;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Foundation.CalendarInfo;

public class conferenceRoom implements Serializable {

	
	private String buildingname;
	private String address;
	private String acceptPeoNum;
	private String rentCost;
	private String ownerName;
	private String userName;
	private String ownerEmail;
	private int roomNumber;
	private ImageIcon photo;
	
	private ArrayList<CalendarInfo> calendarList;
	
	
	
	public conferenceRoom(String buildingname, String address, String acceptpeonum, 
			String Rentcost, String Ownername,String ownerE) {
		
		this.buildingname = buildingname;
		this.address = address;
		this.acceptPeoNum = acceptpeonum;
		this.rentCost = Rentcost;
		this.ownerName = Ownername;
		ownerEmail=ownerE;
		userName = "";
		roomNumber=10000;
		this.photo=null;
		
		CalendarInfo firstCalendar = new CalendarInfo();
		calendarList = new ArrayList<CalendarInfo>();
		calendarList.add(firstCalendar);
	}
	
	public conferenceRoom(String buildingname, String address, String acceptpeonum, 
			String Rentcost, String Ownername,String ownerE,ImageIcon photo) {
		
		this.buildingname = buildingname;
		this.address = address;
		this.acceptPeoNum = acceptpeonum;
		this.rentCost = Rentcost;
		this.ownerName = Ownername;
		ownerEmail=ownerE;
		userName = "";
		roomNumber=10000;
		this.photo=photo;
		
		CalendarInfo firstCalendar = new CalendarInfo();
		calendarList = new ArrayList<CalendarInfo>();
		calendarList.add(firstCalendar);
	}
	//----테스트용으로 만든 생성자
	public conferenceRoom(String buildingname, String address, String acceptpeonum, 
			String Rentcost, String Ownername) {
		this.buildingname = buildingname;
		this.address = address;
		this.acceptPeoNum = acceptpeonum;
		this.rentCost = Rentcost;
		this.ownerName = Ownername;
		userName = "";		
		roomNumber=10000;
		
		CalendarInfo firstCalendar = new CalendarInfo();
		calendarList = new ArrayList<CalendarInfo>();
		calendarList.add(firstCalendar);
			
	}
	//----테스트용으로 만든 생성자
	public conferenceRoom(String buildingname, String address, String acceptpeonum, 
			String Rentcost, String Ownername,int num) {
		this.buildingname = buildingname;
		this.address = address;
		this.acceptPeoNum = acceptpeonum;
		this.rentCost = Rentcost;
		this.ownerName = Ownername;
		userName = "";		
		roomNumber=num;
		
		CalendarInfo firstCalendar = new CalendarInfo();
		calendarList = new ArrayList<CalendarInfo>();
		calendarList.add(firstCalendar);
			
	}
	//----테스트용으로 만든 생성자
	public conferenceRoom(String buildingname, String address, String acceptpeonum, 
			String Rentcost, String Ownername,String ownerE,int num,ImageIcon photo) {
		this.buildingname = buildingname;
		this.address = address;
		this.acceptPeoNum = acceptpeonum;
		this.rentCost = Rentcost;
		this.ownerName = Ownername;
		ownerEmail=ownerE;
		userName = "";
		roomNumber=num;
		this.photo=photo;
		
		CalendarInfo firstCalendar = new CalendarInfo();
		calendarList = new ArrayList<CalendarInfo>();
		calendarList.add(firstCalendar);
		System.out.println("****");
	}
	public String getName() {
		return buildingname;
	}

	public void setName(String buildingname) {
		this.buildingname = buildingname;
	}

	public String getOwnName() {
		return ownerName;
	}

	public void setOwnName(String Ownername){
		this.ownerName= Ownername;
	}	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getAcceptPeoNum(){
		return acceptPeoNum;
	}
	public void setAcceptPeoNum(String acceptpeonum){
		this.acceptPeoNum = acceptpeonum;
	}
	public String getRentcost(){
		return rentCost;
	}
	
	public void setRentcost(String Rentcost){
		this.rentCost = Rentcost;
	}
	
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public ImageIcon getPhoto(){
		return photo;
	}
	//-----------------------------------------------------------------------//
	
	
	public CalendarInfo getCalendar(int i) //원하는 달의 정보를 가져옴 
	{
		return calendarList.get(i);
	}
	public int getcalendarListSize() //calendarList의 크기 가져옴(SwingCalendar에서 사용됨)
	{
		return calendarList.size();
	}
	
	public void setSchedule(int year, int month, int day) //내가 원하는 년,월,일에 예약해줌
	{
		for(int i = 0; i <getcalendarListSize(); i++)
		{
			if(calendarList.get(i).getmonth() == month && calendarList.get(i).getYear() == year)
			{
				calendarList.get(i).setbook(day-1, true);
				break;
			}
			else
			{
				addcalendarList();
			}
		}
		//System.out.println(year+" "+month+" "+day);
	}
	
	public void cancelSchedule(int year, int month, int day)
	{
		for(int i = 0; i <getcalendarListSize(); i++)
		{
			if(calendarList.get(i).getmonth() == month && calendarList.get(i).getYear() == year)
			{
				calendarList.get(i).setbook(day-1, false);
				break;
			}
			else
			{
				addcalendarList();
			}
		}
	}
	
	public void addcalendarList() //calendarList에 달 추가
	{
		int lastyear = calendarList.get(getcalendarListSize()-1).getYear();
		int lastmonth = calendarList.get(getcalendarListSize()-1).getmonth();
		if(lastmonth >=12)
		{
			lastmonth = 1;
			lastyear++;
		}
		else
		{
			lastmonth++;
		}
		CalendarInfo cal = new CalendarInfo(lastyear,lastmonth);
		calendarList.add(cal);
	}
	
//	public void printRoomInfo(){
//		System.out.print(getName());
//		System.out.print(" "+getAddress());
//		System.out.print(" "+getAcceptPeoNum());
//		System.out.println(" "+getRentcost());
//	}
	
}
