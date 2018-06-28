package com.myspring.lessondemo.repository;

import com.myspring.lessondemo.domain.ToDoEntity;
import com.myspring.lessondemo.domain.ToTestEntity;
import com.myspring.lessondemo.domain.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ToTestRepository extends JpaRepository<ToTestEntity, Long> {
	
}
