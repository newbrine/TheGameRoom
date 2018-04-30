package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import gameroom.BadNews;

public class Server {

	private final int portNum = 8888;
	private MessageHandler thingDoer = new MessageHandler();
	private ServerSocket server;
	private BadNews bad;

	public Server() {
		bad = new BadNews();
		try {
			server = new ServerSocket(portNum);
		} catch (IOException e) {
			bad.badNews(e.getMessage());
			e.printStackTrace();
		}
	}

	public void listen() throws IOException {
		try {
			while (true) {
				System.out.println("working on it " + server);
				Socket s = server.accept();
				newClient(s);
			}
		} catch (Exception e) {
			bad.badNews(e.getMessage());
			e.printStackTrace();
		}
	}

	private void newClient(Socket s) throws IOException { // Dr. Ferrer sockDemo
		try {
			BufferedReader responses = new BufferedReader(new InputStreamReader(s.getInputStream()));
			StringBuilder sb = new StringBuilder();
			while (!responses.ready()) {
			}
			while (responses.ready()) {
				sb.append(responses.readLine());
			}
			System.out.println(sb.toString());
			thingDoer.handleMessage(sb.toString());
			s.close();

		} catch (Exception e) {
			bad.badNews(e.getMessage());
			e.printStackTrace();
		}
	}
}