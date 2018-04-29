package matcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import matcher.MatcherGame;
import matcher.Tile;
import gameroom.Score;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MatcherController {

	@FXML
	private Rectangle tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9, tile10, tile11, tile12, tile13,
			tile14, tile15, tile16;

	@FXML
	private AnchorPane sidepane;

	@FXML
	private Text matches, matchesLabel, time, timeLabel;

	@FXML
	private GridPane grid;

	public List<Rectangle> tileRectangles = new ArrayList<Rectangle>();
	public List<Tile> tiles;
	public List<String> idList = new ArrayList<String>();

	public MatcherGame game;

	public int match = 0;
	public int seconds = 20;

	public Image defaultImage;

	@FXML
	public void initialize() {
		setupRectangles();
		setupDefaultImage();
		setupGame();
		clockStart();
	}
	
	public void setupGame() {
		game = new MatcherGame(tileRectangles.size());
		game.initialize();
		tiles = game.getTiles();
	}
	public void setupDefaultImage() {
		File defaultFile = new File(System.getProperty("user.dir") + "//media//m logo.PNG");
		defaultImage = new Image("file:\\" + defaultFile.getAbsolutePath());
	}

	public void setupRectangles() {
		File file = new File(System.getProperty("user.dir") + "//media//m logo.PNG");
		Image image = new Image("file:\\" + file.getAbsolutePath());
		for (Node node : grid.getChildren()) {
			if (node instanceof Rectangle) {
				((Rectangle) node).setFill(new ImagePattern(image));
				tileRectangles.add((Rectangle) node);
				((Rectangle) node).setOnMouseClicked(e -> {
					game.turnChange();
					changePicture((Rectangle) node);
				});
			}
		}
	}
	
	public void clockStart() {
		Timer timer = new Timer();
		TimerTask countdown = new TimerTask() {
			public void run() {
				displayCountdown(timer);
			}
		};
		timer.schedule(countdown, 0, 1000);
	}
	
	public void displayCountdown(Timer timer) {
		seconds = seconds - 1;
		if (seconds > 9) {
			time.setText("00:" + seconds);
		} else {
			time.setText("00:0" + seconds);
		}
		if (seconds == 0) {
			timer.cancel();
			Platform.runLater(() -> {
				Score score = new Score(Integer.parseInt(matches.getText()));
				disableGame();
				loseAlert("You got " + matches.getText() + " matches!");
			});
		}
	}
	
	public void disableGame() {
		for (Node node : grid.getChildren()) {
			node.setDisable(true);
		}
	}

	public void changePicture(Rectangle selected) {
		selected.setDisable(true);
		resetCheck();
		idList.add(selected.getId());
		String num = selected.getId().replaceAll("tile", "");
		int id = Integer.parseInt(num)-1;
		Image image = tiles.get(id).getImage();
		selected.setFill(new ImagePattern(image));
		if (game.getTurnBegan()) {
			game.setSelected1(tiles.get(id));
		} else {
			comapreTiles(id, selected);
		}
	}
	
	public void resetCheck() {
		if (idList.size() == 2) {
			resetTiles(idList);
			idList = new ArrayList<String>();
		}
	}

	public void comapreTiles(int i, Rectangle selected) {
		game.setSelected2(tiles.get(i));
		if (game.getSelected1().equals(game.getSelected2())) {
			match++;
			matches.setText(Integer.toString(match));
			for (Node node : grid.getChildren()) {
				if (node instanceof Rectangle) {
					if (idList.contains(node.getId())) {
						((Rectangle) node).setFill(javafx.scene.paint.Color.GREEN);
						((Rectangle) node).setDisable(true);
					}
				}
			}
			idList = new ArrayList<String>();
		}
	}

	public void resetTiles(List<String> idList) {
		for (Node node : grid.getChildren()) {
			if (node instanceof Rectangle) {
				if (idList.contains(((Rectangle) node).getId())) {
					((Rectangle) node).setFill(new ImagePattern(defaultImage));
					((Rectangle) node).setDisable(false);
				}
			}
		}
	}

	public void loseAlert(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(message);
		alert.setOnHidden(event -> {
			Stage stage = (Stage) grid.getScene().getWindow();
			stage.close();
		});
		alert.show();
	}

}
