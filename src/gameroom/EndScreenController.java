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
	
	@FXML
	public Label winLoss;
	
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
	
	public static void setWinLoss(String yourScore, String opponentScore) {
		if (Integer.parseInt(yourScore) > Integer.parseInt(opponentScore)) {
			lastCreated.winLoss.setText("You Win!");
		} else if (Integer.parseInt(yourScore) < Integer.parseInt(opponentScore)) {
			lastCreated.winLoss.setText("You Lose!");
		} else {
			lastCreated.winLoss.setText("You Tied!");
		}
	}
}
