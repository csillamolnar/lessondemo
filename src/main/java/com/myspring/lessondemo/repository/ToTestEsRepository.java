package com.myspring.lessondemo.repository;

import com.myspring.lessondemo.domain.ToTestEsEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToTestEsRepository extends ElasticsearchRepository<ToTestEsEntity, String> {

    ToTestEsEntity findByToTestId(long id);
    //List<ToDoEsEntity> findAll();
    //List<ToDoEsEntity> findAllBy

}