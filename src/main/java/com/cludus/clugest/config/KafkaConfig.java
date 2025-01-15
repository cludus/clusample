package com.cludus.clugest.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Profile("kafka")
@Configuration
@EnableKafka
public class KafkaConfig {
    @Bean
    public NewTopic playEventTopic() {
        return TopicBuilder.name("play_event")
                .partitions(10)
                .replicas(1)
                .compact()
                .build();
    }
}
