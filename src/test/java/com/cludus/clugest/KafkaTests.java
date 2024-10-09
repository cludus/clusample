package com.cludus.clugest;

import com.cludus.clugest.dtos.CassChatMessageReq;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@ActiveProfiles("kafka")
class KafkaTests {

	@Autowired
	private TestRestTemplate rest;

	@Container
	private static final KafkaContainer CONTAINER
			= new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));

	@DynamicPropertySource
	static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.kafka.bootstrap-servers", CONTAINER::getBootstrapServers);
		registry.add("spring.kafka.admin.client-id", () -> "clugest1");
		registry.add("spring.kafka.consumer.client-id", () -> "clugest1");
		registry.add("spring.kafka.consumer.group-id", () -> "readers");
		registry.add("spring.kafka.producer.client-id", () -> "clugest1");
	}

	@BeforeAll
	static void beforeAll() {
		CONTAINER.start();
	}

	@AfterAll
	static void afterAll() {
		CONTAINER.stop();
	}

	@Test
	void doTest() {
		var result = rest.postForEntity("/kafka/play-event", null, String.class);
		Assertions.assertThat(result.getStatusCode().is2xxSuccessful()).isTrue();
	}
}
