package PhysicalArchitecture;

import java.io.IOException;
import java.io.ObjectOutputStream;

import DataManagement.booklistFile;
import DataManagement.roomFile;
import DataManagement.userFile;
import Foundation.CbookList;
import Foundation.roomList;
import Foundation.userList;
import ProblemDomain.User;
import ProblemDomain.bookedRoom;
import ProblemDomain.companyUser;
import ProblemDomain.conferenceRoom;
import ProblemDomain.personalUser;
import ProblemDomain.userStateType;
//#���� 2015 05 21 ����
//#���� 2015 05 25 ����
public class ServerConsole implements userStateType {
	private ObjectOutputStream objOutput;


	public ServerConsole(ObjectOutputStream objout)
	{
		objOutput=objout;
	}

	// client���� ���� string Ÿ�� ��ɾ ó��
	public void handleMeg(String msg)
	{
		if (msg.startsWith("#regist")) {
			//
		} else if (msg.startsWith("#login")) {
			Login(msg);
		} else if (msg.startsWith("#joinC")){
			JoinC(msg);
		} else if (msg.startsWith("#joinB")){
			JoinB(msg);
		} else if (msg.startsWith("#search")) {
			roomFile file = new roomFile();
			roomList roomlist=file.fileRead();
			Search(msg,roomlist);	
		} else if (msg.startsWith("#recommendSecond")) {
			roomFile file = new roomFile();
			roomList roomlist=file.fileRead();
			RecomendSecond(msg,roomlist);	
		} else if(msg.startsWith("#ViewList")) {
			roomFile file = new roomFile();
			roomList roomlist=file.fileRead();
			ViewList(msg,roomlist);
		} else if(msg.startsWith("#updateInfo")) {
			UpdateInfo(msg);
		} else if(msg.startsWith("#RoomList")) {
			roomFile file = new roomFile();
			roomList roomlist=file.fileRead();
			roomlist=file.fileRead();
			sendToMessageOneClientRoomlist(roomlist);
		} else if(msg.startsWith("#UserList")) {
			//# userlist ������ ������ ó��
			userFile file=new userFile();
			userList userlist=file.fileRead();			
			sendToMessageOneClientUserlist(userlist);
		}else if(msg.startsWith("#BookListWithEmail")) {
			booklistFile bfile = new booklistFile();
			CbookList booklist = bfile.fileRead();
			ViewBList(msg,booklist);
		}else if(msg.startsWith("#BookListWithOwnerEmail")){
			booklistFile bfile = new booklistFile();
			CbookList booklist = bfile.fileRead();
			ViewOwnerBList(msg, booklist);
		}else if(msg.equals("#BookList")) {
			booklistFile bfile = new booklistFile();
			CbookList booklist = bfile.fileRead();
			sendToMessageOneClientBooklist(booklist);
		} else if(msg.startsWith("#BookCancel")) {
			roomFile file = new roomFile();
			roomList roomlist=file.fileRead();
			booklistFile bfile = new booklistFile();
			CbookList booklist = bfile.fileRead();
			BookCancel(msg,roomlist,booklist);
		}
	}


	public void handleRoom(conferenceRoom room)
	{
		roomFile file = new roomFile();
		roomList roomlist=file.fileRead();
		int num=roomlist.getRoom(roomlist.size()-1).getRoomNumber();
		room.setRoomNumber(num+1);
		roomlist.addRoom(room);
		file.fileSave(roomlist);
	}
	public void handleBook(bookedRoom book)
	{
		booklistFile file = new booklistFile();
		CbookList booklist = file.fileRead();
		booklist.addBook(book);
		file.fileSave(booklist);
	}


	//----------------function---------------//
	//----------------������� ����---------------//
	//----------------function---------------//

