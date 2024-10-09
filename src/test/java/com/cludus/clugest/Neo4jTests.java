package com.cludus.clugest;

import com.cludus.clugest.dtos.N4jEconomicEntityReq;
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
import org.testcontainers.containers.Neo4jContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@ActiveProfiles("neo4j")
class Neo4jTests {

	@Autowired
	private TestRestTemplate rest;

	@Container
	private static final Neo4jContainer<?> CONTAINER
			= new Neo4jContainer<>(DockerImageName.parse("neo4j:latest"))
			.withRandomPassword();

	@DynamicPropertySource
	static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.neo4j.uri", CONTAINER::getBoltUrl);
		registry.add("spring.neo4j.authentication.username", () -> "neo4j");
		registry.add("spring.neo4j.authentication.password", CONTAINER::getAdminPassword);
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
	void createEntity() {
		var req = N4jEconomicEntityReq.builder()
					.name("entity")
					.build();
		var result = rest.postForEntity("/neo4j/economic-entity", req, N4jEconomicEntityReq.class);
		Assertions.assertThat(result.getStatusCode().is2xxSuccessful()).isTrue();
	}
}
