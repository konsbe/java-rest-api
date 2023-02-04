package com.vone.javarest.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value="/threads")
public class ThreadController {

    @Autowired
    private final ThreadService threadService;

    public ThreadController(ThreadService threadService) {
        this.threadService = threadService;
    }

    @GetMapping
    public ResponseEntity<List<ThreadEntity>> getAllThreads(){
        return new ResponseEntity<>(threadService.getAllThreads(), HttpStatus.OK);
    } 

    @PostMapping
    public ResponseEntity<ThreadEntity> postThread(@RequestBody ThreadEntity threadEntity) {
        return new ResponseEntity<>(threadService.postThread(threadEntity), HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<ThreadEntity>> getThreadById(@PathVariable("id") final Long id){
        return new ResponseEntity<>(threadService.getThreadById(id), HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<ThreadEntity> updateThread(@RequestBody ThreadEntity threadEntity) {
        return new ResponseEntity<>(threadService.updateThread(threadEntity), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteThread(@PathVariable("id") Long id) {
        threadService.deleteThread(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
