package profile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class CreateProfileController {

	@FXML
	private TextField birthField;

	@FXML
	private TextArea bioField;

	@FXML
	private ImageView imageview;

	@FXML
	private TextField nameField;

	@FXML
	private AnchorPane pane;

	@FXML
	private Button done;
	
	@FXML
	private Label title;

	public File Imagefile;
	public File userFile = new File(System.getProperty("user.dir") + "//media//user.txt");

	@FXML
	public void initialize() {
		System.out.println("heye");
		imageview.setVisible(true);
		if (userFile.exists()) {
			title.setText("Edit Profile");
			Profile user = new Profile(userFile);
			List<String> userInfo = user.loadFile();
	    	nameField.setText(userInfo.get(0));
	    	birthField.setText(userInfo.get(1));
	    	bioField.setText(userInfo.get(2));
	    	imageview.setImage(new Image(userInfo.get(3)));
	    	Imagefile = new File(userInfo.get(3).replaceAll("file:///", ""));
		}
	}

	@FXML
	public void loadImage() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Load Image");
		fileChooser.setInitialFileName("");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter(".png", "*.png"),
				new ExtensionFilter(".jpeg", "*.jpeg"), new ExtensionFilter(".jpg", "*.jpg"));
		Imagefile = fileChooser.showOpenDialog(pane.getScene().getWindow());
		Image img = new Image("file:///" + Imagefile.getAbsolutePath());
		imageview.setImage(img);
	}

	@FXML
	public void saveProfile() {
		String name = nameField.getText();
		String birth = birthField.getText();
		String bio = bioField.getText();
		String filepath = "file:///" + Imagefile.getAbsolutePath();
		try {
			Profile user = new Profile(name, birth, bio, filepath);
			user.saveFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Stage stage = (Stage) pane.getScene().getWindow();
		stage.close();
	}

}