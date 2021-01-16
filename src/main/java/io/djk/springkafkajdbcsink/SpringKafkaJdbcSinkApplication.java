package io.djk.springkafkajdbcsink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
//@EnableBinding(Processor.class)
public class SpringKafkaJdbcSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaJdbcSinkApplication.class, args);
	}

}
