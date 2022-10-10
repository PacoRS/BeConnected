package ramirez.francisco.cosano.sergio.BeConnected.model;

import ramirez.francisco.cosano.sergio.BeConnected.App;
import ramirez.francisco.cosano.sergio.BeConnected.PrimaryController;
import ramirez.francisco.cosano.sergio.BeConnected.SecondaryController;
import ramirez.francisco.cosano.sergio.BeConnected.Interfaces.ISala;
import ramirez.francisco.cosano.sergio.BeConnected.Utils.Util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Clase Sala y sus atributos
@XmlRootElement(name = "Sala")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sala implements ISala, Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Message> messages;

	private ArrayList<User> users;
	@XmlAttribute(name = "Nombre")
	private String name;
	@XmlAttribute(name = "ID")
	private Integer ID;

	// Todos los constructores
	public Sala(String name) {
		this.messages = new ArrayList<Message>();
		this.users = new ArrayList<User>();
		this.name = name;
		this.ID = (int) (Math.random() * 1000000);
	}

	public Sala() {
		this.messages = new ArrayList<Message>();
		this.users = new ArrayList<User>();
		this.name = "";
		this.ID = 0;
	}

	public Sala(ArrayList<Message> messages, ArrayList<User> users, String name, Integer ID) {
		this.messages = messages;
		this.users = users;
		this.name = name;
		this.ID = ID;
	}

	// Getters y Setters
	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public void addMessage(Message message) {
		this.messages.add(message);
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	public void removeUser(User user) {

		this.users.remove(user);

	}

	public ArrayList<Message> getall() {
		return messages;

	}

	public ArrayList<User> getallUser() {
		return users;

	}

	//Metodo para comparar las salas
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(name, other.name);
	}

	//ToString
	@Override
	public String toString() {
		return "Sala [messages=" + messages + ", users=" + users + ", name=" + name + ", ID=" + ID + "]";
	}

}
