package ProblemDomain;

/*
2015 05 25 ������¸� �ĺ��ϴ� interface �ۼ�
�ֿ� ��� : 
	������¸� �����ϴ� Ŭ������ implements�Ͽ� ���� ���� Ȯ��
	
	����  bookedRoomŬ������	private int state;
						final int booked=0;
						final int charged=1;
						final int blocked=2;
	�� �ٸ� Ŭ�������� ����ϱ� ���� refactoring					
	
attribute :
	- int BOOKED
	- int CHARGED
	- int BLOCKED

*/
public interface bookStateType {
	int waitCharge=1, waitCancel=2, BOOKED=3;
}
