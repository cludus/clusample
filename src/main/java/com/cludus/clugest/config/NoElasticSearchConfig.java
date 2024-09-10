package com.cludus.clugest.config;

import org.springframework.boot.actuate.autoconfigure.data.elasticsearch.ElasticsearchReactiveHealthContributorAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchClientAutoConfiguration;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchRestClientAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;


@Configuration
@EnableAutoConfiguration(exclude = {ElasticsearchClientAutoConfiguration.class, ElasticsearchDataAutoConfiguration.class,
        ElasticsearchReactiveHealthContributorAutoConfiguration.class, ElasticsearchRestClientAutoConfiguration.class, ElasticsearchRepositoriesAutoConfiguration.class})
@Profile("!elasticsearch")
public class NoElasticSearchConfig {

}
