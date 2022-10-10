package ramirez.francisco.cosano.sergio.BeConnected.model;

import ramirez.francisco.cosano.sergio.BeConnected.Interfaces.IMessage;
//import ramirez.francisco.cosano.sergio.BeConnected.Interfaces.Sala;
//import ramirez.francisco.cosano.sergio.BeConnected.Interfaces.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@XmlRootElement(name = "Message")
@XmlAccessorType(XmlAccessType.FIELD)
public class Message implements IMessage, Comparable<Message>, Serializable {
    private static final long serialVersionUID = 1L;
    private Sala sala;
    private User user;
    private String message;
    private Integer ID;
    @XmlJavaTypeAdapter(type = LocalDateTime.class, value = LocalDateTimeBind.class)
    private LocalDateTime date;



	public Message(String message) {
		this.message = message;
	}

	public Message() {
        this.sala= null;
        this.user= null;
        this.message= "";
        this.ID= 0;
        this.date= null;
    }
	

    public Message(Sala sala, User user, String message, Integer iD) {
		super();
		this.sala = sala;
		this.user = user;
		this.message = message;
		ID = iD;
	}

	public Message(Sala sala, User user, String message, Integer ID, LocalDateTime date) {
        this.sala = sala;
        this.user = user;
        this.message = message;
        this.ID = ID;
        this.date = date;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public int compareTo(Message o) {
        if (this.date.isBefore(o.date)) {
            return -1;
        } else if (this.date.isAfter(o.date)) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return user.getNickname() + message;
    }
    
	public void saveFile(String url,Message men) {
		JAXBContext contexto;

		try {
			contexto = JAXBContext.newInstance(Message.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(men, new File(url));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public void loadFile(String url) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(RepoSala.class);
			Unmarshaller um=contexto.createUnmarshaller();
			
			RepoSala newClub= (RepoSala) um.unmarshal(new File(url));
			salas=newClub.salas;
		
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
}

class LocalDateTimeBind extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String val) {
        return LocalDateTime.parse(val, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SS"));
    }

    @Override
    public String marshal(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SS"));
    }

}