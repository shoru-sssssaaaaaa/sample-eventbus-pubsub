package controllers;

import io.smallrye.mutiny.Uni;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.api.SampleService;

@ApplicationScoped
public class SampleController {

  @Inject
  SampleService service;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public Uni<String> startEvent(String name) {
    logger.info("Logic B: Do some validations");
    // Do something to validate the input value.
    return service.startService(name);
  }
}
