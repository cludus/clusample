package com.cludus.clugest.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.neo4j.Neo4jAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@EnableAutoConfiguration(exclude = {Neo4jAutoConfiguration.class, Neo4jDataAutoConfiguration.class})
@Profile("!neo4j")
public class NoNeo4jConfig {

}
