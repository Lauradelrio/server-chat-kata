import com.yammer.dropwizard.testing.ResourceTest;
import core.Message;
import core.Messages;
import core.Persistence;
import junit.framework.Assert;
import org.fest.assertions.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;

import static com.yammer.dropwizard.testing.JsonHelpers.asJson;
import static com.yammer.dropwizard.testing.JsonHelpers.jsonFixture;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 13/12/13
 * Time: 9:52
 * To change this template use File | Settings | File Templates.
 */
public class PersistenceTest{

    Message msg = new Message("Laura", "Hola");
    Message msg2 = new Message("Laura","Que tal?");
    ArrayList<Message> msgArrayList = new ArrayList<Message>();
    Persistence persistence = new Persistence();

    @Test
    public void getMsgList() throws Exception {
        persistence.addMsg(msg);
        persistence.addMsg(new Message("Ana","Hola"));
        persistence.addMsg(msg2);
        assertTrue(persistence.getMsgList(0).contains(msg));
        assertFalse(persistence.getMsgList(1).contains(msg));
        assertTrue(persistence.getMsgList(1).contains(msg2));
        assertThat(persistence.getMsgList(4)).isEqualTo(new ArrayList<Message>());
    }



    @Test
    public void isMsgCorrect() throws Exception {
        assertFalse(persistence.isMsgCorrect(new Message("","")));
        assertFalse(persistence.isMsgCorrect(null));
    }
}
