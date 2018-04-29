package gameroom;

import java.io.File;
import java.io.IOException;

import gameroom.Main;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.*;
import networking.Client;
import networking.Server;

public class MainScreenController {
	
	@FXML
	private Button multiplayer;
	
	@FXML
	private Button singleplayer;
	
	@FXML
	private Button viewEdit;
	
	public File userFile = new File(System.getProperty("user.dir") + "//media//user.txt");
	
	@FXML
	public void initialize() {
		Server server = new Server();
		if(!userFile.exists()) {
			openProfilePopup("/profile/CreateProfile.fxml","Create Profile");
			userFile = new File(System.getProperty("user.dir") + "//media//user.txt");
		}
	}
	
	@FXML
	public void openMultiplayer() {
		changeStage("Multiplayer.fxml");
	}
	
	public void openSingleplayer() {
		changeStage("Singleplayer.fxml");
	}
	
	public void viewProfile() {
		if (userFile.exists()) {
			openProfilePopup("/profile/ViewProfile.fxml", "View/Edit Profile");
		}
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
	
	public void openProfilePopup(String file, String title) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource(file));
			Stage stage = new Stage();
			stage.setTitle(title);
			stage.setScene(new Scene(root));
			stage.toFront();
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
