package ramirez.francisco.cosano.sergio.BeConnected.model;

import ramirez.francisco.cosano.sergio.BeConnected.Interfaces.IUser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements IUser, Serializable {

    private static final long serialVersionUID = 1L;
    private String nickname;
    private Integer ID;

    public User() {
        this.nickname = "";
        this.ID = 0;
    }

    public User(String nickname, Integer ID) {
        this.nickname = nickname;
        this.ID = ID;
    }

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

    @Override
    public String toString() {
        return "User{" + "nickname='" + nickname + '\'' + ", ID=" + ID + '}';
    }
}