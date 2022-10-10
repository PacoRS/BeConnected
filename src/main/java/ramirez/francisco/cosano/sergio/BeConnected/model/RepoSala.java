package ramirez.francisco.cosano.sergio.BeConnected.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

//Clase RepoSala y sus atributos
@XmlRootElement(name = "ListSalas")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoSala {
	
	private ArrayList<Sala> salas;
	private static RepoSala _instance;
	
	//Devuelve la instancia de la clase
	public static RepoSala getRepoSala() {
		if (_instance == null) {
			_instance = new RepoSala();
		}
		return _instance;
	}
	//Constructores
	private RepoSala() {
		salas=new ArrayList<Sala>();
	}

	private RepoSala(ArrayList<Sala> salas) {
		super();
		this.salas = salas;
	}

	//Metodo para guardar en XML
	public void saveFile(String url) {
		JAXBContext contexto;

		try {
			contexto = JAXBContext.newInstance(RepoSala.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(_instance, new File(url));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Metodo para cargar de XML
	public void loadFile(String url) {
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

	}

	//Metodo para añadir una sala
	public void addSala(Sala s) {
		salas.add(s);
	}
	public ArrayList<Sala> devuelveArray( ){
		
		return salas;
		
	}
	
}
