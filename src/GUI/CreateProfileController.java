package GUI;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class CreateProfileController {
	
	@FXML
	AnchorPane pane;
	
	@FXML
	ImageView imageview;
	
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
				new ExtensionFilter(".jpeg", "*.jpeg"), new ExtensionFilter(".jpg","*.jpg"));
		File file = fileChooser.showOpenDialog(pane.getScene().getWindow());
		Image img = new Image("file:///" + file.getAbsolutePath());
		imageview.setImage(img);
		
	}

}