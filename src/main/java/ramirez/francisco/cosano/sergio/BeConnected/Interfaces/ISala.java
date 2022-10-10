package ramirez.francisco.cosano.sergio.BeConnected.Interfaces;

import java.util.ArrayList;

//Interfaz para Sala
public interface ISala {
    ArrayList<IMessage> messages = new ArrayList<IMessage>();
    ArrayList<IUser> users = new ArrayList<IUser>();
    String name = "";
    Integer ID = 0;


}
