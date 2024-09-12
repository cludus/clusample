package com.cludus.clugest.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("elasticsearch")
public class EsPostRepository {
}
