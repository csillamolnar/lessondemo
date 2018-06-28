package com.myspring.lessondemo.repository;
import com.myspring.lessondemo.domain.ToTestEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.myspring.lessondemo.domain.ToDoEsEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoEsRepository extends ElasticsearchRepository<ToDoEsEntity, String> {

	ToDoEsEntity findByToDoId(long id);
	//List<ToDoEsEntity> findAll();
	//List<ToDoEsEntity> findAllBy

}

