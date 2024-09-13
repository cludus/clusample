package com.cludus.clugest.repositories;

import com.cludus.clugest.model.JpaPerson;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("jpa")
public interface JpaPersonRepository extends CrudRepository<JpaPerson, Long> {
}
