package com.vone.javarest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vone.javarest.entity.ThreadEntity;
import com.vone.javarest.repository.ThreadRepositrory;
import com.vone.javarest.service.ThreadService;

@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    private final ThreadRepositrory threadRepositrory;

    public ThreadServiceImpl(ThreadRepositrory threadRepositrory){
        this.threadRepositrory = threadRepositrory;
    }
    @Override
    public List<ThreadEntity> getAllThreads() {
        return  threadRepositrory.findAll();
    }

    
    @Override
    public Optional<ThreadEntity> getThreadById(Long id) {
        return threadRepositrory.findById(id);
    }
    
    @Override
    public ThreadEntity postThread(ThreadEntity threadEntity) {
        return  threadRepositrory.save(threadEntity);
    }

    @Override
    public ThreadEntity updateThread(ThreadEntity threadEntity) {
        return  threadRepositrory.save(threadEntity);
    }
    
    @Override
    public void deleteThread(Long id) {
         threadRepositrory.deleteById(id);
    }

    
    
}
