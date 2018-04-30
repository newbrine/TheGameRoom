package gameroom;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import networking.Server;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	private static Stage pStage;

	public static Server server;
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(Main.class.getResource("MainScreen.fxml"));
			Scene scene = new Scene(root, 633, 356);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.toBack();
			setStage(primaryStage);
			server = new Server();
			listen();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args){
		launch(args);
	}

	public static Stage getStage() {
		return pStage;
	}

	public static void setStage(Stage pStage) {
		Main.pStage = pStage;
	}

	private static void listen() {
		new Thread(() -> {
			try {
				server.listen();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
}
