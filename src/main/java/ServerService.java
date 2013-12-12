/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 12/12/13
 * Time: 12:55
 * To change this template use File | Settings | File Templates.
 */
import core.Persistence;
import health.TemplateHealthCheck;
import resources.HelloWorldResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class ServerService extends Service<ServerConfiguration> {
    public static void main(String[] args) throws Exception {
        new ServerService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ServerConfiguration> bootstrap) {
        bootstrap.setName("server");
    }

    @Override
    public void run(ServerConfiguration configuration, Environment environment) {
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        final Persistence persistence= new Persistence();
        environment.addResource(new HelloWorldResource(template, defaultName, persistence));
        environment.addHealthCheck(new TemplateHealthCheck(template));
    }

}
