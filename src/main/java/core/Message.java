package core;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 12/12/13
 * Time: 12:56
 * To change this template use File | Settings | File Templates.
 */
import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    @JsonProperty
    private String nick;

    @JsonProperty
    private String message;

    private Message() {
    }

    public Message(String nick, String message) {
        this.nick=nick;
        this.message = message;
    }

    public String getNick() {
        return nick;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object object){
        Message msg = (Message) object;
        return  msg.getNick().equals(this.nick) && msg.getMessage().equals(this.message);

    }
}
