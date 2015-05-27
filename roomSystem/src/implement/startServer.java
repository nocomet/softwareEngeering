
package implement;

import PhysicalArchitecture.Server;

public class startServer {
	public startServer()
	{	
		Server serverstart=new Server(11134);
		serverstart.start();
	}
	
	public static void main(String[] args) {

		startServer server = new startServer();
	}
}
