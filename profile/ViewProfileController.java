package profile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import gameroom.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewProfileController {

    @FXML
    private TextField birthField;

    @FXML
    private Text wins_losses;

    @FXML
    private TextArea bioField;

    @FXML
    private ImageView imageview;

    @FXML
    private Text gamerscore;

    @FXML
    private AnchorPane pane;

    @FXML
    private Button edit;
    
    @FXML
    private Text name;
    
    public Profile user;
    
    public void initialize() {
    	user = new Profile(new File(System.getProperty("user.dir") + "//media//user.txt"));
    	List<String> userInfo = user.loadFile();
    	name.setText(userInfo.get(0));
    	birthField.setText(userInfo.get(1));
    	birthField.setEditable(false);
    	bioField.setText(userInfo.get(2));
    	bioField.setEditable(false);
    	imageview.setImage(new Image(userInfo.get(3)));
    }
    
    public void edit() {
    	changeStage("CreateProfile.fxml");
    }
    
    public void changeStage(String fxml) {
		try {
			Parent pane = FXMLLoader.load(getClass().getResource(fxml));
			Scene scene = new Scene(pane);
			Stage stage = (Stage) name.getScene().getWindow();
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


}