	private void Login(String msg)
	{
		msg = msg.substring(6);
		String[] token = msg.split("%");
		User loginUser = new User(token[0], token[1],"","");

		userFile userFile = new userFile();
		userList userlist = userFile.fileRead();

		boolean empty = false;
		for (int i = 0; i < userlist.size(); i++) {
			if (loginUser.getEmail().equals(userlist.getUser(i).getEmail())) {

				if (loginUser.getPassword().equals(userlist.getUser(i).getPassword())) 
				{
					if(userlist.getUser(i).getState()==NEW)
					{
						empty = true;
						sendToClientString("���� ���� ���� ����.");
					}
					else if(userlist.getUser(i).getState()==BAD)
					{	
						empty = true;
						sendToClientString("�̿��� ������ ����� �Դϴ�.");

					}
					else{
						empty = true;
						System.out.println("-----�α��εǾ���");

						sendToClientUser(userlist.getUser(i));
					}
					break;
				} else {
					empty = true;
					sendToClientString("��й�ȣ����");
					break;
				}

			} else {
				continue;
			}
		}
		if (!empty)
			sendToClientString("�̸����� ã�� �� �����ϴ�.");
	}
	private void JoinC(String msg)
	{
		msg = msg.substring(6);
		String[] token = msg.split("%");
		personalUser joinUser = new personalUser(token[0], token[1],token[2],token[3]);

		userFile userFile = new userFile();
		userList userlist = userFile.fileRead();

		System.out.println("-----join C!!!!");
		userlist.addUser(joinUser);
		userFile.fileSave(userlist);
	}
	private void JoinB(String msg) {
		msg = msg.substring(6);
		String[] token = msg.split("%");
		companyUser joinUser = new companyUser(token[0], token[1],token[2],token[3],token[4]);

		userFile userFile = new userFile();
		userList userlist = userFile.fileRead();

		System.out.println("-----join B!!!!");
		userlist.addUser(joinUser);
		userFile.fileSave(userlist);		
	}

	private void Search(String msg, roomList roomlist)
	{
		msg = msg.substring(7);
		String[] token = msg.split("%");
		String date = token[0];
		//String address = token[1]; #������ ����
		String num;

		//#����~ �߰��� ���ڵ�
		String city = token[1];
		String district = token[2];

		if(token.length==3)
			num="�ο����þ���";
		else
			num = token[3];//#����

		boolean isDate = true;
		//boolean isAddress = true; #
		boolean isCity = true;
		boolean isDistrict = true;
		boolean isNum = true;


		if(city.equals("����"))
			isCity = false;
		if(district.equals("����"))
			isDistrict = false;
		//if (address.equals("���ü���"))			#
		//	isAddress = false;					#
		if (date.equals("2014#1#1"))
			isDate = false;
		if (num.equals("�ο����þ���"))
			isNum = false;

		roomList temp = new roomList();
		temp = SearchRoom(roomlist, city, district , date, num, isCity, isDistrict, isDate,//	#
				isNum);
		sendToMessageOneClientRoomlist(temp);
	}
	private void RecomendSecond(String msg, roomList roomlist)
	{
		msg = msg.substring(7);
		String[] token = msg.split("%");
		String date = token[0];
		//String address = token[1]; #������ ����
		String num;

		//#����~ �߰��� ���ڵ�
		String city = token[1];
		String district = token[2];

		if(token.length==3)
			num="�ο����þ���";
		else
			num = token[3];//#����

		boolean isDate = true;
		//boolean isAddress = true; #
		boolean isCity = true;
		boolean isDistrict = true;
		boolean isNum = true;


		if(city.equals("����"))
			isCity = false;
		if(district.equals("����"))
			isDistrict = false;
		//if (address.equals("���ü���"))			#
		//	isAddress = false;					#
		if (date.equals("2014#1#1"))
			isDate = false;
		if (num.equals("�ο����þ���"))
			isNum = false;

		roomList temp = new roomList();
		temp = SearchRoom(roomlist, city, district , date, num, isCity, isDistrict, isDate,//	#
				isNum);
		sendToMessageOneClientRoomlist(temp);
	}
	//�޼ҵ� ���� ����
	public roomList SearchRoom(roomList roomlist, String city, String district , String date, String num, boolean checkCity, boolean checkDistrict, boolean checkDate, boolean checkNum) {
		/*		#���� ���� ���� ���� 
		boolean checkAddress = isAddress;
		boolean checkDate = isDate;
		boolean checkNum = isNum;
		 */

		roomList temp = roomlist;
		if (checkDate) {
			String[] tok = date.split("#");
			String year = tok[0];
			String month = tok[1];
			String day = tok[2];
			temp=searchForDate(year,month,day, temp);

		}//# �޼ҵ� ���� �� �߰�
		if (checkCity & checkDistrict) {
			temp = searchForCityNDistrict(city, district, temp);
		}
		else if(checkCity & !checkDistrict){
			temp = searchForCity(city, temp);			
		}
		else if(!checkCity & checkDistrict){
			//error	
		}
		else
		{
			//������ �ȵǴ� error
		}
		//#

		if (checkNum){
			temp = searchForNum(num, temp);
		}

		return temp;
	}

