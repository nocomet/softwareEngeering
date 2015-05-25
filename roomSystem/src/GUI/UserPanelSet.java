package GUI;

import javax.swing.JPanel;

import Foundation.userList;
import ProblemDomain.User;

public class UserPanelSet {
	public JPanel panel;
	public userList user;
	public int index;
	
	public UserPanelSet(JPanel p, userList list, int i)
	{
		panel=p;
		user=list;
		index=i;
	}
}
