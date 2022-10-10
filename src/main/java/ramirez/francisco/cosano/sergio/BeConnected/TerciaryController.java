package ramirez.francisco.cosano.sergio.BeConnected;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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

	private ObservableList<Message> observMessages;
	private ArrayList<Message> listMessages;

	@FXML
	private void switchToSecondary() throws IOException {
		listMessages = new ArrayList<>();
		observMessages = FXCollections.observableArrayList(listMessages);
	}

	private void configuraTabla() {
		// TODO Auto-generated method stub

		columMessages.setCellValueFactory(Message -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(Message.getValue().getMessage() + Message.getValue().getUser());
			return ssp;
		});

	}

	@FXML
	protected void initialize() throws IOException {
		SecondaryController a = new SecondaryController();
		Sala sal3 = a.devuelveSala(a.getCopiaNombSala());
		this.configuraTabla();
		observMessages = FXCollections.observableArrayList(sal3.getall());
		messages.setItems(observMessages);

	}
	@FXML
	public void sendMessage() {
		RepoSala rs = RepoSala.getRepoSala();
		SecondaryController a = new SecondaryController();
		Sala sal3 = a.devuelveSala(a.getCopiaNombSala());
		Message m1 ;
		String message = text.getText();
		this.observMessages.add(m1=new Message(message));
		this.text.setText("");
		m1.setUser(PrimaryController.globalUser);
		sal3.addMessage(m1);
		rs.saveFile("aaa.xml");
		
		
		
		
	}
}