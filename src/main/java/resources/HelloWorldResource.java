package resources;

import core.*;
import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.atomic.AtomicLong;

@Path("/chat-kata/api/chat")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    private Persistence persistence;

    public HelloWorldResource(String template, String defaultName,Persistence persistence) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
        this.persistence=persistence;
    }

    @GET
    @Timed
    public Messages sayHello(@QueryParam("name") Optional<String> name) {
//       return new Message(counter.incrementAndGet(), String.format(template, name.or(defaultName)));
        persistence.addMsg(new Message("Laura", "Hello, Stranger!"));                 // Ejemplo de inicialización
        return new Messages(persistence.getMsgList(),persistence.getSizeMsg());
    }

    @POST
    public Response parameterDemoMethod(Message msg) {
        boolean resp = persistence.addMsg(msg);
        return Response.status(Response.Status.OK).entity(resp).build();
        //return ClientResponse.Status.OK;
    }

}