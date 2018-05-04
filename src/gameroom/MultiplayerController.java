package gameroom;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import networking.Client;
import networking.Server;
import profile.HighScores;
import profile.Profile;
import profile.Stats;

public class MultiplayerController {

	@FXML
	Button gameOne;

	@FXML
	Button gameTwo;

	@FXML
	Button gameThree;

	@FXML
	Button gameFour;

	@FXML
	Label nameLabel;

	@FXML
	Label ageLabel;

	@FXML
	TextArea bio;

	@FXML
	Label gamescore;
	
	@FXML
	Button leaders;

	@FXML
	ImageView profilePic;

	@FXML
	Label winLoss;

	@FXML
	Label matcherReady;

	@FXML
	Label blackHoleReady;

	@FXML
	Label brickBreakReady;

	@FXML
	Button updateButton;

	@FXML
	Tab profileTab;
	
	@FXML
	ListView<String> gamerscoreList;

	public File userFile = new File(System.getProperty("user.dir") + "//media//user.txt");
	public static Boolean multiplayer = false;
	Profile profile;
	static Parent root;
	static Stage stage;
	Client client;
	Stats stats;
	int attempt;
	Timer timer;
	HighScores highscore;
	ObservableList<String> results = FXCollections.observableArrayList();

	@FXML
	public void initialize() {
		try {
			profile = new Profile();
			client = new Client(MessageType.ONLINEPLAYER.ordinal() + " " + profile.getID());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		multiplayer = true;
		nameLabel.setText(profile.getName());
		ageLabel.setText(profile.getBirth());
		bio.setText(profile.getBio());
		profilePic.setImage(new Image(profile.getImageFile()));
		stats = new Stats();
		if (stats.hasFile()) {
			List<String> statistics = stats.loadFile();
			gamescore.setText(statistics.get(3));
			winLoss.setText(statistics.get(0) + " - " + statistics.get(1) + " - " + statistics.get(2));
		}
	}

	@FXML
	public void openGameTwo() {
		try {
			profile = new Profile();
			client = new Client(MessageType.REQUESTGAME.ordinal() + " Matcher " + profile.getID());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void openGameThree() {
		try {
			profile = new Profile();
			client = new Client(MessageType.REQUESTGAME.ordinal() + " Black_Hole " + profile.getID());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void openGameFour() {
		try {
			profile = new Profile();
			client = new Client(MessageType.REQUESTGAME.ordinal() + " Brick_Break " + profile.getID());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void gamePopup(String file, String title) {
		try {
			root = FXMLLoader.load(Main.class.getResource(file));
			stage = new Stage();
			stage.setTitle(title);
			stage.setScene(new Scene(root));
			stage.toFront();
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Parent getParent() {
		return root;
	}

	public static Stage getStage() {
		return stage;
	}

	public boolean waitForPlayerTwo() {
		return false;
	}

	public void requestProfiles() throws IOException {
		Client c = new Client(MessageType.REQUESTPROFILES.ordinal() + " " + profile.getID());
		clockStart();
	}
	
	public void requestGamerscores() throws IOException {
		Client client = new Client(MessageType.REQUESTGAMERSCORES.ordinal() + " " + profile.getID());
	}

	public void clockStart() {
		timer = new Timer();
		TimerTask countdown = new TimerTask() {
			public void run() {
				attemptUpdate();
			}
		};
		timer.schedule(countdown, 0, 1000);
	}

	public void attemptUpdate() {
		attempt = attempt + 1;
		if (attempt < 5) {
			List<String> statistics = stats.loadFile();
			Platform.runLater(()-> {
				gamescore.setText(statistics.get(3));
				winLoss.setText(statistics.get(0) + " - " + statistics.get(1) + " - " + statistics.get(2));
			});
		} else {
			attempt = 0;
			timer.cancel();
		}
	}
	
	public void setResults() {
		highscore = new HighScores();
		results = highscore.loadFile();
		gamerscoreList.setItems(results);
	}
}
