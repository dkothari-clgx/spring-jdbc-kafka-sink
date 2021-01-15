package io.djk.springkafkajdbcsink;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootTest

public class SpringKafkaJdbcSinkIntegrationTests {
    @Autowired
    private Sink channels;

    @Autowired
    private MessageCollector collector;

    @Test
    public void testMessages() {
//        BlockingQueue<Message<?>> messages = collector.forChannel(channels.output());
//
//        assertThat(messages, receivesPayloadThat(is("foo")));
//        assertThat(messages, receivesPayloadThat(is("bar")));
//        assertThat(messages, receivesPayloadThat(is("foo")));
//        assertThat(messages, receivesPayloadThat(is("bar")));
    }
}


