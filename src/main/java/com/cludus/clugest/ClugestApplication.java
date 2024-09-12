package com.cludus.clugest;

import com.cludus.clugest.model.CassChatMessage;
import com.cludus.clugest.repositories.CassChatMessageRepository;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.internal.core.metadata.DefaultEndPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;

import java.net.InetSocketAddress;

@Slf4j
@SpringBootApplication
public class ClugestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClugestApplication.class, args);
	}

}
