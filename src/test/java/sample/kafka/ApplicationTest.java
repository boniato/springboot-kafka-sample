package sample.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.kafka.test.context.EmbeddedKafka;

@RunWith(SpringRunner.class)
@EmbeddedKafka
@SpringBootTest
public class ApplicationTest {

    @Test
    public void contextLoads() {
    }
}