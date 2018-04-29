package gameroom;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

public class SingleplayerController {

	@FXML
	Button gameOne;
	
	@FXML
	Button gameTwo;
	
	@FXML
	Button gameThree;
	
	@FXML
	Button gameFour;
	
	@FXML
	public void initialize() {
		File file = new File(System.getProperty("user.dir")+"\\media\\galalite.PNG");
		Image image = new Image("file:///"+file.getAbsolutePath());
		gameOne.setTextFill(new ImagePattern(image));
	}
	
	@FXML
	public void openGalalite() throws IOException{
		gamePopup("/galalite/src/main/StartScreen.fxml", "Galalite Two");
	}
	
	@FXML
	public void openGameTwo() throws IOException {
		gamePopup("/matcher/MatchingGameGUI.fxml", "Matcher");
		
	}
	
	@FXML
	public void openGameThree() throws IOException {
		gamePopup("/blackhole/BlackholeGameGUI.fxml", "Blackhole");
	}
	
	@FXML
	public void openGameFour() {
		
	}
	
	public void gamePopup(String file, String title) {
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