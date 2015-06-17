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

		//GUI의 총 관리하는 FramePage class 할당	
		nomal_FramePage frame = new nomal_FramePage();
		
		//GUI에 해당하는 각 기능을 가진 class 할당
		gui=GUI_console.getInstance();
		gui.setClient(client);
		gui.setFrame(frame);		
	}
	public static void main(String[] args)
	{
		startClient start = new  startClient();	
	}
}
	