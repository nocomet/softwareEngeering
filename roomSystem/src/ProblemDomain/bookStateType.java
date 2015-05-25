package ProblemDomain;

/*
2015 05 25 예약상태를 식별하는 interface 작성
주요 기능 : 
	예약상태를 열람하는 클래스에 implements하여 예약 상태 확인
	
	기존  bookedRoom클래스의	private int state;
						final int booked=0;
						final int charged=1;
						final int blocked=2;
	를 다른 클래스에도 사용하기 위해 refactoring					
	
attribute :
	- int BOOKED
	- int CHARGED
	- int BLOCKED

*/
public interface bookStateType {
	int waitCharge=1, waitCancel=2, BOOKED=3;
}
