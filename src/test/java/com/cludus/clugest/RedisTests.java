package com.cludus.clugest;

import com.cludus.clugest.dtos.RedisAuthCodeReq;
import com.cludus.clugest.dtos.RedisAuthCodeResp;
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
	void createCode() {
        var req = RedisAuthCodeReq.builder()
                .code("1234")
                .userId("1")
                .build();
        var createResult = rest.postForEntity("/redis/auth-code", req, RedisAuthCodeResp.class);
        Assertions.assertThat(createResult.getStatusCode().is2xxSuccessful()).isTrue();

		var getResult = rest.getForEntity("/redis/auth-code/" + createResult.getBody().getId(), RedisAuthCodeResp.class);
		Assertions.assertThat(getResult.getStatusCode().is2xxSuccessful()).isTrue();
	}
}
