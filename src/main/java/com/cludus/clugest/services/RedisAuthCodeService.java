package com.cludus.clugest.services;

import com.cludus.clugest.controllers.RedisAuthCodeController;
import com.cludus.clugest.dtos.RedisAuthCodeReq;
import com.cludus.clugest.dtos.RedisAuthCodeResp;
import com.cludus.clugest.repositories.N4jEconomicEntityRepository;
import com.cludus.clugest.repositories.RedisAuthCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("redis")
public class RedisAuthCodeService {
    @Autowired
    private RedisAuthCodeRepository repo;

    public RedisAuthCodeResp createCode(RedisAuthCodeReq entity) {
        return null;
    }
}
