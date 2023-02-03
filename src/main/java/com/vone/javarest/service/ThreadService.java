package com.vone.javarest.service;

import java.util.List;
import java.util.Optional;

import com.vone.javarest.entity.ThreadEntity;

public interface ThreadService {
    List<ThreadEntity> getAllThreads();
    Optional<ThreadEntity> getThreadById(Long id);
    ThreadEntity postThread(ThreadEntity threadEntity);
    ThreadEntity updateThread(ThreadEntity threadEntity);
    void deleteThread(Long id);
}
