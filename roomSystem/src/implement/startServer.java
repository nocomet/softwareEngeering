package implement;
/*
 * package implement
 * 
 * room system�� ���� ���
 * 1. startUserFile, startRoomFile  : ���� ������
 * 2. startServer.java				:���� ����
 * 3. startClient.java				: Ŭ���̾�Ʈ ����
 * 
 */
import PhysicalArchitecture.Server;

public class startServer {
	public startServer()
	{	
		Server serverstart=new Server(11144);
		serverstart.start();
	}
	
	public static void main(String[] args) {

		startServer server = new startServer();
	}
}
