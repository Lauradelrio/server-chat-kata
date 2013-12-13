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
public class ServerResource {
    private final int defaultNextSeq;
    private Persistence persistence;

    public ServerResource(int defaultNextSeq, Persistence persistence) {
        this.defaultNextSeq=defaultNextSeq;
        this.persistence=persistence;
    }

    @GET
    @Timed
    public Messages getServer(@QueryParam("next_seq") Optional<Integer> nextSeq) {
        return new Messages(persistence.getMsgList(nextSeq.or(defaultNextSeq)),persistence.getSizeMsg());
    }

    @POST
    public Response postServer(Message msg) {
        if(persistence.isMsgCorrect(msg)){
           persistence.addMsg(msg);
           return Response.status(Response.Status.OK).build();
        }else return Response.status(Response.Status.BAD_REQUEST).build();
    }

}