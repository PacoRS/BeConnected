package ramirez.francisco.cosano.sergio.BeConnected;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class PrimaryController {
	
	
	@FXML 
	private ImageView photo;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
       
		
    }
}
