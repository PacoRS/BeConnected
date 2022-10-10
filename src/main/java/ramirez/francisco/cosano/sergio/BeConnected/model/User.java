package ramirez.francisco.cosano.sergio.BeConnected.model;

import ramirez.francisco.cosano.sergio.BeConnected.Interfaces.IUser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.File;
import java.io.Serializable;
import java.util.Objects;

//Clase User y sus atributos
@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements IUser, Serializable {

    private static final long serialVersionUID = 1L;
    private String nickname;
    private Integer ID;

    
    // Todos los constructores
    public User(String nickname) {
		this.nickname = nickname;
        this.ID= (int) (Math.random() * 1000000);
	}

	public User() {
        this.nickname = "";
        this.ID = 0;
    }

    public User(String nickname, Integer ID) {
        this.nickname = nickname;
        this.ID = ID;
    }

    // Getters y Setters
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    //Tostring
    @Override
    public String toString() {
        return "User{" + "nickname='" + nickname + '\'' + ", ID=" + ID + '}';
    }

    public void saveFile(String url,User user) {
		JAXBContext contexto;

		try {
			contexto = JAXBContext.newInstance(Message.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(user, new File(url));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    //Equals y Hashcode
	@Override
	public int hashCode() {
		return Objects.hash(ID, nickname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(nickname, other.nickname);
	}
}