package com.cludus.clugest;

import com.cludus.clugest.dtos.CassChatMessageReq;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@ActiveProfiles("redis")
class RedisTests {

    @Autowired
    private TestRestTemplate rest;

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
        var result = rest.postForEntity("/redis/auth-code", "", String.class);
        Assertions.assertThat(result.getStatusCode().is2xxSuccessful()).isTrue();
	}
}
