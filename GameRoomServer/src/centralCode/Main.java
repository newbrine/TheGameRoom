package centralCode;

import java.io.IOException;

import javafx.application.Platform;
import network.Server;
import util.BadNews;

public class Main {

	static BadNews bad = new BadNews();
	static Server server;
	public static void main(String[] args) {
		System.out.println("Hello World!");
		server = new Server();
		listen();
	}

	private static void listen() {

		new Thread(() -> {
			System.out.println("listening");
			try {
				System.out.println("listening");
				server.listen();
			} catch (IOException e) {
				//Platform.runLater(() -> bad.badNews(e.getMessage()));
				e.printStackTrace();
			}
		}).start();
	}
}
