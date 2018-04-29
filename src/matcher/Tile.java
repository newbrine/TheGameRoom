package matcher;

import javafx.scene.image.Image;

public class Tile {
	
	public Image image;
	public int image_num;
	public int tile_num;
	
	public Tile(Image i, int in, int tn) {
		image = i;
		image_num = in;
		tile_num = tn;
	}
	
	public void setImage(Image img) {
		image = img;
	}
	
	public void setImageNum(int in) {
		image_num = in;
	}
	
	public int getTileNum() {
		return tile_num;
	}
	
	public void setTileNum(int tn) {
		tile_num = tn;
	}
	
	public Image getImage() {
		return image;
	}
	
	public int getImageNum() {
		return image_num;
	}
	
	public boolean equals(Tile other) {
		if(other.getImageNum() == this.getImageNum()) {
			return true;
		}
		return false;
	}

}
