package profile;

import java.io.File;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

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
    private Button done;
    
    @FXML
    private Label name;
    
    public void initialize() {
    	Profile user = new Profile(new File(System.getProperty("user.dir") + "//media//user.txt"));
    	List<String> userInfo = user.loadFile();
    	System.out.println(userInfo.get(0));
    	name.setText(userInfo.get(0));
    	birthField.setText(userInfo.get(1));
    	bioField.setText(userInfo.get(2));
    	imageview.setImage(new Image(userInfo.get(3)));
    }


}
