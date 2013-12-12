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

    public Messages(ArrayList<Message> messages, int nextSeq) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Messages messages1 = (Messages) o;

        if (nextSeq != messages1.getNextSeq()) return false;
        if (messages != null ? !messages.equals(messages1.getMessages()) : messages1.getMessages() != null) return false;

        return true;
    }

/*    @Override
    public boolean equals(Object object){
        Messages msgs = (Messages) object;
        return  msgs.getNextSeq()==this.nextSeq && msgs.getMessages().equals(this.messages);
    }*/

}
