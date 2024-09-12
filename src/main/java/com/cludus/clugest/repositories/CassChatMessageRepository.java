package com.cludus.clugest.repositories;

import com.cludus.clugest.model.CassChatMessage;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Optional;

@Profile("cassandra")
public interface CassChatMessageRepository extends CassandraRepository<CassChatMessage, String> {
    Optional<CassChatMessage> findById(String id);
}
