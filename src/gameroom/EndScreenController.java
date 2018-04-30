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

	public void initialize() {
		
	}
	
	public static String getYourScore() {
		return yourScore.getText();
	}
	
	public static String getOpponentScore() {
		return opponentScore.getText();
	}
	
	public static void setYourScore(String score) {
		yourScore.setText(score);
	}
	
	public static void setOpponentScore(String score) {
		opponentScore.setText(score);
	}
}
