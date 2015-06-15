package ProblemDomain;

import Foundation.userList;
import GUI.GUI_console;

/*
	2015 05 21 관리자 기능 클래스
	주요 기능 : 
		a. 전체회원 열람
		b. 신규회원 승인
		c. 결재 취소 승인
		d. 기존 회원 제재
		
	attribute :
		- admin의 id와 password는 한번 할당이되면 수정 불가능
		
	function :
		- getAllUserList() 전체 회원 목록을 열람하는 기능 ( 주요기능 a 관련 )
		- getWaitUserList() 승인 요청을 보낸 회원들의 목록 ( 주요기능 b 관련 )
		- doApproval() 가입대기 회원을 승인 ( 주요기능 b 관련 )
		- setApprovalToCancelSign 결재 취소 요청을 승인 ( 주요기능 c관련 )
		- doBlock() 불량회원 제재 (주요기능 d 관련 )
*/
//test용 코드 추가
public class admin implements userStateType {

	private String adminCode;//# admin 계정의  code
	private userList myUserList;
	private GUI_console gui;//# 클라이언트 측면의 기능을 수행하기 위한 singleton 객체 선언
	
	public admin()
	{		
		//adminCode= "myAdmin";
		adminCode= "1234";		
		myUserList = new userList();		
		gui=GUI_console.getInstance();//# singleton 객체 획득
	}
	public String getAdminCode()
	{
		return adminCode;
	}
	//- getAllUserList() 전체 회원 목록을 열람하는 기능 ( 주요기능 a 관련 )
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
			//user 하나하나 겟해서 상태를 확인. 로그인이 필요한 것만 temp에 담아서 리턴
			//temp.addUser(a);
		}
		return myUserList;			
	}
	public void doApproval(GUI_console gui,userList userlist, User user)//test용 코드 추가~ null 포인터시
	{		
		user.setState(userStateType.OLD);
		if(gui != null) gui.sendToSeverUserList(userlist);		
	}
	public void doBlock(GUI_console gui,userList userlist, User user)
	{
		user.setState(BAD);	//잘 못 된거 같아 수정
		if(gui != null) gui.sendToSeverUserList(userlist);
		
	}
	public void doCancelApproval(User user)
	{
		
	}
}
