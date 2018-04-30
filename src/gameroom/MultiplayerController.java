package gameroom;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import networking.Client;
import networking.Server;
import profile.Profile;

public class MultiplayerController {

	@FXML
	Button gameOne;
	
	@FXML
	Button gameTwo;
	
	@FXML
	Button gameThree;
	
	@FXML
	Button gameFour;
	
	@FXML
	Label nameLabel;
	
	@FXML
	Label ageLabel;
	public File userFile = new File(System.getProperty("user.dir") + "//media//user.txt");
	public static Boolean multiplayer = false;
	Profile profile;
	static Parent root;
	static Stage stage;
	Client client;
	
	@FXML
	public void initialize() {
		try {
			profile = new Profile();
			client = new Client(MessageType.ONLINEPLAYER.ordinal() + " " + profile.getID());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		multiplayer = true;
		profile = new Profile(new File("user.txt"));
		Platform.runLater(() -> {
			nameLabel.setText(profile.getName());
			ageLabel.setText(profile.getBirth());
		});
	}
	
	@FXML
	public void launchGameOne() {
		try {
			profile = new Profile();
			client = new Client(MessageType.REQUESTGAME.ordinal() + " Galalite_2 " + profile.getID());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void openGameTwo() {
		try {
			profile = new Profile();
			client = new Client(MessageType.REQUESTGAME.ordinal() + " Matcher " + profile.getID());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@FXML
	public void openGameThree() {
		try {
			profile = new Profile();
			client = new Client(MessageType.REQUESTGAME.ordinal() + " Black_Hole " + profile.getID());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void openGameFour() {
		try {
			profile = new Profile();
			client = new Client(MessageType.REQUESTGAME.ordinal() + " Brick_Break " + profile.getID());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void gamePopup(String file, String title) {
		try {
			root = FXMLLoader.load(Main.class.getResource(file));
			stage = new Stage();
			stage.setTitle(title);
			stage.setScene(new Scene(root));
			stage.toFront();
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Parent getParent() {
		return root;
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public boolean waitForPlayerTwo() {
		
		return false;
	}
}
