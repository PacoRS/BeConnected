package ramirez.francisco.cosano.sergio.BeConnected;

import java.io.IOException;
import javafx.fxml.FXML;

public class TerciaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}