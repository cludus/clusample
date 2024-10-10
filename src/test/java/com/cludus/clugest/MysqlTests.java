package com.cludus.clugest;

import com.cludus.clugest.dtos.JpaPersonReq;
import com.cludus.clugest.dtos.JpaPersonResp;
import com.cludus.clugest.dtos.JpaRealStatePropertyReq;
import com.cludus.clugest.dtos.JpaRealStatePropertyResp;
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
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@ActiveProfiles("jpa")
class MysqlTests {

	@Autowired
	private TestRestTemplate rest;

	@Container
	private static final MySQLContainer<?> CONTAINER = new MySQLContainer<>(DockerImageName.parse("mysql:latest"))
			.withDatabaseName("clugest_real_state")
			.withUsername("testuser")
			.withPassword("testpassword");

	@DynamicPropertySource
	static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.driver-class-name", CONTAINER::getDriverClassName);
		registry.add("spring.datasource.url", CONTAINER::getJdbcUrl);
		registry.add("spring.datasource.username", CONTAINER::getUsername);
		registry.add("spring.datasource.password", CONTAINER::getPassword);

		registry.add("spring.liquibase.enabled", () -> "true");
		registry.add("spring.liquibase.clear-checksums", () -> "true");
		registry.add("spring.liquibase.driver-class-name", CONTAINER::getDriverClassName);
		registry.add("spring.liquibase.url", CONTAINER::getJdbcUrl);
		registry.add("spring.liquibase.user", CONTAINER::getUsername);
		registry.add("spring.liquibase.password", CONTAINER::getPassword);
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
	void createPerson() {
		var req = JpaPersonReq.builder()
				.name("name")
				.build();
		String path = "/jpa/person";
		var createResult = rest.postForEntity(path, req, JpaPersonResp.class);
		Assertions.assertThat(createResult.getStatusCode().is2xxSuccessful()).isTrue();
		var getResult = rest.getForEntity(path + "/" + createResult.getBody().getId(), JpaPersonResp.class);
		Assertions.assertThat(getResult.getStatusCode().is2xxSuccessful()).isTrue();
		var updateResult = rest.postForEntity(path + "/" + createResult.getBody().getId(), req, JpaPersonReq.class);
		Assertions.assertThat(updateResult.getStatusCode().is2xxSuccessful()).isTrue();
		rest.delete(path + "/" + createResult.getBody().getId());
	}

	@Test
	void createRealStateProperty() {
		var req = JpaPersonReq.builder()
				.name("name")
				.build();
		var personResult = rest.postForEntity("/jpa/person", req, JpaPersonResp.class);
		Assertions.assertThat(personResult.getStatusCode().is2xxSuccessful()).isTrue();

		var rsReq = JpaRealStatePropertyReq.builder()
				.personId(personResult.getBody().getId())
				.description("description")
				.address1("address1")
				.address2("address2")
				.build();
		String path = "/jpa/real-state-property";
		var createResult = rest.postForEntity(path, rsReq, JpaRealStatePropertyResp.class);
		Assertions.assertThat(createResult.getStatusCode().is2xxSuccessful()).isTrue();
		var getResult = rest.getForEntity(path + "/" + createResult.getBody().getId(), JpaRealStatePropertyResp.class);
		Assertions.assertThat(getResult.getStatusCode().is2xxSuccessful()).isTrue();
		var updateResult = rest.postForEntity(path + "/" + createResult.getBody().getId(), req, JpaRealStatePropertyResp.class);
		Assertions.assertThat(updateResult.getStatusCode().is2xxSuccessful()).isTrue();
		rest.delete(path + "/" + createResult.getBody().getId());
	}
}
