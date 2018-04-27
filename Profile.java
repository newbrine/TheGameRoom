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

public class Profile {

	public String name;
	public String birth;
	public String bio;
	public String imageFile;
	public File userFile;

	final static int fileLines = 4;

	public Profile(String n, String b, String bi, String i) {
		this.name = n;
		this.birth = b;
		this.bio = bi;
		this.imageFile = i;
		try {
			saveFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void saveFile() throws IOException {
		System.out.println("made it1");
		userFile = new File(System.getProperty("user.dir") + "\\media\\user.txt");
		FileWriter writer = new FileWriter(userFile.getAbsolutePath());
		PrintWriter print = new PrintWriter(writer);
		print.println(name);
		print.println(birth);
		print.println(bio);
		print.println(imageFile);
		print.close();
	}

	private List<String> loadFile() {
		List<String> profile = new ArrayList<String>();
			try {
				FileReader fileReader = new FileReader(userFile.getAbsolutePath());
				BufferedReader br = new BufferedReader(fileReader);
				for (int i = 0; i < fileLines; i++) {
					profile.add(br.readLine());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return profile;
	}

}
