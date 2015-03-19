package Foundation;

import java.io.Serializable;
import java.util.ArrayList;

import ProblemDomain.User;
import ProblemDomain.conferenceRoom;
import ProblemDomain.personalUser;

public class roomList implements Serializable{
	private ArrayList<conferenceRoom> roomlist;
	
	public roomList() {
		roomlist = new ArrayList<conferenceRoom>();
		
	}

	public void addRoom(conferenceRoom a) {
		roomlist.add(a);
	}

	public conferenceRoom getRoom(int i) {
		return roomlist.get(i);
	}

	public int size() {
		return roomlist.size();
	}

	public void deleteRoom(int i) {
		roomlist.remove(i);
	}
	
	public int getSize()
	{
		return roomlist.size();
	}
	
}
