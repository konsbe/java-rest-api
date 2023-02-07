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

import com.vone.javarest.entity.CommentEntity;
import com.vone.javarest.service.CommentService;

@RestController
@RequestMapping(value="/comments")
public class CommentController {
    
    @Autowired
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    
    @GetMapping("/thread/{threadId}")
    public ResponseEntity<List<CommentEntity>>  getAllThreadComments(@PathVariable final Long threadId){
        return new ResponseEntity<>(commentService.getAllThreadComments(threadId), HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<Optional<CommentEntity>>  getCommentById(@PathVariable("commentId") final Long id){
        return new ResponseEntity<>(commentService.getCommentById(id), HttpStatus.OK);
    }


    @PostMapping("/{threadId}")
    public ResponseEntity<CommentEntity> postComment(@PathVariable("threadId") final Long id, @RequestBody CommentEntity commentEntity) {
        return new ResponseEntity<>(commentService.postComment(commentEntity),HttpStatus.OK);
    }

    @PutMapping("/{threadId}")
    public ResponseEntity<CommentEntity> updateComment(@PathVariable("threadId") final Long id, @RequestBody CommentEntity commentEntity) {
        return new ResponseEntity<>(commentService.updateComment(commentEntity),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{threadId}")
    public ResponseEntity<CommentEntity> deleteComment(@PathVariable("threadId") final Long commentID) {
        commentService.deleteComment(commentID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
