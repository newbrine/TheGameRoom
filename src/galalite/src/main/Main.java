package galalite.src.main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	private static Stage primaryStage;
	private static Scene primaryScene;


	public static Stage getStage() {
		return primaryStage;
	}

	public static Scene getScene() {
		return primaryScene;
	}


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("can edit");
		this.primaryStage = primaryStage;

		Parent root = FXMLLoader.load(getClass().getResource("galalite/src/main/StartScreen.fxml"));
		this.primaryScene = new Scene(root,1200,800);

		primaryStage.setTitle("Galalite2");
        primaryStage.setScene(primaryScene);
        primaryStage.show();


	}
}