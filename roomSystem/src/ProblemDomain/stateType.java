package ProblemDomain;


/*
	2015 05 22 회원상태를 식별하는 interface 작성
	주요 기능 : 
		회원의 상태를 열람하는 클래스에 implements하여 회원의 상태 확인
		
	attribute :
		- int NEW
		- int OLD
		- int BAD
	
*/
public interface stateType {
	int NEW=1, OLD=2, BAD=3;
	
}
