package io.djk.springkafkajdbcsink;

import jdk.jfr.Enabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Processor.class)
public class StreamKafkaJdbcProcessor {
    @Autowired
    private Processor processor;

    @StreamListener(Processor.INPUT)
    void process(ProductABillingMessage message) {
        processor.output().send(new GenericMessage<>(message));
    }

}
