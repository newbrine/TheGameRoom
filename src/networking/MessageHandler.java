package networking;

import java.io.File;
import java.io.IOException;
import java.util.List;
import gameroom.MessageType;
import gameroom.MultiplayerController;
import profile.Profile;

public class MessageHandler {
	Profile profile;
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
		}
	}

	private void makeProfile(String message) throws IOException {
		try {
			profile = new Profile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		profile.setID(message);
		profile.saveFile();
		System.out.println("edit profile id " + message);
	}
	
	private void startGame(String message) throws IOException {
		if(message.equals("Galalite 2")) {
			MultiplayerController.gamePopup("/galalite/StartScreen.fxml", "Galalite 2");
		} else if(message.equals("Matcher")) {
			MultiplayerController.gamePopup("/matcher/MatchingGameGUI.fxml", "Matcher");
		} else if(message.equals("Black Hole")) {
			MultiplayerController.gamePopup("/blackhole/BlackholeGameGUI.fxml", "Blackhole");
		} else {
			MultiplayerController.gamePopup("/brickbreaker/BrickBreak.fxml", "Brick Break");
		}
	}
}