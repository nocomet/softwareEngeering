package ProblemDomain;

import Foundation.userList;
import GUI.GUI_console;

/*
	2015 05 21 ������ ��� Ŭ����
	�ֿ� ��� : 
		a. ��üȸ�� ����
		b. �ű�ȸ�� ����
		c. ���� ��� ����
		d. ���� ȸ�� ����
		
	attribute :
		- admin�� id�� password�� �ѹ� �Ҵ��̵Ǹ� ���� �Ұ���
		
	function :
		- getAllUserList() ��ü ȸ�� ����� �����ϴ� ��� ( �ֿ��� a ���� )
		- getWaitUserList() ���� ��û�� ���� ȸ������ ��� ( �ֿ��� b ���� )
		- doApproval() ���Դ�� ȸ���� ���� ( �ֿ��� b ���� )
		- setApprovalToCancelSign ���� ��� ��û�� ���� ( �ֿ��� c���� )
		- doBlock() �ҷ�ȸ�� ���� (�ֿ��� d ���� )
*/

public class admin {

	private String adminCode;//# admin ������  code
	private userList myUserList;
	private GUI_console gui;//# Ŭ���̾�Ʈ ������ ����� �����ϱ� ���� singleton ��ü ����
	
	public admin()
	{		
		//adminCode= "myAdmin";
		adminCode= "1234";		
		myUserList = new userList();		
		gui=GUI_console.getInstance();//# singleton ��ü ȹ��
	}
	public String getAdminCode()
	{
		return adminCode;
	}
	//- getAllUserList() ��ü ȸ�� ����� �����ϴ� ��� ( �ֿ��� a ���� )
	public userList getAllUserList()
	{
		gui.getUserListFromServer();
		myUserList = gui.getUserListResponse();
		
		return myUserList;
	}
	public userList getWaitUserList()
	{
		myUserList = getAllUserList();
		userList temp = new userList();
		
		for(int i = 0 ; i < myUserList.size(); i ++)
		{
			//user �ϳ��ϳ� ���ؼ� ���¸� Ȯ��. �α����� �ʿ��� �͸� temp�� ��Ƽ� ����
			//temp.addUser(a);
		}
		return myUserList;			
	}
	public void doApproval(User user)
	{
		// ������ ���� ������ userlist���� ã�Ƽ� set���� �ؼ� �ٲ۴㿡
		// ������ ������ �����ϵ��� �ؾ���
		
		// ������ userlist������ �����ϴ� ��� �����ؾ���
	}
	public void doBlock(User user)
	{

		// ������ ���� ������ userlist���� ã�Ƽ� set���� �ؼ� �ٲ۴㿡
		// ������ ������ �����ϵ��� �ؾ���
		
		// ������ userlist������ �����ϴ� ��� �����ؾ���
	}
}
