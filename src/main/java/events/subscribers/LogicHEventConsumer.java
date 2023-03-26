package events.subscribers;

import static events.EventTopics.TOPIC_GH;

import events.messages.LogicGHMessage;
import io.quarkus.vertx.ConsumeEvent;
import javax.inject.Singleton;

@Singleton
public class LogicHEventConsumer extends LogicEventConsumerBase{

  @Override
  String getLogicName() {
    return "Logic H";
  }

  @ConsumeEvent(TOPIC_GH)
  public void consume(final LogicGHMessage message) {
    logger.info("{}: FIRED. Received message: 'name: {}'", getLogicName(), message.name());

    logger.info("{}: DONE successfully", getLogicName());
  }
}
