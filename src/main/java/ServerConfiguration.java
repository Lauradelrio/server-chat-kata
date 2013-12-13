
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 12/12/13
 * Time: 12:54
 * To change this template use File | Settings | File Templates.
 */
public class ServerConfiguration extends Configuration {

    private int defaultNextSeq=0;

    public int getDefaultNextSeq() {
        return defaultNextSeq;
    }
}
