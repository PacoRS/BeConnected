package ramirez.francisco.cosano.sergio.BeConnected.Interfaces;

import java.time.LocalDateTime;

public interface IMessage {
    ISala sala = null;
    IUser user = null;
    String message = "";
    Integer ID = 0;
    LocalDateTime date = LocalDateTime.now();

}
