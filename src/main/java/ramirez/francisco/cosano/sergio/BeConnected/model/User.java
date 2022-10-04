package ramirez.francisco.cosano.sergio.BeConnected.model;

import ramirez.francisco.cosano.sergio.BeConnected.Interfaces.IUser;

public class User implements IUser {
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
