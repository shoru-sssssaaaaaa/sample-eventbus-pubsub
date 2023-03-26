package services.impl;

import static events.EventTopics.TOPIC_CD;

import events.messages.LogicCDMessage;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.EventBus;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repositories.api.SampleRepository;
import services.api.SampleService;

@ApplicationScoped
public class SampleServiceImpl implements SampleService {
  @Inject
  EventBus eventBus;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Inject
  SampleRepository repository;

  public Uni<String> startService(String name) {

    final var message = new LogicCDMessage(name);
    eventBus.publish(TOPIC_CD, message);

    logger.info("Logic E: do something against the database");
    return repository.doSomeThingInDatabase(name);
  }
}
