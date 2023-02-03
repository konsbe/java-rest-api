package com.vone.javarest.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vone.javarest.entity.ThreadEntity;
import com.vone.javarest.service.ThreadService;

@RestController
@RequestMapping("/threads")
public class ThreadController {

    @Autowired
    private final ThreadService threadService;

    public ThreadController(ThreadService threadService) {
        this.threadService = threadService;
    }

    @GetMapping
    public List<ThreadEntity> getAllThreads(){
        return threadService.getAllThreads();
    } 

    @PostMapping
    public ThreadEntity postThread(@RequestBody ThreadEntity threadEntity) {
        return threadService.postThread(threadEntity);
    }
    
    @GetMapping("/find/{id}")
    public Optional<ThreadEntity> getThreadById(@PathVariable("id") final Long id){
        return threadService.getThreadById(id);
    }
    
    
    @PutMapping
    public ThreadEntity updateThread(@RequestBody ThreadEntity threadEntity) {
        return threadService.updateThread(threadEntity);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteThread(@PathVariable("id") Long id) {
        threadService.deleteThread(id);
    }
}
