package networking;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;

import gameroom.BadNews;
import gameroom.EndScreenController;
import gameroom.MainScreenController;
import gameroom.MessageType;
import gameroom.MultiplayerController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import profile.HighScores;
import profile.Profile;
import profile.Stats;

public class MessageHandler {
	Profile profile;
	BadNews badNews = new BadNews();
	Stats stats;
	HighScores highscores;
	public MessageHandler() {
		
	}

	public void handleMessage(String message) throws IOException {
		int spaceIndex = message.indexOf(" ");
		int ord = Integer.parseInt(message.substring(0, spaceIndex));
		message = message.substring(spaceIndex + 1);
		if (ord == MessageType.IDUPDATE.ordinal()) {
			makeProfile(message);
		} else if(ord == MessageType.GAMEFOUND.ordinal()) {
			startGame(message);
		} else if(ord == MessageType.SENDSCORE.ordinal()) {
			getOpponentsScore(message);
		} else if(ord == MessageType.REQUESTPROFILES.ordinal()) {
			String[] messageSplit = message.split(" ");
			stats = new Stats(messageSplit[1], messageSplit[2], messageSplit[3], messageSplit[4]);
		} else if(ord == MessageType.REQUESTGAMERSCORES.ordinal()) {
			System.out.println(message);
			String[] gs = message.split(" ");
			List<String> gamerscores = Arrays.asList(gs);
			HighScores highscores = new HighScores(gamerscores);
			
		}
	}

	private void makeProfile(String message) throws IOException {
		try {
			profile = new Profile();
		} catch (IOException e) {
			badNews.badNews(e.getMessage());
			e.printStackTrace();
		}
		profile.setID(message);
		profile.saveFile();
	}
	
	private void startGame(String message) throws IOException {
		Platform.runLater(() -> {
			if(message.equals("Galalite_2")) {
				MultiplayerController.gamePopup("/galalite/StartScreen.fxml", "Galalite 2");
			} else if(message.equals("Matcher")) {
				MultiplayerController.gamePopup("/matcher/MatchingGameGUI.fxml", "Matcher");
			} else if(message.equals("Black_Hole")) {
				MultiplayerController.gamePopup("/blackhole/BlackholeGameGUI.fxml", "Blackhole");
			} else {
				MultiplayerController.gamePopup("/brickbreaker/BrickBreak.fxml", "Brick Break");
			}
		});
	}
	
	private void getOpponentsScore(String message) {
		String[] scores = message.split(" ");
		Platform.runLater(() -> {
			if (MultiplayerController.multiplayer) {
				Parent root;
				try {
					root = FXMLLoader.load(MainScreenController.class.getResource("EndScreen.fxml"));
					Stage stage = new Stage();
					stage.setTitle("Matcher");
					stage.setScene(new Scene(root));
					stage.toFront();
					stage.show();
					EndScreenController.setYourScore(scores[1]);
					EndScreenController.setOpponentScore(scores[0]);
					EndScreenController.setWinLoss(scores[1], scores[0]);
				} catch (IOException e) {
					badNews.badNews(e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}
}