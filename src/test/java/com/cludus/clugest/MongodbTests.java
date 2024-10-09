package com.cludus.clugest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
@ActiveProfiles("mongodb")
class MongodbTests {

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

	@Test
	void contextLoads() {

	}

	void testPostgres() {

	}
}
