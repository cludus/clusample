package com.cludus.clugest;

import com.datastax.oss.driver.api.core.CqlSession;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.CassandraContainer;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import java.net.InetSocketAddress;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@ActiveProfiles("kafka")
class KafkaTests {

	private RestTemplate rest = new RestTemplate();

	@Value("${server.port}")
	private int serverPort;

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
	void contextLoads() {

	}

	void testAddCassandra() {

	}
}
