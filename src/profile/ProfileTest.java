package profile;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class ProfileTest {

	@Test
	void testCreateProfile() {
		Profile profile = new Profile("Name", "Birthday", "Bio", "../../media/boom.jpg");
		assertEquals(profile.getName(), "Name");
		assertEquals(profile.getBio(), "Bio");
		assertEquals(profile.getBirth(), "Birthday");
		assertEquals(profile.getImageFile(), "../../media/boom.jpg");
	}
	
	@Test
	void testSaveFile() {
		Profile profile = new Profile("Name", "Birthday", "Bio", "../../media/boom.jpg");
		try {
			profile.saveFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> newFile = profile.loadFile();
		assertEquals(newFile.get(0), "Name");
		assertEquals(newFile.get(1), "Birthday");
		assertEquals(newFile.get(2), "Bio");
		assertEquals(newFile.get(3), "../../media/boom.jpg");
	}
	
	@Test
	void testUpdateFile() {
		Profile profile = new Profile("Name", "Birthday", "Bio", "../../media/boom.jpg");
		profile.updateProfile("John", "11/26/1997", "Stop", "../../media/tile_1.jpg");
		assertEquals(profile.getName(), "John");
		assertEquals(profile.getBio(), "Stop");
		assertEquals(profile.getBirth(), "11/26/1997");
		assertEquals(profile.getImageFile(), "../../media/tile_1.jpg");
	}
}
