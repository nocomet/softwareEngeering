package GUI;

import java.io.File;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Foundation.CbookList;
import Foundation.roomList;
import PhysicalArchitecture.Client;
import ProblemDomain.User;
import ProblemDomain.bookedRoom;
import ProblemDomain.companyUser;
import ProblemDomain.conferenceRoom;
import ProblemDomain.personalUser;
public class GUI_console implements Serializable {

	private JFrame frame;
	private Client client;
	private User user;
	private static GUI_console gui_console= new GUI_console();

	private GUI_console()	{	 }

	public void setClient(Client c)
	{
		client= c;
	}
	public void setFrame(JFrame f)
	{
		frame=f;
	}
	public void setUser(User u)
	{
		user=u;
	}
	public User getUser()
	{
		return user;
	}

	//---------------function--------------//

	public void login(String e, String pass)
	{
		String msg = "#login" + e + "%" + pass;

		client.sendToServer(msg);

		Object response = client.getcControl().getResponse();
		if(response instanceof User)
		{

			if (response instanceof personalUser)
			{
				user=(personalUser)response;
				moveCMenu();
			}
			else if(response instanceof companyUser)
			{
				user=(companyUser)response;
				moveBmenu();
			}
		}
		else if(response instanceof String)
		{
			JOptionPane.showMessageDialog(null, response);
		}

	}
	public void Bjoin(String e,String pass, String name, String bn, String tel)
	{
		String console = "#joinB" + e + "%" + pass + "%" + name
				+ "%" + tel + "%" + bn;
		client.sendToServer(console);
	}
	public void Cjoin(String e,String pass, String name,  String tel)
	{
		String console = "#joinC"+e+"%"+pass+"%"+name+"%"+tel;
		client.sendToServer(console);
	}
	public void searchRoom(String date, String address, String num)
	{
		String console = "#search" + date + "%" + address + "%" + num;
		client.sendToServer(console);
	}
	public void updateInfo(String e, String oripw,String pass, String name, String tel)
	{
		String console = "#updateInfo" + e + "%" +oripw + "%" + pass + "%" + name
				+ "%" + "%" + tel;
		client.sendToServer(console);
	}
	public void viewList()
	{
		String console = "#ViewList" + user.getEmail();
		client.sendToServer(console);
	}
	public void sendToSeverRoomList(roomList roomlist)
	{
		client.sendToServer(roomlist);		
	}
	public void sendToSeverRoom(conferenceRoom room)
	{
		client.sendToServer(room);		
	}
	public void sendToSeverBook(bookedRoom book)
	{
		client.sendToServer(book);      
	}
	public void sendToServerBookList(CbookList booklist)
	{
		client.sendToServerBookList(booklist);
	}
	public void getRoomListFromServer()
	{
		String console = "#RoomList";
		client.sendToServer(console);	
	}
	public void getBookListFromServer()
	{
		String console = "#BookList";
		client.sendToServer(console);
	}
	public void getBookListFromServerWithEmail()
	{
		String console = "#BookListWithEmail" + user.getEmail();
		client.sendToServer(console);
	}
	public void getBookListFromServerWithOwnerEmail() {
		// TODO Auto-generated method stub
		String console = "#BookListWithOwnerEmail" + user.getEmail();
		client.sendToServer(console);
	}	
	public void cancelBook(int roomnum,int year, int month, int day)
	{
		String console = "#BookCancel"+roomnum+"%"+year+"%"+month+"%"+day;
		client.sendToServer(console);
	}
	public conferenceRoom getConferenceRoomForRoomNumber(int roomNumber)
	{
		roomList roomlist;
		getRoomListFromServer();
		roomlist=getRoomListResponse();

		for(int i =0 ; i < roomlist.size();i++)
		{
			if(roomNumber==roomlist.getRoom(i).getRoomNumber())
				return roomlist.getRoom(i);
		}
		return null;
	}
	//------------return---------------//
	public roomList getRoomListResponse()
	{
		roomList roomlist = client.getcControl().getRoomListResponce();
		client.getcControl().resetAll();
		return roomlist;
	}
	public String getStringResponse()
	{
		String response;
		response = client.getcControl().getStringResponce();
		client.getcControl().resetAll();
		return response;
	}
	public String searchFile()
	{
		JFileChooser chooser = new JFileChooser();

		int value = chooser.showOpenDialog(null);
		if(value == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			return file.toString();
		}
		return "파일경로";
	}
	public CbookList getBookListResponse()
	{
		CbookList booklist = client.getcControl().getBookListResponce();
		return booklist;
	}
	//---------------move--------------//
	public void moveMain()
	{
		nomal_IndexPage p = new nomal_IndexPage();
		frame.setContentPane(p);
		frame.setVisible(true);
	}
	public void moveJoinPage()
	{
		nomal_JoinPage p = new nomal_JoinPage();
		frame.setContentPane(p);
		frame.setVisible(true);
	}
	public void moveCJoinPage()
	{
		C_JoincPage p = new C_JoincPage();
		frame.setContentPane(p);
		frame.setVisible(true);
	}
	public void moveBJoinPage()
	{
		B_JoinbPage p = new B_JoinbPage();
		frame.setContentPane(p);
		frame.setVisible(true);
	}
	public void moveCinfo()
	{
		C_InfocPage in = new C_InfocPage();
		frame.setContentPane(in);
		frame.setVisible(true);
	}
	public void moveCsearch()
	{
		C_searchPage p = new C_searchPage();
		frame.setContentPane(p);
		frame.setVisible(true);
	}
	public void moveCMenu()
	{
		C_menuPage p = new C_menuPage();
		frame.setContentPane(p);
		frame.setVisible(true);
	}
	public void moveBmyroomInfo()
	{
		B_myroomInfo my = new B_myroomInfo();
		frame.setContentPane(my);
		frame.setVisible(true);
	}
	public void moveBmybookInfo()
	{
		B_mybookInfo my = new B_mybookInfo();
		frame.setContentPane(my);
		frame.setVisible(true);
	}
	public void moveBinfo()
	{
		B_InfobPage my = new B_InfobPage();
		frame.setContentPane(my);
		frame.setVisible(true);
	}
	public void moveBmenu()
	{
		B_menuPage p = new B_menuPage();
		frame.setContentPane(p);
		frame.setVisible(true);
	}
	public void moveCalendar(int num)
	{
		nomal_calendarPage p = new nomal_calendarPage(num);
		p.setVisible(true);
	}
	public void moveInputPage() {
		B_InputPage p = new B_InputPage();
		frame.setContentPane(p);
		frame.setVisible(true);
	}
	public void moveCmybookInfo()
	{
		C_mybookInfo my = new C_mybookInfo();
		frame.setContentPane(my);
		frame.setVisible(true);
	}
	//------------------------------------------------//
	public static GUI_console getInstance()
	{
		return gui_console;
	}
}
