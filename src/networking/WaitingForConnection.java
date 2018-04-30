package networking;

import java.net.*;
import java.io.*;

public class WaitingForConnection extends Thread{
	ServerSocket s;
	Socket connectingSocket;
	Boolean waiting;

	public WaitingForConnection(ServerSocket s) {
		this.s = s;
	}

	@Override
	public void start() {
		run();
	}

	@Override
	public void run() {
		new Thread(() -> {try {
			connectingSocket = s.accept();
			newMessage(connectingSocket);
			new WaitingForConnection(s).start();
		} catch(IOException e) {
			e.printStackTrace();
		}}).start();
	}
	
	public void newMessage(Socket s) {
		try {
			BufferedReader responses = new BufferedReader(new InputStreamReader(connectingSocket.getInputStream()));
			StringBuilder sb = new StringBuilder();
			while(!responses.ready()) {}
			while(responses.ready()) {
				sb.append(responses.read());
			}
			MessageHandler handler = new MessageHandler();
			handler.handleMessage(sb.toString());
			connectingSocket.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public Socket getConnectingSocket() {
		return connectingSocket;
	}
}