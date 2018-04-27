package networking;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private Socket socket;

	public Client(String hostIP, int port, String message) throws IOException {
		try {
			socket = new Socket(hostIP, port);
		} catch (UnknownHostException h) {
			System.out.println(h);
		} catch (IOException e) {
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