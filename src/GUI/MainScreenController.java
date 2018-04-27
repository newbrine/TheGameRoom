package GUI;

import java.io.IOException;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.*;
import networking.Client;
import networking.Server;
import GUI.Main;

public class MainScreenController {
	
	@FXML
	Button multiplayer;
	
	@FXML
	Button singleplayer;
	
	@FXML
	public void initialize() {
		Server server = new Server();
		if(true) {
			openCreateProfilePopup();
		}
	}
	
	@FXML
	public void openMultiplayer() {
		changeStage("Multiplayer.fxml");
	}
	
	public void openSingleplayer() {
		changeStage("Singleplayer.fxml");
	}
	
	public void changeStage(String s) {
		try {
			Parent pane = FXMLLoader.load(getClass().getResource(s));
			Scene scene = new Scene(pane);
			Main.getStage().setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openCreateProfilePopup() {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("CreateProfile.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Create Profile");
			stage.setScene(new Scene(root));
			stage.toFront();
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
