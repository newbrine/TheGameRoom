package profile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Profile {

	public String name;
	public String birth;
	public String bio;
	public String imageFile;
	public File userFile;
	public String ip;

	final static int fileLines = 4;

	public Profile(String n, String b, String bi, String i) {
		this.name = n;
		this.birth = b;
		this.bio = bi;
		this.imageFile = i;
		try {
			this.ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Profile(File user) {
		this.userFile = user;
		try {
			this.ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveFile() throws IOException {
		userFile = new File(System.getProperty("user.dir") + "\\media\\user.txt");
		FileWriter writer = new FileWriter(userFile.getAbsolutePath());
		PrintWriter print = new PrintWriter(writer);
		print.println(name);
		print.println(birth);
		print.println(bio);
		print.println(imageFile);
		print.close();
	}

	public List<String> loadFile() {
		List<String> profile = new ArrayList<String>();
			try {
				FileReader fileReader = new FileReader(userFile.getAbsolutePath());
				BufferedReader br = new BufferedReader(fileReader);
				for (int i = 0; i < fileLines; i++) {
					profile.add(br.readLine());
				}
				br.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return profile;
	}
	
	public void updateProfile(String n, String b, String bi, String i) {
		setName(n);
		setBirth(b);
		setBio(bi);
		setImageFile(i);
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public void setBirth(String b) {
		this.birth = b;
	}
	
	public void setBio(String b) {
		this.bio = b;
	}
	
	public void setImageFile(String i) {
		this.imageFile = i;
	}

}
