package com.cludus.clugest.services;

import com.cludus.clugest.dtos.RedisAuthCodeReq;
import com.cludus.clugest.dtos.RedisAuthCodeResp;
import com.cludus.clugest.mappers.RedisAuthCodeMapper;
import com.cludus.clugest.repositories.RedisAuthCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Profile("redis")
public class RedisAuthCodeService {
    @Autowired
    private RedisAuthCodeRepository repo;

    @Autowired
    private RedisAuthCodeMapper mapper;

    public RedisAuthCodeResp find(String id) {
        return repo.findById(id)
                .map(mapper::toResp)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "auth code not found"));
    }

    public RedisAuthCodeResp create(RedisAuthCodeReq req) {
        var model = mapper.toModel(req);
        repo.save(model);
        return mapper.toResp(model);
    }
}
