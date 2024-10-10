package com.cludus.clugest.repositories;

import com.cludus.clugest.model.RedisAuthCode;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Profile("redis")
public interface RedisAuthCodeRepository extends CrudRepository<RedisAuthCode, String> {
    Optional<RedisAuthCode> findById(String id);
}
