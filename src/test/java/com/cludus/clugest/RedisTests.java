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
@ActiveProfiles("redis")
class RedisTests {

    private RestTemplate rest = new RestTemplate();

    @Value("${server.port}")
    private int serverPort;

	@Container
	private static final GenericContainer<?> CONTAINER =
                    new GenericContainer<>(DockerImageName.parse("redis:latest"))
                        .withExposedPorts(6379);;

	@DynamicPropertySource
	static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.data.redis.host", CONTAINER::getHost);
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
