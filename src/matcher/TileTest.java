package matcher;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import javafx.scene.image.Image;

class TileTest {

	@Test
	void testEquals() {
		Tile first = new Tile(null, 4, 5);
		Tile second = new Tile(null, 4, 6);
		Tile third = new Tile(null, 3, 5);
		assertTrue(first.equals(second));
		assertFalse(first.equals(third));
	}

}
