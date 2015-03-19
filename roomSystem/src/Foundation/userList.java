package Foundation;

import java.io.Serializable;
import java.util.ArrayList;

import ProblemDomain.User;

public class userList implements Serializable{
	private ArrayList<User> userList;

	public userList() {
		userList = new ArrayList<User>();
	}

	public void addUser(User a) {
		userList.add(a);
	}

	public User getUser(int i) {
		return userList.get(i);
	}

	public int size() {
		return userList.size();
	}

	public void deleteUser(int i) {
		if (userList.size() > 0)
			userList.remove(i);
		else
			System.out.println("삭제가 불가능 합니다.");
	}
}
