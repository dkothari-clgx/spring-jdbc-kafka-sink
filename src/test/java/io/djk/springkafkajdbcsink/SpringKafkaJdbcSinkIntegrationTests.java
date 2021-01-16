package io.djk.springkafkajdbcsink;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import java.math.BigDecimal;
import java.util.concurrent.BlockingQueue;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpringKafkaJdbcSinkIntegrationTests {
    @Autowired
    private Processor channels;

    @Autowired
    private MessageCollector collector;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testMessages() throws JsonProcessingException {
        BlockingQueue<Message<?>> messages = collector.forChannel(channels.output());

        BillingMessage message = BillingMessage.builder()
                .client("testClientName")
                .orderId("testOrderId")
                .product("testProductName")
                .amount(new BigDecimal(10.05))
                .build();

        this.channels.input().send(new GenericMessage<>(message));

        assertThat(messages.size()).isEqualTo(1);
        BillingMessage result = objectMapper.readValue((String) (messages.poll().getPayload()), BillingMessage.class);
        assertThat(result).usingRecursiveComparison().isEqualTo(result);
    }
}


