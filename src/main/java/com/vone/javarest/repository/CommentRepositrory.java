package com.vone.javarest.repository;

import java.util.List;

// import java.util.ArrayList;
// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vone.javarest.entity.CommentEntity;

@Repository
public interface CommentRepositrory extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findBycThreadId(Long iterable);
    
}
