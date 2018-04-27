package networking;

import java.net.*;
import java.io.*;

public class WaitingForConnection extends Thread{
	ServerSocket s;
	Socket connectingSocket;

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
			new WaitingForConnection(s).start();
		} catch(IOException e) {
			e.printStackTrace();
		}}).start();
	}

	public Socket getConnectingSocket() {
		return connectingSocket;
	}
}