package com.vone.javarest.repository;

// import java.util.ArrayList;
// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vone.javarest.entity.ThreadEntity;

@Repository
public interface ThreadRepositrory extends JpaRepository<ThreadEntity, Long> {


    // List<ThreadEntity> getAllThreads();
    // ThreadEntity getById(Long id);
    // ThreadEntity postThread(ThreadEntity threadEntity);
    // ThreadEntity updateThread(ThreadEntity threadEntity);
    // void deleteThread(Long id);
    
}
