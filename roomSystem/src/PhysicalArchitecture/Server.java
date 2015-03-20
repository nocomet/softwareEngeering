package PhysicalArchitecture;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import DataManagement.booklistFile;
import DataManagement.roomFile;
import Foundation.CbookList;
import Foundation.roomList;
import ProblemDomain.bookedRoom;
import ProblemDomain.conferenceRoom;

// 
// 서버 구현 클래스
//
public class Server extends Thread
{
	private ServerSocket server;
	private int port;
	private int clientNumber;
	
	// client들을 각각 관리하기 위한 arrayList
	private static ArrayList<EchoThread> clientList;

	public Server(int port) {
		clientList = new ArrayList<EchoThread>();
		this.port = port;
		clientNumber = 0;
	}

	public void run() {
		try {
			// server start... 
			server = new ServerSocket(port);
			System.out.println("접속을 기다립니다.");

			//계속해서 client를 accept하기 위해 무한루프
			while (true) {
				// accept와 동시에 client 정보를 관리하기 위해 Socket 할당
				Socket sock = server.accept();
				
				// 서버 fork를 위한 EchoThread 할당
				EchoThread echothread = new EchoThread(sock, clientNumber++); 
				echothread.start(); 
				
				//현재 연결된 client 갯수 출력 
				System.out.println("ActiveCount : " + EchoThread.activeCount);
				
				// client list에 추가
				clientList.add(echothread);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static ArrayList<EchoThread> getEchoThreadList() {
		return clientList;
	}

}


//
// server fork를 위한 class 
//
class EchoThread extends Thread { 
	private ArrayList<EchoThread> clientList;
	static int activeCount = 0;

	private Socket sock;
	
	// 각 클라이언트마다 고유번호 부여하여, 정상적인 종료가 아닌 종료일시  number로 list에서 제거 가능
	private int clientNumber;

	//client와 server간 데이터 전송을 위한 object I/O Stream
	ObjectOutputStream serverOutputStream;
	ObjectInputStream in;

	// server의 기능들을 담아 놓은 class 할당
	private ServerConsole serverConsole; 


	public EchoThread(Socket sock, int clientNumber) {
		this.sock = sock;
		activeCount++; 
		this.clientNumber = clientNumber;
	} 

	public int getClientNumber() {
		return clientNumber;
	}

	public ObjectOutputStream getOutput() {
		return serverOutputStream;
	}

	public void run() { 
		try { 
			//client 의 ip정보를 얻어오기 위해 할당
			InetAddress inetaddr = sock.getInetAddress();
			
			System.out.println(inetaddr.getHostAddress() + " 로부터 접속하였습니다.");
			
			serverOutputStream = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			serverConsole = new ServerConsole(serverOutputStream);

			
			//client가 보내온 object를 받기위한 임시 object
			Object temp;
			String line = null;

			
			while(true)
			{
				try {
					//위의 무한 루프의 accept의 대기와 달리 계속해서 수행할 경우 리소스 낭비가 심할 우려로 인해 sleep 
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				temp = in.readObject();
				
				// 읽어온 object의 super class에 따라 각자 다른 결과 수행
				
				// string 일 경우엔 명령어 단위이므로 다시 handleMsg를 통해 관리
				if(temp instanceof String)
				{
					line = (String) temp;
					System.out.println("-----클라이언트로 부터 전송받은 문자열 : " + line);
					serverConsole.handleMeg(line);
				}
				// 사용자 정의 class가 온다면 저장하는 경우이므로 바로 처리
				else if(temp instanceof roomList)
				{
					roomFile file=new roomFile();
					file.fileSave((roomList)temp);
					System.out.println("------룸리스트받아서 저장함");
				}			
				else if(temp instanceof conferenceRoom)
				{
					serverConsole.handleRoom((conferenceRoom)temp);
				}
				else if(temp instanceof CbookList)
				{
					booklistFile bfile=new booklistFile();
					bfile.fileSave((CbookList)temp);
					System.out.println("-----예약받아서 다시 저장함");
				}
				else if(temp instanceof bookedRoom)
	            {
	               serverConsole.handleBook((bookedRoom)temp);
	            }
			}

		} catch (Exception ex) {
			// 에러 발생시 client와 접속종료를 의미하므로 현재 클라이언트 수 감소하고
			// 에러 메세지 출력
			// 해당 client number를 찾아 list에서 제거
			activeCount--;
			System.out.println(ex);
			clientList = Server.getEchoThreadList();
			for (int i = 0; i < clientList.size(); i++)
			{
				if (clientNumber == clientList.get(i).getClientNumber())
					clientList.remove(i);
			}
		}
	}


}


