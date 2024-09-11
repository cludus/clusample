package com.cludus.clugest.repositories;

import com.cludus.clugest.model.JpaRealStateProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jpa")
public interface JpaRealStatePropertyRepository extends JpaRepository<JpaRealStateProperty, Long> {
}
