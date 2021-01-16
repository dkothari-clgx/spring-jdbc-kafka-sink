package io.djk.springkafkajdbcsink;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import java.util.concurrent.BlockingQueue;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpringKafkaJdbcSinkIntegrationTests {
    @Autowired
    private Processor channels;
//    @Autowired
//    private InputDestination input;

    @Autowired
    private MessageCollector collector;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testMessages() throws JsonProcessingException {
        BlockingQueue<Message<?>> messages = collector.forChannel(channels.output());
        String client = "test client name";
        String orderId = "test order id";
        String product = "test product name";
        Float amount = 10.05f;

        ProductABillingMessage productABillingMessage = new ProductABillingMessage(client, orderId, product, amount);
        this.channels.input().send(new GenericMessage<>(productABillingMessage));

        assertThat(messages.size()).isEqualTo(1);
        ProductABillingMessage productABillingMessage1 = objectMapper.readValue((String) (messages.poll().getPayload()), ProductABillingMessage.class);
        assertThat(productABillingMessage1).usingRecursiveComparison().isEqualTo(productABillingMessage);
    }
}


