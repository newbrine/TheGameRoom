package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BadNews {

	public BadNews () {};

	public void badNews(String what) { // Dr. Ferrer 352 sockDemo
		Alert badNum = new Alert(AlertType.ERROR);
		badNum.setContentText(what);
		badNum.show();
	}
}
