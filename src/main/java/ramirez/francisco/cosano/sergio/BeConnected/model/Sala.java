package ramirez.francisco.cosano.sergio.BeConnected.model;

import ramirez.francisco.cosano.sergio.BeConnected.Interfaces.ISala;
import ramirez.francisco.cosano.sergio.BeConnected.Utils.Util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

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

	
	public Sala(String name) {
		this.name = name;
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

	public void removeMessage(Message message) {
		this.messages.remove(message);
	}

	public void addUser(User user) {
		this.users.add(user);
	}
	public void removeUser(User user) {
		this.users.remove(user);
	}

}