	/* # ������ �޼ҵ�
	private roomList searchForAddress(String Add, roomList roomlist) {
		roomList temp = new roomList();
		for (int i = 0; i < roomlist.size(); i++) {
			if (Add.equals(roomlist.getRoom(i).getAddress())) {
				temp.addRoom(roomlist.getRoom(i));
			}
		}
		return temp;
	}
	 */
	//# �߰� �޼ҵ� searchForCityNDistrict, searchForCity
	private roomList searchForCityNDistrict(String city, String district, roomList roomlist) {
		roomList temp = new roomList();
		for (int i = 0; i < roomlist.size(); i++) {
			if (city.equals(roomlist.getRoom(i).getCity())) 
				if(district.equals(roomlist.getRoom(i).getDistrict()))
					temp.addRoom(roomlist.getRoom(i));

		}
		return temp;
	}

	private roomList searchForCity(String city, roomList roomlist) {
		roomList temp = new roomList();
		for (int i = 0; i < roomlist.size(); i++) {
			if (city.equals(roomlist.getRoom(i).getCity())) {
				temp.addRoom(roomlist.getRoom(i));
			}
		}
		return temp;
	}
	//#
	private roomList searchForDate(String y, String m, String d, roomList roomlist) {
		roomList temp = new roomList();
		int year = Integer.parseInt(y);
		int month = Integer.parseInt(m);
		int day = Integer.parseInt(d);   
		for (int i = 0; i < roomlist.size(); i++) {
			for(int j = 0; j<roomlist.getRoom(i).getcalendarListSize();j++)
			{
				if((roomlist.getRoom(i).getCalendar(j).getYear()) == year)
				{
					if((roomlist.getRoom(i).getCalendar(j).getmonth()) == month)
					{
						if(!(roomlist.getRoom(i).getCalendar(j).getbook(day-1)))
						{
							temp.addRoom(roomlist.getRoom(i));
						}
					}
				}
			}
		}
		return temp;
	}

	private roomList searchForNum(String num, roomList roomlist) {
		roomList temp = new roomList();
		for (int i = 0; i < roomlist.size(); i++) {
			if (num.equals(roomlist.getRoom(i).getAcceptPeoNum())) {
				temp.addRoom(roomlist.getRoom(i));
			}	
		}
		return temp;
	}

