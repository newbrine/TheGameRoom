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

public class Stats {
	String wins;
	String losses;
	String ties;
	String gamerscore;
	File statFile;
	
	private final int fileLines = 4;

	public Stats(String wins, String losses, String ties, String gamerscore) throws IOException {
		this.wins = wins;
		this.losses = losses;
		this.ties = ties;
		this.gamerscore = gamerscore;
		saveFile();
	}
	
	public Stats() {
		statFile = new File(System.getProperty("user.dir") + "\\media\\stats.txt");
	}
	
	public void saveFile() throws IOException {
		statFile = new File(System.getProperty("user.dir") + "\\media\\stats.txt");
		FileWriter writer = new FileWriter(statFile.getAbsolutePath());
		PrintWriter print = new PrintWriter(writer);
		print.println(wins);
		print.println(losses);
		print.println(ties);
		print.println(gamerscore);
		print.close();
	}
	
	public List<String> loadFile() {
		List<String> stats = new ArrayList<String>();
		try {
			FileReader fileReader = new FileReader(statFile.getAbsolutePath());
			BufferedReader br = new BufferedReader(fileReader);
			for (int i = 0; i < fileLines; i++) {
				stats.add(br.readLine());
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stats;
	}
	
	public boolean hasFile() {
		if (statFile.exists()) {
			return true;
		}
		
		return false;
	}
	
}
