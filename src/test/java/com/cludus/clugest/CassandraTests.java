package com.cludus.clugest;

import com.datastax.oss.driver.api.core.CqlSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.CassandraContainer;
import org.testcontainers.utility.DockerImageName;
import java.net.InetSocketAddress;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
@ActiveProfiles("cassandra")
class CassandraTests {

	private static final CassandraContainer<?> CASSANDRA_CONTAINER
			= new CassandraContainer<>(DockerImageName.parse("cassandra:latest"))
				.withExposedPorts(9042);

	private static final String KEYSPACE_NAME = "clugest_messages";

	@DynamicPropertySource
	static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.cassandra.port", () -> CASSANDRA_CONTAINER.getMappedPort(9042));
		registry.add("spring.cassandra.contact-points", CASSANDRA_CONTAINER::getHost);
		registry.add("spring.cassandra.username", CASSANDRA_CONTAINER::getUsername);
		registry.add("spring.cassandra.password", CASSANDRA_CONTAINER::getPassword);
		registry.add("spring.cassandra.keyspace-name", () -> KEYSPACE_NAME);
		registry.add("spring.cassandra.local-datacenter", CASSANDRA_CONTAINER::getLocalDatacenter);
	}

	@BeforeAll
	static void beforeAll() {
		CASSANDRA_CONTAINER.start();
		var session = CqlSession.builder()
				.withLocalDatacenter(CASSANDRA_CONTAINER.getLocalDatacenter())
				.addContactPoint(InetSocketAddress.createUnresolved(CASSANDRA_CONTAINER.getHost(), CASSANDRA_CONTAINER.getMappedPort(9042)))
				.withAuthCredentials(CASSANDRA_CONTAINER.getUsername(), CASSANDRA_CONTAINER.getPassword())
				.build();
		try (session) {
			session.execute("CREATE KEYSPACE IF NOT EXISTS " + KEYSPACE_NAME +
					" WITH replication = \n" +
					"{'class':'SimpleStrategy','replication_factor':'1'};");
		}
	}

	@Test
	void contextLoads() {

	}

	void testAddCassandra() {

	}
}