	private void ViewList(String msg, roomList roomlist){
		msg = msg.substring(9);
		String[] token = msg.split("%");
		String email = token[0];
		roomList temp = new roomList();
		temp = searchForOwneremail(email, roomlist);
		sendToMessageOneClientRoomlist(temp);
	}
	private void ViewBList(String msg, CbookList booklist){
		msg = msg.substring(18);
		String[] token = msg.split("%");
		String email = token[0];
		CbookList temp = new CbookList();
		temp = searchForEmail(email, booklist);
		sendToMessageOneClientBooklist(temp);
	}
	private void ViewOwnerBList(String msg, CbookList booklist){
		msg = msg.substring(23);
		String[] token = msg.split("%");
		String ownerEmail = token[0];
		CbookList temp = new CbookList();
		temp = searchForOwnerEmail(ownerEmail, booklist);
		sendToMessageOneClientBooklist(temp);
	}
	private CbookList searchForEmail(String Add, CbookList booklist) {
		CbookList temp = new CbookList();
		for (int i = 0; i < booklist.size(); i++) {
			if (Add.equals(booklist.getBook(i).getEmail())) {
				temp.addBook(booklist.getBook(i));
			}
		}
		return temp;
	}
	private roomList searchForOwneremail(String Add, roomList roomlist) {
		roomList temp = new roomList();
		for (int i = 0; i < roomlist.size(); i++) {
			if (Add.equals(roomlist.getRoom(i).getOwnerEmail())) {
				temp.addRoom(roomlist.getRoom(i));
			}
		}
		return temp;
	}
	private CbookList searchForOwnerEmail(String ownerEmail, CbookList booklist){
		CbookList temp = new CbookList();
		for(int i=0; i<booklist.size(); i++){
			if(ownerEmail.equals(booklist.getBook(i).getOwnerEmail())){
				temp.addBook(booklist.getBook(i));
			}
		}
		return temp;
	}
	private void UpdateInfo(String msg){
		msg = msg.substring(11);

		String[] token = msg.split("%");
		String email = token[0]; // email ���� �Ұ�
		String oripw = token[1];
		String pass = token[2];
		String tel = token[5];

		userFile userFile = new userFile();
		userList userlist = userFile.fileRead();

		for (int i = 0; i < userlist.size(); i++) 
		{
			if (email.equalsIgnoreCase(userlist.getUser(i).getEmail())) 
			{
				if (oripw.equals(userlist.getUser(i).getPassword())) 
				{
					userlist.getUser(i).setPassword(pass);
					userlist.getUser(i).setPhoneNumber(tel);
					sendToClientString("#update");
					userFile.fileSave(userlist);
					break;
				} else {
					sendToClientString("��й�ȣ����");
					break;
				}
			} 
			else 
			{
				continue;
			}
		}
	}

	private void BookCancel(String msg, roomList roomlist, CbookList booklist) 
	{
		msg = msg.substring(11);
		String[] token = msg.split("%");
		int roomnum = Integer.parseInt(token[0]);
		int year = Integer.parseInt(token[1]);
		int month = Integer.parseInt(token[2]);
		int day = Integer.parseInt(token[3]);
		booklistFile Bfile = new booklistFile();
		roomFile Rfile = new roomFile();
		//�����ȣ,�����,���ȣ
		for(int i=0;i<booklist.getSize();i++)
		{
			if(booklist.getBook(i).getroomNum() == roomnum && booklist.getBook(i).getyear()==year)
			{
				if(booklist.getBook(i).getmonth() == month && booklist.getBook(i).getday()==day)//���ฮ��Ʈ���� ����
				{
					booklist.deleteBook(i);
					break;
				}
			}
		}
		for(int i=0;i<roomlist.getSize();i++)
		{
			if(roomlist.getRoom(i).getRoomNumber() == roomnum)
				roomlist.getRoom(i).cancelSchedule(year, month, day);
		}
		Rfile.fileSave(roomlist);
		Bfile.fileSave(booklist);
	}


	//------------------send---------------//
	//---------------client���� ����-----------//
	//------------------send---------------//


	private void sendToClientUser(User user)
	{
		try {
			objOutput.writeObject(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void sendToClientString(String line) {
		try {
			objOutput.writeObject(line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void sendToMessageOneClientRoomlist(roomList roomlist) {
		try {
			objOutput.writeObject(roomlist);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void sendToMessageOneClientBooklist(CbookList booklist) {
		try {
			objOutput.writeObject(booklist);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void sendToMessageOneClientUserlist(userList userlist) {
		try {
			objOutput.writeObject(userlist);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}