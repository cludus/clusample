package com.cludus.clugest.services;

import com.cludus.clugest.dtos.*;
import com.cludus.clugest.repositories.JpaRealStatePropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class JpaRealStatePropertyService {
    @Autowired
    private JpaRealStatePropertyRepository repo;

    public JpaRealStatePropertyResp findAll(PageReq page) {
        return null;
    }

    public JpaRealStatePropertyResp find(long id) {
        return null;
    }

    public JpaRealStatePropertyResp create(JpaRealStatePropertyReq property) {
        return null;
    }

    public JpaRealStatePropertyResp update(long id, JpaRealStatePropertyReq property) {
        return null;
    }

    public AcknowledgedResp delete(long id) {
        return null;
    }
}
