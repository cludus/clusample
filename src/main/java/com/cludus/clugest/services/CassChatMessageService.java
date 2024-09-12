package com.cludus.clugest.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Profile("cassandra")
public class CassChatMessageService {
}
