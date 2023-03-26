package events.subscribers;

import static events.EventTopics.TOPIC_CD;
import static events.EventTopics.TOPIC_GH;

import events.messages.LogicCDMessage;
import events.messages.LogicGHMessage;
import io.quarkus.vertx.ConsumeEvent;
import io.vertx.mutiny.core.eventbus.EventBus;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LogicDEventConsumer extends LogicEventConsumerBase {

  @Override
  String getLogicName() {
    return "Logic D";
  }

  @Inject
  EventBus eventBus;

  @ConsumeEvent(TOPIC_CD)
  public void consume(final LogicCDMessage message) {
    logger.info("{}: FIRED. Received message: 'name: {}'", getLogicName(), message.name());
    logger.info("{}: Do something asynchronously", getLogicName());
    logger.info("{}: DONE successfully", getLogicName());

    var nextMessage = new LogicGHMessage(message.name());
    eventBus.publish(TOPIC_GH, nextMessage);
  }
}
