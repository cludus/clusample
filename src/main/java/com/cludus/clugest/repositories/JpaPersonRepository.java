package com.cludus.clugest.repositories;

import com.cludus.clugest.model.JpaPerson;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jpa")
public interface JpaPersonRepository extends JpaRepository<JpaPerson, Long> {
}
