package sample.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sample.kafka.producer.Producer;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Task {

    private static final Logger LOG = LoggerFactory.getLogger(Task.class);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Value(value = "${message.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private Producer producer;

    @Scheduled(fixedRate = 1000)
    public void doScheduledTask() {
        producer.sendMessage(topic, "my payload " + DATE_FORMAT.format(new Date()));
        LOG.info("Task started. send message : ", topic);
    }
}
