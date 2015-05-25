package GUI;

import javax.swing.JPanel;

import Foundation.CbookList;
import Foundation.userList;

public class BookPanelSet {
	public JPanel panel;
	public CbookList booklist;
	public int index;
	
	public BookPanelSet(JPanel p, CbookList list, int i)
	{
		panel=p;
		booklist=list;
		index=i;
	}
}