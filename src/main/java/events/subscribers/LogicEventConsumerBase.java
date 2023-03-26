package events.subscribers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class LogicEventConsumerBase {
  final Logger logger = LoggerFactory.getLogger(this.getClass());
  abstract String getLogicName();
}
