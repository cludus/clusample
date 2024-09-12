package com.cludus.clugest.repositories;

import com.cludus.clugest.model.EsPost;
import org.springframework.context.annotation.Profile;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("elasticsearch")
public interface EsPostRepository extends ElasticsearchRepository<EsPost, String> {

}
