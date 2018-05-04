package networking;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import gameroom.BadNews;

public class Client {

	private Socket socket;

	private final String serverIP = "10.253.202.133";
	private final int portNumber  = 8888;
	private BadNews badNews = new BadNews();

	public Client(String message) throws IOException {

		try {
			socket = new Socket(serverIP, portNumber);
		} catch (UnknownHostException h) {
			badNews.badNews(h.getMessage());
			System.out.println(h);
		} catch (IOException e) {
			badNews.badNews(e.getMessage());
			System.out.println(e);
		}
		byte[] bytes = message.getBytes();
		OutputStream os = socket.getOutputStream();
		os.write(bytes);
		os.flush();
		os.close();
		socket.close();
	}
}