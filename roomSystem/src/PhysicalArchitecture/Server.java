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
// ���� ���� Ŭ����
//
public class Server extends Thread
{
	private ServerSocket server;
	private int port;
	private int clientNumber;
	
	// client���� ���� �����ϱ� ���� arrayList
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
			System.out.println("������ ��ٸ��ϴ�.");

			//����ؼ� client�� accept�ϱ� ���� ���ѷ���
			while (true) {
				// accept�� ���ÿ� client ������ �����ϱ� ���� Socket �Ҵ�
				Socket sock = server.accept();
				
				// ���� fork�� ���� EchoThread �Ҵ�
				EchoThread echothread = new EchoThread(sock, clientNumber++); 
				echothread.start(); 
				
				//���� ����� client ���� ��� 
				System.out.println("ActiveCount : " + EchoThread.activeCount);
				
				// client list�� �߰�
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
// server fork�� ���� class 
//
class EchoThread extends Thread { 
	private ArrayList<EchoThread> clientList;
	static int activeCount = 0;

	private Socket sock;
	
	// �� Ŭ���̾�Ʈ���� ������ȣ �ο��Ͽ�, �������� ���ᰡ �ƴ� �����Ͻ�  number�� list���� ���� ����
	private int clientNumber;

	//client�� server�� ������ ������ ���� object I/O Stream
	ObjectOutputStream serverOutputStream;
	ObjectInputStream in;

	// server�� ��ɵ��� ��� ���� class �Ҵ�
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
			//client �� ip������ ������ ���� �Ҵ�
			InetAddress inetaddr = sock.getInetAddress();
			
			System.out.println(inetaddr.getHostAddress() + " �κ��� �����Ͽ����ϴ�.");
			
			serverOutputStream = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			serverConsole = new ServerConsole(serverOutputStream);

			
			//client�� ������ object�� �ޱ����� �ӽ� object
			Object temp;
			String line = null;

			
			while(true)
			{
				try {
					//���� ���� ������ accept�� ���� �޸� ����ؼ� ������ ��� ���ҽ� ���� ���� ����� ���� sleep 
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				temp = in.readObject();
				
				// �о�� object�� super class�� ���� ���� �ٸ� ��� ����
				
				// string �� ��쿣 ��ɾ� �����̹Ƿ� �ٽ� handleMsg�� ���� ����
				if(temp instanceof String)
				{
					line = (String) temp;
					System.out.println("-----Ŭ���̾�Ʈ�� ���� ���۹��� ���ڿ� : " + line);
					serverConsole.handleMeg(line);
				}
				// ����� ���� class�� �´ٸ� �����ϴ� ����̹Ƿ� �ٷ� ó��
				else if(temp instanceof roomList)
				{
					roomFile file=new roomFile();
					file.fileSave((roomList)temp);
					System.out.println("------�븮��Ʈ�޾Ƽ� ������");
				}			
				else if(temp instanceof conferenceRoom)
				{
					serverConsole.handleRoom((conferenceRoom)temp);
				}
				else if(temp instanceof CbookList)
				{
					booklistFile bfile=new booklistFile();
					bfile.fileSave((CbookList)temp);
					System.out.println("-----����޾Ƽ� �ٽ� ������");
				}
				else if(temp instanceof bookedRoom)
	            {
	               serverConsole.handleBook((bookedRoom)temp);
	            }
			}

		} catch (Exception ex) {
			// ���� �߻��� client�� �������Ḧ �ǹ��ϹǷ� ���� Ŭ���̾�Ʈ �� �����ϰ�
			// ���� �޼��� ���
			// �ش� client number�� ã�� list���� ����
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


