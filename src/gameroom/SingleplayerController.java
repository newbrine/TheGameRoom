package gameroom;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

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
	public void openGameOne() throws IOException {
		File file = new File(System.getProperty("user.dir")+"\\GalaliteTwo.jar");
		System.out.println(file.getAbsolutePath());
		Desktop.getDesktop().open(file);
	}
	
	@FXML
	public void openGameTwo() throws IOException {
		File file = new File(System.getProperty("user.dir")+"\\Matcher.jar");
		System.out.println(file.getAbsolutePath());
		Desktop.getDesktop().open(file);
	}
	
	@FXML
	public void openGameThree() throws IOException {
		File file = new File(System.getProperty("user.dir")+"\\Blackhole.jar");
		System.out.println(file.getAbsolutePath());
		Desktop.getDesktop().open(file);
	}
	
	@FXML
	public void openGameFour() {
		
	}
}