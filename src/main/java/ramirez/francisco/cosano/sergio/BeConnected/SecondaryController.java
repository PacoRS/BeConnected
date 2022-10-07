package ramirez.francisco.cosano.sergio.BeConnected;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import ramirez.francisco.cosano.sergio.BeConnected.model.RepoSala;
import ramirez.francisco.cosano.sergio.BeConnected.model.Sala;

import java.io.IOException;
import java.util.ArrayList;

public class SecondaryController {

    protected static Sala globalSala;
    @FXML
    private Button crear;
    @FXML
    private Button unir;
    @FXML
    private TextField nombreSala = new TextField();
    @FXML
    private SplitMenuButton listaSalas = new SplitMenuButton();

    @FXML
    private void crearSala() throws IOException {
        boolean flag = false;

        do {
            String nombre = nombreSala.getText();
            if(!nombre.equals("")){
                if (compareSalas(nombre)){
                    globalSala = new Sala(nombre);
                    RepoSala rs = RepoSala.getRepoSala();
                    globalSala.addUser(PrimaryController.globalUser);
                    rs.addSala(globalSala);
                    rs.saveFile("aaa.xml");
                    flag = true;
                    App.setRoot("terciary");
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error");
                    alert.setContentText("El nombre de la sala ya existe, introduzca otra por favor");
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("El nombre de la sala no puede estar vacio");
            }
        }while(flag);

    }
    @FXML
    private void loadSalas(){
        RepoSala rs = RepoSala.getRepoSala();
        rs.loadFile("aaa.xml");
        ArrayList<Sala> salas = rs.getSalas();
        for (Sala sala:salas){
            MenuItem item = new MenuItem(sala.getName());
            listaSalas.getItems().add(item);
        }
    }
    @FXML
    private void unirSala() throws IOException {
        String name=nombreSala.getText();
        if(!name.equals("")){
            RepoSala rs = RepoSala.getRepoSala();
            rs.loadFile("aaa.xml");
            ArrayList<Sala> salas = rs.getSalas();
            globalSala = new Sala(name);
            for (Sala s:salas){
                if(s.getName().equals(globalSala.getName())){
                    s.addUser(PrimaryController.globalUser);
                    App.setRoot("terciary");
                }
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("El nombre de la sala no puede estar vacio");
        }
    }

    private boolean compareSalas(String nombre){
        boolean flag = false;
         RepoSala rs = RepoSala.getRepoSala();
         rs.loadFile("aaa.xml");
         ArrayList<Sala> salas = rs.getSalas();
         for(Sala s: salas){
             if(!s.getName().equals(nombre)){
                 flag = true;
             }else{
                 flag = false;
             }
         }
        return flag;
    }

}