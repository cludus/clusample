package com.cludus.clugest.mappers;

import com.cludus.clugest.dtos.JpaRealStatePropertyReq;
import com.cludus.clugest.dtos.JpaRealStatePropertyResp;
import com.cludus.clugest.model.JpaRealStateProperty;
import com.cludus.clugest.repositories.JpaPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Profile("jpa")
@Service
public class JpaRealStatePropertyMapper {

    @Autowired
    private JpaPersonRepository personRepo;

    public JpaRealStatePropertyResp toResp(JpaRealStateProperty model) {
        return JpaRealStatePropertyResp.builder()
                .id(model.getId())
                .build();
    }

    public JpaRealStateProperty toModel(JpaRealStatePropertyReq req) {
        var person = personRepo.findById(req.getPersonId());
        if(person.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "person not found");
        }
        return JpaRealStateProperty.builder()
                .id(req.getId())
                .address1(req.getAddress1())
                .address2(req.getAddress2())
                .description(req.getDescription())
                .person(person.get())
                .build();
    }
}
