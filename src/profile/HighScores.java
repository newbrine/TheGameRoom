package profile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HighScores {

	public List<String> finalList = new ArrayList<String>();
	public File highscoreFile;
	private int fileLines;

	public HighScores(List<String> scores) throws IOException {
		convertList(scores);
		saveFile();
		System.out.println(finalList);
	}
	
	public HighScores() {}

	public void convertList(List<String> scores) {
		for (int i = 1; i < scores.size(); i++) {
			if (!(i == scores.size())) {
				finalList.add(scores.get(i) + " - " + scores.get(i + 1));
				i = i + 1;
			} else {
				finalList.add(scores.get(i));
			}
		}
	}
	
	public void saveFile() throws IOException {
		highscoreFile = new File(System.getProperty("user.dir") + "\\media\\highscore.txt");
		FileWriter writer = new FileWriter(highscoreFile.getAbsolutePath());
		PrintWriter print = new PrintWriter(writer);
		for (int i = 0; i < finalList.size();i++) {
			print.println(finalList.get(i));
			fileLines = i;
		}
		print.close();
	}
	
	public ObservableList<String> loadFile() {
		ObservableList<String> highscores = FXCollections.observableArrayList();
		try {
			FileReader fileReader = new FileReader(highscoreFile.getAbsolutePath());
			BufferedReader br = new BufferedReader(fileReader);
			for (int i = 0; i < fileLines; i++) {
				highscores.add(br.readLine());
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return highscores;
	}
}
