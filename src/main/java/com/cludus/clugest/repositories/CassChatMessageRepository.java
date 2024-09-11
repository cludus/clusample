package com.cludus.clugest.repositories;

import org.springframework.context.annotation.Profile;

@Profile("cassandra")
public interface CassChatMessageRepository {
}
