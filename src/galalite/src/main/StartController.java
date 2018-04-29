package galalite.src.main;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import galalite.src.core.Database;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import galalite.src.ships.PlayerShip;
import gameroom.Main;

import javax.swing.*;

import com.sun.prism.paint.Color;

import java.beans.EventHandler;
import java.io.IOException;
import java.util.ArrayList;


public class StartController {

	private State state = State.START;


	Parent pane;

	private Stage stage;

	@FXML
	private Pane gamePane;

	@FXML
	private Button start, load, save;
	
	@FXML
	private Label mainTitle, score, lives, currentHighscore;
	
	@FXML
	private ListView<String> highscoreList;

	@FXML
	private Button resume;



	@FXML
	private AnchorPane startScreen;



	@FXML
	private AnchorPane canvas;



	static Database db = new Database();


	public void initialize() {
		stage = Main.getStage();
		highscoreList.setItems(db.getAllHighscores());
	}

	@FXML
	private void toMainScreen() {
		changeScene("/galalite/src/main/MainScreen.fxml");
	}

	@FXML
	private void load() {
		ArrayList<String> list = db.getSaveNames();
		Object[] options = new Object[list.size()];
		System.out.println(list);
		for(int i=0; i<list.size(); i++) {

			options[i] = list.get(i);
			System.out.println("here...");
		}
		System.out.println(options[0]);

		SwingUtilities.invokeLater(() -> {String s = (String) JOptionPane.showInputDialog(
		                    null,
		                   "Choose your saved game",
		                    "Customized Dialog",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    options,
		                    null);
		System.out.println(s);
		if (s != null) {
			System.out.println("hi");
			loadGameState(s);
		}});
	}





	private void loadGameState(String s) {
		db.setActiveLoad(s);

		toMainScreen();
	}



	private void changeScene(String fxml) {
		try {
			Parent pane = FXMLLoader.load(getClass().getResource(fxml));
			Scene scene = new Scene(pane);
			Main.getStage().setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
