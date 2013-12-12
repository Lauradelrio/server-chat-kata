package core;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 12/12/13
 * Time: 12:57
 * To change this template use File | Settings | File Templates.
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class Messages {

    @JsonProperty
    private ArrayList<Message> messages;

    @JsonProperty
    private int nextSeq;

    private Messages() {
    }

    public Messages(int nextSeq, ArrayList<Message> messages) {
        this.messages = messages;
        this.nextSeq = nextSeq;
    }

    public int getNextSeq() {
        return nextSeq;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    @Override
    public boolean equals(Object object){
        Messages msgs = (Messages) object;
        return  msgs.getNextSeq()==this.nextSeq && msgs.getMessages().equals(this.messages);

    }
}
