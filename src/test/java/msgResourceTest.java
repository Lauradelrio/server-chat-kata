import core.Message;
import core.Messages;
import core.Persistence;
import org.junit.Test;
import resources.HelloWorldResource;
import com.yammer.dropwizard.testing.ResourceTest;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class msgResourceTest extends ResourceTest {
    private final ArrayList<Message> msgArrayList = new ArrayList<Message>();
    private final Message msg = new Message("Laura", "Hello, Stranger!");
    private Messages msgList;
    private  Persistence persistence;

    @Override
    protected void setUpResources() {
        persistence = mock(Persistence.class);
        //addResource(new HelloWorldResource("Hello, %s!", "Stranger")); //añade recurso que esta funcionando
        addResource(new HelloWorldResource("Hello, %s!", "Stranger", persistence));
    }
/*    @Test
    public void simpleResourceTest() throws Exception {
        msgArrayList.add(msg);
        msgList = new Messages(0, msgArrayList);
        Messages hhh = client().resource("/chat-kata/api/chat").type(MediaType.APPLICATION_JSON).get(Messages.class);
        assertThat(hhh).isEqualTo(msgList);
    }*/



/*    @Test
    public void postTest() throws Exception{
        ClientResponse response = client().resource("/chat-kata/api/chat").type(MediaType.APPLICATION_JSON).post(ClientResponse.class,msg);
        verify(persistence).addMsg(msg);
    }*/


/*    @Test
    public void serializesToJSON() throws Exception {
        final msg msg = new msg("Luther Blissett", "lb@example.com");
//        assertThat("a msg can be serialized to JSON", asJson(msg), is(equalTo(jsonFixture("fixtures/msg.json"))));
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        final msg msg = new msg("Luther Blissett", "lb@example.com");
//        assertThat("a msg can be deserialized from JSON",fromJson(jsonFixture("fixtures/msg.json"), msg.class), is(msg));
    }*/
}
