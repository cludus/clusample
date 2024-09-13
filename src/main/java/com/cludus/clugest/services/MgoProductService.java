package com.cludus.clugest.services;

import com.cludus.clugest.repositories.MgoProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("mongodb")
public class MgoProductService {
    @Autowired
    private MgoProductRepository repo;
}
