package ramirez.francisco.cosano.sergio.BeConnected;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import ramirez.francisco.cosano.sergio.BeConnected.model.Message;
import ramirez.francisco.cosano.sergio.BeConnected.model.RepoSala;
import ramirez.francisco.cosano.sergio.BeConnected.model.Sala;
import ramirez.francisco.cosano.sergio.BeConnected.model.User;

public class TerciaryController {

	protected static ArrayList<Sala> globalSalas;
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
	private TableColumn<Message, String> columMessages;
	@FXML
	private TableColumn<User, String> columUser;

	private ObservableList<Message> observMessages;
	private ArrayList<Message> listMessages;

	private ObservableList<User> observUser;
	private ArrayList<User> listUser;

	//Metodo que crea los ObservableList para los mensajes y los usuarios
	@FXML
	private void switchToSecondary() throws IOException {
		listMessages = new ArrayList<>();
		observMessages = FXCollections.observableArrayList(listMessages);

		listUser = new ArrayList<>();
		observUser = FXCollections.observableArrayList(listUser);

	}

	//Metodo que carga los mensajes y los usuarios en el tableView
	private void configuraTabla() {
		// TODO Auto-generated method stub
		SecondaryController a = new SecondaryController();
		Sala sal3 = a.devuelveSala(a.getCopiaNombSala());

		columMessages.setCellValueFactory(Message -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue("User --> " + Message.getValue().getUser().getNickname() + "\n" + "Message --> "
					+ Message.getValue().getMessage());
			return ssp;
		});

		columUser.setCellValueFactory(User -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue("User --> " + User.getValue().getNickname());
			return ssp;
		});

	}

	//Metodo que inicia la carga de mensajes y usuarios y los añade al tableView de la sala
	//refresca la tabla cada segundo
	@FXML
	protected void initialize() throws IOException {

		SecondaryController a = new SecondaryController();
		Sala sal3 = a.devuelveSala(a.getCopiaNombSala());
		this.configuraTabla();
		observMessages = FXCollections.observableArrayList(sal3.getall());
		messages.setItems(observMessages);
		observUser = FXCollections.observableArrayList(sal3.getallUser());
		usersActive.setItems(observUser);

		RepoSala rs = RepoSala.getRepoSala();
		Timer t = new Timer();

		TimerTask t2 = new TimerTask() {

			@Override
			public void run() {

				rs.loadFile("aaa.xml");
				Sala sal1 = a.devuelveSala(a.getCopiaNombSala());
				observMessages.removeAll(observMessages);
				observMessages.addAll(sal1.getMessages());

				observUser.removeAll(observUser);
				observUser.addAll(sal1.getallUser());
			}
		};
		t.schedule(t2, 0, 1000);

	}

	//Metodo que envia el mensaje a la sala
	@FXML
	public void sendMessage() {
		RepoSala rs = RepoSala.getRepoSala();
		SecondaryController a = new SecondaryController();
		Sala sal3 = a.devuelveSala(a.getCopiaNombSala());
		Message m1;
		String message = text.getText();
		this.observMessages.add(m1 = new Message(message));
		this.text.setText("");
		m1.setUser(PrimaryController.globalUser);
		sal3.addMessage(m1);
		rs.saveFile("aaa.xml");
	}

	//Metodo que devuelve a la ventana anterior
	@FXML
	protected void VuelveSecondary() throws IOException {
		App.setRoot("secondary");
	}

}