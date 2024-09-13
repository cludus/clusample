package com.cludus.clugest.repositories;

import com.cludus.clugest.model.JpaRealStateProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("jpa")
public interface JpaRealStatePropertyRepository extends CrudRepository<JpaRealStateProperty, Long> {
}
