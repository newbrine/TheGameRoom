package gameroom;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class EndScreenController{
	
	@FXML
	public Label yourScore;
	
	@FXML
	public Label opponentScore;
	
	private static EndScreenController lastCreated;

	public void initialize() {
		lastCreated = this;
	}
	
	public static String getYourScore() {
		return lastCreated.yourScore.getText();
	}
	
	public static String getOpponentScore() {
		return lastCreated.opponentScore.getText();
	}
	
	public static void setYourScore(String score) {
		lastCreated.yourScore.setText(score);
	}
	
	public static void setOpponentScore(String score) {
		lastCreated.opponentScore.setText(score);
	}
}
