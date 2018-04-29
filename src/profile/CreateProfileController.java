package profile;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
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

	public File Imagefile;

	@FXML
	public void initialize() {

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
		Profile user = new Profile(name, birth, bio, filepath);
		
	}

}