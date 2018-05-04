package gameroom;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BadNews {

	public BadNews() {}

	public void badNews(String message) {
		Platform.runLater(() -> alert(message));
	}
	public void alert(String what) { //from Dr. Ferrer's socketDemo
		Alert badNum = new Alert(AlertType.ERROR);
		badNum.setContentText(what);
		badNum.show();
	}
}