package ramirez.francisco.cosano.sergio.BeConnected;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import ramirez.francisco.cosano.sergio.BeConnected.model.Message;
import ramirez.francisco.cosano.sergio.BeConnected.model.User;

public class TerciaryController {

    @FXML
    private TextField text;
    @FXML
    private Button send;
    @FXML
    private Button back;
    @FXML
    private Label cont;
    @FXML
    private TableView<User> usersActive;
    @FXML
    private TableView<Message> messages;



    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}