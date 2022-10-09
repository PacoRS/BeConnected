package ramirez.francisco.cosano.sergio.BeConnected;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ramirez.francisco.cosano.sergio.BeConnected.model.Message;
import ramirez.francisco.cosano.sergio.BeConnected.model.RepoSala;
import ramirez.francisco.cosano.sergio.BeConnected.model.Sala;
import ramirez.francisco.cosano.sergio.BeConnected.model.User;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;

	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("primary"), 640, 480);
		stage.setScene(scene);
		stage.show();
		ArrayList<Message> ayuda = new ArrayList<>();
		ArrayList<Message> ayuda2 = new ArrayList<>();
		ArrayList<User> ayudaa = new ArrayList<>();
		RepoSala repo = RepoSala.getRepoSala();
		Sala sal=null;
		Sala sal2=null;

		User u1 = new User("antonio", 1);
		User u2 = new User("paco", 2);
		Message m1 = new Message(sal, u1, "aaaaaaaaaaaaaaaaaa", 5);
		Message m2 = new Message(sal2, u2, "bbbbbbbbbbbbbbbbb", 6);
		ayuda.add(m1);
		ayuda.add(m2);
		ayudaa.add(u1);
		ayudaa.add(u2);
		sal = new Sala(ayuda, ayudaa, "LOL", 3);
		sal2 = new Sala(ayuda2, ayudaa, "VALO", 4);
	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		launch();
	}

}