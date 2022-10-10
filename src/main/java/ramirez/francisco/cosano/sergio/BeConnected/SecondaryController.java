package ramirez.francisco.cosano.sergio.BeConnected;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import ramirez.francisco.cosano.sergio.BeConnected.model.RepoSala;
import ramirez.francisco.cosano.sergio.BeConnected.model.Sala;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SecondaryController implements Initializable {

	protected static ArrayList<Sala> globalSalas;
	@FXML
	private Button crear;
	@FXML
	private Button unir;
	@FXML
	private TextField nombreSala = new TextField();
	@FXML
	private SplitMenuButton listaSalas = new SplitMenuButton();
	private static String CopiaNombSala;


	//Metodo que valida el nombre de la sala y lo compara para que no se repita, y la añade a la lista de salas
	@FXML
	private void crearSala() throws IOException {
		boolean flag = false;

		do {
			String nombre = nombreSala.getText();
			if (!nombre.equals("")) {
				if (compareSalas(nombre)) {
					RepoSala rs = RepoSala.getRepoSala();
					globalSalas = rs.devuelveArray();
					Sala sala = new Sala(nombre);
					sala.addUser(PrimaryController.globalUser);
					globalSalas.add(sala);
					rs.saveFile("aaa.xml");
					flag = true;
					App.setRoot("terciary");
				} else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Error");
					alert.setContentText("El nombre de la sala ya existe, introduzca otra por favor");
					alert.showAndWait();
				}
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error");
				alert.setContentText("El nombre de la sala no puede estar vacio");
				alert.showAndWait();
			}
		} while (!flag);

	}

	//Metodo que carga todas las salas
	@FXML
	private void loadSalas() {
		RepoSala rs = RepoSala.getRepoSala();
		rs.loadFile("aaa.xml");
		ArrayList<Sala> salas = rs.devuelveArray();
		for (Sala sala : salas) {
			MenuItem item = new MenuItem(sala.getName());
			listaSalas.getItems().add(item);
		}
	}

	//Metodo para unirte a una sala predefinida y añade al usuario a la sala
	@FXML
	private void unirSala() throws IOException {
		String name = nombreSala.getText();
		if (!name.equals("")) {
			RepoSala rs = RepoSala.getRepoSala();
			rs.loadFile("aaa.xml");
			globalSalas = rs.devuelveArray();
			for (Sala s : globalSalas) {
				if (s.getName().equals(name)) {
					s.addUser(PrimaryController.globalUser);
					rs.saveFile("aaa.xml");
					App.setRoot("terciary");
				}
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText("El nombre de la sala no puede estar vacio");
			alert.showAndWait();
		}
	}

	//Metodo que compara el nombre de la sala con las que ya existen
	private boolean compareSalas(String nombre) {
		boolean flag = false;
		RepoSala rs = RepoSala.getRepoSala();
		rs.loadFile("aaa.xml");
		ArrayList<Sala> salas = rs.devuelveArray();
		for (Sala s : salas) {
			if (!s.getName().equals(nombre)) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	//Metodo que carga la sala seleccionada
	public void fill() { // terminar, no funciona correctamente
		ObservableList<MenuItem> hola = listaSalas.getItems();
		for (MenuItem m : hola) {
			m.setOnAction((e) -> {
				nombreSala.setText(m.getText());
				CopiaNombSala = m.getText();
			});
		}
	}

	//Metodo que devuelve una sala del array dado un nombre
	public static Sala devuelveSala(String name) {
		Sala s1 = new Sala();
		RepoSala rs = RepoSala.getRepoSala();
		rs.loadFile("aaa.xml");
		ArrayList<Sala> salas = rs.devuelveArray();
		for (Sala sala : salas) {
			if (sala.getName().equals(name)) {
				s1=sala;
			}
		}
		return s1;
	}

	//Metodo que inicia la cargar de salas
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		loadSalas();
		fill();
	}

	//Metodo que devuelve el nombre de la sala
	public static String getCopiaNombSala() {
		return CopiaNombSala;
	}
	//Metodo que cambia el nombre de la sala
	public static void setCopiaNombSala(String CopiaNombSala) {
		SecondaryController.CopiaNombSala = CopiaNombSala;
	}

}