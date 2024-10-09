package com.cludus.clugest;

import com.cludus.clugest.dtos.CassChatMessageReq;
import com.cludus.clugest.dtos.CassChatMessageResp;
import com.datastax.oss.driver.api.core.CqlSession;
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
import org.testcontainers.containers.CassandraContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;
import java.net.InetSocketAddress;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@ActiveProfiles("cassandra")
class CassandraTests {
	@Autowired
	private TestRestTemplate rest;

	@Container
	private static final CassandraContainer<?> CONTAINER
			= new CassandraContainer<>(DockerImageName.parse("cassandra:latest"))
				.withExposedPorts(9042);

	private static final String KEYSPACE_NAME = "clugest_messages";

	@DynamicPropertySource
	static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.cassandra.port", () -> CONTAINER.getMappedPort(9042));
		registry.add("spring.cassandra.contact-points", CONTAINER::getHost);
		registry.add("spring.cassandra.username", CONTAINER::getUsername);
		registry.add("spring.cassandra.password", CONTAINER::getPassword);
		registry.add("spring.cassandra.keyspace-name", () -> KEYSPACE_NAME);
		registry.add("spring.cassandra.local-datacenter", CONTAINER::getLocalDatacenter);
	}

	@BeforeAll
	static void beforeAll() {
		CONTAINER.start();
		var session = CqlSession.builder()
				.withLocalDatacenter(CONTAINER.getLocalDatacenter())
				.addContactPoint(InetSocketAddress.createUnresolved(CONTAINER.getHost(), CONTAINER.getMappedPort(9042)))
				.withAuthCredentials(CONTAINER.getUsername(), CONTAINER.getPassword())
				.build();
		try (session) {
			session.execute("CREATE KEYSPACE IF NOT EXISTS " + KEYSPACE_NAME +
					" WITH replication = \n" +
					"{'class':'SimpleStrategy','replication_factor':'1'};");
		}
	}

	@AfterAll
	static void afterAll() {
		CONTAINER.stop();
	}

	@Test
	void addMessage() {
		var req = CassChatMessageReq.builder()
				.content("asdfasdf")
				.senderId("user1")
				.receiverId("user2")
				.timestamp(System.currentTimeMillis())
				.build();
		var addResult = rest.postForEntity("/cassandra/chat-message", req, CassChatMessageResp.class);
		Assertions.assertThat(addResult.getStatusCode().is2xxSuccessful()).isTrue();
		Assertions.assertThat(addResult.getBody()).isNotNull();
		Assertions.assertThat(addResult.getBody().getId()).isNotNull();

		var getResult = rest.getForEntity("/cassandra/chat-message/" + addResult.getBody().getId(), CassChatMessageResp.class);
		Assertions.assertThat(getResult.getStatusCode().is2xxSuccessful()).isTrue();
	}
}
