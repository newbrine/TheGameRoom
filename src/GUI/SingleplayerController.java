package GUI;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
		
	}
	
	@FXML
	public void openGameOne() throws IOException {
		File file = new File("C:\\Users\\Ryan\\Downloads\\Galalite Two\\GalaliteTwo.jar");
		Desktop.getDesktop().open(file);
	}
	
	@FXML
	public void openGameTwo() {
		
	}
	
	@FXML
	public void openGameThree() {
		
	}
	
	@FXML
	public void openGameFour() {
		
	}
}