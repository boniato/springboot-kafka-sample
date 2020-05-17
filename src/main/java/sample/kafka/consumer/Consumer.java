package sample.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${message.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void receive(String message) {
        LOG.info("Consumer receives a message : " + message);
    }

}