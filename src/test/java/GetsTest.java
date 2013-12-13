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

public class GetsTest extends ResourceTest {
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
    public void EmptyTest() throws Exception {
        msgList = new Messages(msgArrayList,0);
        Messages msgListResult = client().resource("/chat-kata/api/chat").type(MediaType.APPLICATION_JSON).get(Messages.class);
        verify(persistence).getMsgList(0);
        assertThat(msgListResult).isEqualTo(msgList);
    }

    @Test
    public void NextSeq1Test() throws Exception {
        Messages msgListResult = client().resource("/chat-kata/api/chat").queryParam("next_seq","1").type(MediaType.APPLICATION_JSON).get(Messages.class);
        verify(persistence).getMsgList(1);
    }

    @Test
    public void ReturnTest() throws Exception{
        msgArrayList.add(new Message("Laura","Hola"));
        msgArrayList.add(new Message("Laura","Que tal"));
        when (persistence.getMsgList(0)).thenReturn(msgArrayList);
        when (persistence.getSizeMsg()).thenReturn(2);
        msgList=new Messages(msgArrayList,msgArrayList.size());
        Messages msgListResult = client().resource("/chat-kata/api/chat").type(MediaType.APPLICATION_JSON).get(Messages.class);
        assertThat(msgListResult).isEqualTo(msgList);
    }

}
