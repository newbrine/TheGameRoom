package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	private static Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/BrickBreak.fxml"));
		System.out.println("try2");
		this.scene = new Scene(root, 500, 500, Color.BLACK);
		System.out.println(scene);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static Scene getScene() {
		return scene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
