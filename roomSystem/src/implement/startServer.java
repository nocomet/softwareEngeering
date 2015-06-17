package implement;
/*
 * package implement
 * 
 * room system의 실행 방법
 * 1. startUserFile, startRoomFile  : 파일 생성용
 * 2. startServer.java				:서버 열기
 * 3. startClient.java				: 클라이언트 실행
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
