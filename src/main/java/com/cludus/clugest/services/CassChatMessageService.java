package com.cludus.clugest.services;

import com.cludus.clugest.repositories.CassChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("cassandra")
public class CassChatMessageService {
    @Autowired
    private CassChatMessageRepository repo;
}
