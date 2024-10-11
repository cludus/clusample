package com.cludus.clugest;

import com.cludus.clugest.dtos.MgoProductDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("mongodb")
class MongodbTests {
    private static final String DB_NAME = "clugest_products";

    @Autowired
    private TestRestTemplate rest;

    @Container
    private static final GenericContainer<MongoDBContainer> CONTAINER = new MongoDBContainer(
        DockerImageName.parse("mongo:latest"))
        .withExposedPorts(27017)
        .withEnv("MONGO_INITDB_DATABASE", DB_NAME);

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        CONTAINER.start();
        String connUri = String.format(
            "mongodb://%s:%d/%s", CONTAINER.getHost(), CONTAINER.getMappedPort(27017), DB_NAME);
        registry.add("spring.data.mongodb.uri", () -> connUri);
        registry.add("spring.data.mongodb.username", () -> "admin");
        registry.add("spring.data.mongodb.password", () -> "admin");
    }

    @AfterAll
    static void afterAll() {
        CONTAINER.stop();
    }

    @Test
    void doTest() {
        var req = MgoProductDto.builder().name("product").build();
        var result = rest.postForEntity("/mongo/product", req, MgoProductDto.class);
        Assertions.assertThat(result.getStatusCode().is2xxSuccessful()).isTrue();
    }
}
