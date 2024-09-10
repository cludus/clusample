package com.cludus.clugest;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.CassandraContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.Neo4jContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.oracle.OracleContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

	@Bean
	@ServiceConnection
	CassandraContainer<?> cassandraContainer() {
		return new CassandraContainer<>(DockerImageName.parse("cassandra:latest"));
	}

	@Bean
	@ServiceConnection
	ElasticsearchContainer elasticsearchContainer() {
		return new ElasticsearchContainer(DockerImageName.parse("docker.elastic.co/elasticsearch/elasticsearch:7.17.10"));
	}

	@Bean
	@ServiceConnection
	KafkaContainer kafkaContainer() {
		return new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));
	}

	@Bean
	@ServiceConnection
	MariaDBContainer<?> mariaDbContainer() {
		return new MariaDBContainer<>(DockerImageName.parse("mariadb:latest"));
	}

	@Bean
	@ServiceConnection
	MongoDBContainer mongoDbContainer() {
		return new MongoDBContainer(DockerImageName.parse("mongo:latest"));
	}

	@Bean
	@ServiceConnection
	MySQLContainer<?> mysqlContainer() {
		return new MySQLContainer<>(DockerImageName.parse("mysql:latest"));
	}

	@Bean
	@ServiceConnection
	Neo4jContainer<?> neo4jContainer() {
		return new Neo4jContainer<>(DockerImageName.parse("neo4j:latest"));
	}

	@Bean
	@ServiceConnection
	OracleContainer oracleFreeContainer() {
		return new OracleContainer(DockerImageName.parse("gvenzl/oracle-free:latest"));
	}

	@Bean
	@ServiceConnection
	PostgreSQLContainer<?> postgresContainer() {
		return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
	}

	@Bean
	@ServiceConnection(name = "redis")
	GenericContainer<?> redisContainer() {
		return new GenericContainer<>(DockerImageName.parse("redis:latest")).withExposedPorts(6379);
	}

	@Bean
	@ServiceConnection
	MSSQLServerContainer<?> sqlServerContainer() {
		return new MSSQLServerContainer<>(DockerImageName.parse("mcr.microsoft.com/mssql/server:latest"))
				.withEnv("ACCEPT_EULA", "Y").withEnv("SA_PASSWORD", "pass");
	}

}
