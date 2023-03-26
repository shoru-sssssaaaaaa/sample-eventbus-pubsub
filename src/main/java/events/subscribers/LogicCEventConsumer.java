package events.subscribers;

import static events.EventTopics.TOPIC_CD;

import events.messages.LogicCDMessage;
import io.quarkus.vertx.ConsumeEvent;
import java.util.Random;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class LogicCEventConsumer extends LogicEventConsumerBase {

  @Override
  String getLogicName() {
    return "Logic C";
  }

  @ConsumeEvent(TOPIC_CD)
  public void consume(final LogicCDMessage message) {
    logger.info("{}: FIRED. Received message: 'name: {}'", getLogicName(), message.name());
    Random rand = new Random();
    try {
      int randomInt = rand.nextInt(100);
      logger.info("{}: Do something asynchronously", getLogicName());
      if (randomInt % 3 == 0) throw new InterruptedException(String.format("%s: Failed", getLogicName()));
    } catch (InterruptedException e) {
      logger.error("{}: Something wrong.", getLogicName());
      logger.info("Logic F: FIRED");
    }

    logger.info("{}: DONE successfully", getLogicName());
  }
}
