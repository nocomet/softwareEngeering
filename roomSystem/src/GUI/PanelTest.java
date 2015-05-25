package GUI;

import javax.swing.JPanel;

import Foundation.userList;
import ProblemDomain.User;

public class PanelTest {
	public JPanel panel;
	public userList user;
	public int index;
	
	public PanelTest(JPanel p, userList list, int i)
	{
		panel=p;
		user=list;
		index=i;
	}
}
