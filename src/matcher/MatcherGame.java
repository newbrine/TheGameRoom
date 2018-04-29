package matcher;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import matcher.Tile;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class MatcherGame {

	public int size;
	public List<Image> images = new ArrayList<Image>();
	public List<Tile> tiles = new ArrayList<Tile>();

	public Tile selected1;
	public Tile selected2;

	public Image defaultImage;
	
	public boolean turnBegan = false;
	
	public Long time;

	public MatcherGame(int listSize) {
		size = listSize;
	}

	public void initialize() {
		setupImages();
		setupTiles();
	}

	public void setupImages() {
		File defaultFile = new File(System.getProperty("user.dir") + "//media//m logo.PNG");
		defaultImage = new Image("file:\\" + defaultFile.getAbsolutePath());
		for (int i = 0; i < 8; i++) {
			File file = new File(System.getProperty("user.dir") + "//media//tile_" + Integer.toString(i + 1) + ".jpg");
			Image image = new Image("file:\\" + file.getAbsolutePath());
			images.add(image);
		}
	}

	public void setupTiles() {
		for (int i = 0; i < size; i++) {
			if (i < 8) {
				Tile tile = new Tile(images.get(i), i, i);
				tiles.add(tile);
			} else {
				Tile tile = new Tile(images.get(i-8), i-8, i);
				tiles.add(tile);
			}
		}
		Collections.shuffle(tiles);
	}
	
	public List<Tile> getTiles(){
		return tiles;
	}
	
	public void setSelected1(Tile a) {
		selected1 = a;
	}
	
	public void setSelected2(Tile b) {
		selected2 = b;
	}
	
	public Tile getSelected1() {
		return selected1;
	}
	
	public Tile getSelected2() {
		return selected2;
	}
	
	public void turnChange() {
		if(turnBegan == false) {
			turnBegan = true;
		} else {
			turnBegan = false;
		}
	}
	
	public boolean getTurnBegan() {
		return turnBegan;
	}

}
