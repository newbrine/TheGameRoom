package blackhole;

import java.io.File;
import java.io.IOException;

import gameroom.EndScreenController;
import gameroom.MainScreenController;
import gameroom.MultiplayerController;
import gameroom.Score;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BlackholeGameController {

	private long FRAMES_PER_SEC = 50L;
	private long INTERVAL = 10000000000L / FRAMES_PER_SEC;

	@FXML
	private Pane pane;

	@FXML
	private Circle blackcircle;

	@FXML
	private Text clickField;

	private Movement time;

	private Blackhole player;

	private int clicks = 0;

	private boolean colorChange1 = false;
	private boolean colorChange2 = false;

	private class Movement extends AnimationTimer {

		private long last = 0;
		private Blackhole player;

		public void setPlayer(Blackhole player) {
			this.player = player;
		}

		@Override
		public void handle(long now) {
			if (now - last > INTERVAL) {
				if (player.getRadius() < 450) {
					if (!colorChange1 && (player.getRadius() > 360)) {
						clickField.setFill(Color.WHITE);
						colorChange1 = true;
					} else if (!colorChange2 && (player.getRadius() > 410)) {
						clickField.setFill(Color.RED);
						colorChange2 = true;
					}
					player.enlarge();
					last = now;

				} else {
					time.stop();
					player.setRadius(500.0);
					loseAlert("YOU WERE KILLED BY THE BLACKHOLE! \n You got " + clicks + " clicks!");
					Score score = new Score(clicks);
				}
			}
		}
	}

	@FXML
	public void initialize() {
		blackcircle = new Circle(300, 300, 50);
		player = new Blackhole(5, 5, blackcircle);
		blackcircle.setOnMouseClicked(event -> {
			player.shrink();
			clicks();
		});
		pane.getChildren().add(blackcircle);
		time = new Movement();
		time.setPlayer(player);
		playSong();
		time.start();
	}

	@FXML
	private void clicks() {
		clicks++;
		clickField.setText(Integer.toString(clicks));
	}

	public void loseAlert(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(message);
		alert.setOnHidden(event -> {
			Stage stage = (Stage) pane.getScene().getWindow();
			stage.close();
			if (MultiplayerController.multiplayer) {
				try {
					Parent root = FXMLLoader.load(MainScreenController.class.getResource("EndScreen.fxml"));
					stage = new Stage();
					stage.setTitle("Black Hole Game");
					stage.setScene(new Scene(root,600,600));
					stage.toFront();
					stage.show();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Platform.runLater(() -> {
					EndScreenController.setYourScore(getClicks());
				});
			}
		});
		alert.show();
	}

	public void playSong() {
		String mp3 = System.getProperty("user.dir")+"\\media\\darkness.mp3";
		Media song = new Media(new File(mp3).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(song);
		mediaPlayer.play();
	}
	
	public String getClicks() {
		return clicks + "";
	}
	
}