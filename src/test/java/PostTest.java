import com.sun.jersey.api.client.ClientResponse;
import core.Message;
import core.Messages;
import core.Persistence;
import org.junit.Test;
import resources.ServerResource;
import com.yammer.dropwizard.testing.ResourceTest;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PostTest extends ResourceTest {
    private final ArrayList<Message> msgArrayList = new ArrayList<Message>();
    private final Message msg = new Message("Laura", "Hola");
    private Messages msgList;
    private  Persistence persistence;

    @Override
    protected void setUpResources() {
        persistence = mock(Persistence.class);
        addResource(new ServerResource(0,persistence));
    }

    @Test
    public void OKResponseTest() throws Exception{
        when (persistence.isMsgCorrect(msg)).thenReturn(true);
        ClientResponse response = client().resource("/chat-kata/api/chat").type(MediaType.APPLICATION_JSON).post(ClientResponse.class,msg);
        verify(persistence).addMsg(msg);
        assertThat(response.getClientResponseStatus().getStatusCode()).isEqualTo(200);
    }

    @Test
    public void FailResponseTest() throws Exception{
        ClientResponse response = client().resource("/chat-kata/api/chat").type(MediaType.APPLICATION_JSON).post(ClientResponse.class);
        assertThat(response.getClientResponseStatus().getStatusCode()).isEqualTo(400);
    }

}
