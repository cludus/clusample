package com.cludus.clugest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@ActiveProfiles("mongodb")
class MongodbTests {

	private RestTemplate rest = new RestTemplate();

	@Value("${server.port}")
	private int serverPort;

	@Container
	private static final GenericContainer CONTAINER = new GenericContainer(DockerImageName.parse("mongo:latest"))
			.withExposedPorts(27017)
			.withEnv("MONGO_INITDB_ROOT_USERNAME", "admin")
			.withEnv("MONGO_INITDB_ROOT_PASSWORD", "admin")
			.withEnv("MONGO_INITDB_DATABASE", "clugest_products");

	@DynamicPropertySource
	static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.data.mongodb.uri", () -> String.format("mongodb://%s:%d/clugest_products", CONTAINER.getHost(), CONTAINER.getMappedPort(27017)));
		registry.add("spring.data.mongodb.username", () -> "admin");
		registry.add("spring.data.mongodb.password", () -> "admin");
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

	}
}
