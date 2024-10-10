package com.cludus.clugest.services;

import com.cludus.clugest.dtos.AcknowledgedResp;
import com.cludus.clugest.dtos.JpaPersonReq;
import com.cludus.clugest.dtos.JpaPersonResp;
import com.cludus.clugest.dtos.PageReq;
import com.cludus.clugest.mappers.EsPostMapper;
import com.cludus.clugest.mappers.JpaPersonMapper;
import com.cludus.clugest.repositories.JpaPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class JpaPersonService {
    @Autowired
    private JpaPersonRepository repo;

    @Autowired
    private JpaPersonMapper mapper;

    public JpaPersonResp findAll(PageReq page) {
        return null;
    }

    public JpaPersonResp find(long id) {
        return null;
    }

    public JpaPersonResp create(JpaPersonReq person) {
        return null;
    }

    public JpaPersonResp update(long id, JpaPersonReq person) {
        return null;
    }

    public AcknowledgedResp delete(long id) {
        return null;
    }
}
