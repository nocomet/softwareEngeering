package implement;

import GUI.GUI_console;
import GUI.nomal_FramePage;
import GUI.nomal_IndexPage;
import PhysicalArchitecture.Client;

public class startClient {
	private Client client;
	private GUI_console gui;
	
	
	public startClient()
	{
		client=new Client("127.0.0.1", 11144);

		//GUI�� �� �����ϴ� FramePage class �Ҵ�	
		nomal_FramePage frame = new nomal_FramePage();
		
		//GUI�� �ش��ϴ� �� ����� ���� class �Ҵ�
		gui=GUI_console.getInstance();
		gui.setClient(client);
		gui.setFrame(frame);		
	}
	public static void main(String[] args)
	{
		startClient start = new  startClient();	
	}
}
	