package networking;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	private ServerSocket server;

	public Server(){
		try {
			server = new ServerSocket(22223);
			new WaitingForConnection(server).start();
		}catch(IOException i) {
			System.out.println(i);
		}
	}
}