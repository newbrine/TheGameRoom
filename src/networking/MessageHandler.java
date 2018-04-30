package networking;

import java.io.File;
import java.io.IOException;
import java.util.List;

import gameroom.MessageType;
import profile.Profile;

public class MessageHandler {
	public File userFile = new File(System.getProperty("user.dir") + "//media//user.txt");
	public MessageHandler() {}

	public void handleMessage(String message) throws IOException {
		int spaceIndex = message.indexOf(" ");
		int ord = Integer.parseInt(message.substring(0, spaceIndex));
		message = message.substring(spaceIndex + 1);
		if (ord == MessageType.IDUPDATE.ordinal()) {
			makeProfile(message);
		}
	}

	private void makeProfile(String message) throws IOException {
		Profile profile = new Profile(userFile);
		List<String> profileDetails = profile.loadFile();
		profile.updateProfile(profileDetails.get(0), profileDetails.get(1), profileDetails.get(2), profileDetails.get(3));
		profile.setID(message);
		profile.saveFile();
		System.out.println("edit profile id " + message);
	}
}
