package rest;

import controllers.SampleController;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.EventBus;
import io.vertx.mutiny.core.eventbus.Message;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/async")
public class SampleResource {

  @Inject
  SampleController controller;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("{name}")
  public Uni<String> greeting(String name) {
    logger.info("Logic A: request received");
    return controller.startEvent(name);
  }

}
