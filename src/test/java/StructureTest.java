import com.yammer.dropwizard.testing.ResourceTest;
import core.Message;
import core.Messages;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 12/12/13
 * Time: 12:45
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;

import static com.yammer.dropwizard.testing.JsonHelpers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StructureTest {

    /* Message msg = new Message("Laura", "Hola");
     ArrayList<Message> msgArrayList = new ArrayList<Message>();
     Messages msgList;
*/
    @Test
    public void serializeMessageToJSON() throws Exception {
         Message msg = new Message("Laura", "Hola");
        assertThat("a Message can be serialized to JSON", asJson(msg), is(equalTo(jsonFixture("message.json"))));
    }

    @Test
    public void serializeListMessagesToJSON() throws Exception {
         Message msg = new Message("Laura", "Hola");
         ArrayList<Message> msgArrayList = new ArrayList<Message>();
         Messages msgList;
        msgArrayList.add(msg);
        msgList = new Messages(msgArrayList, 1);
        assertThat("a Messages can be serialized to JSON", asJson(msgList), is(equalTo(jsonFixture("messages.json"))));
    }

    @Test
    public void deserializesMessageFromJSON() throws Exception {
         Message msg = new Message("Laura", "Hola");
        assertThat("a Message can be deserialized from JSON",fromJson(jsonFixture("message.json"), Message.class), is(msg));
    }

/*    @Test
    public void deserializesListMessagesFromJSON() throws Exception {
         Message msg = new Message("Laura", "Hola");
         ArrayList<Message> msgArrayList = new ArrayList<Message>();
         Messages msgList;
        msgList = new Messages(msgArrayList,1);
        assertThat("a Messages can be deserialized from JSON",fromJson(jsonFixture("messages.json"), Messages.class), is(msgList));
    }*/
}
