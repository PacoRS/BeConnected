package ramirez.francisco.cosano.sergio.BeConnected;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import ramirez.francisco.cosano.sergio.BeConnected.model.RepoSala;
import ramirez.francisco.cosano.sergio.BeConnected.model.Sala;
import ramirez.francisco.cosano.sergio.BeConnected.model.User;

public class PrimaryController {

	private static User globalUser;
	@FXML
	private ImageView photo;
	@FXML
	private TextField name;
	@FXML
	private Button button;

	@FXML
	private void switchToSecondary() throws IOException {
		String nickname = name.getText();
		boolean flag = false;
		if (!nickname.equals("")) {
			globalUser = new User(nickname);
			do {
				if (compareUsers(globalUser)) {
					App.setRoot("secondary");
				} else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Error");
					alert.setContentText("El nickname ya existe, introduzca otra por favor");
				}
			} while (flag);

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText("El nickname no puede estar vacio");
		}
	}

	private boolean compareUsers(User user) {
		return false;
		

	}
}
