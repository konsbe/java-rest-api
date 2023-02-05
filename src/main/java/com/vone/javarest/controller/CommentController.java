package com.vone.javarest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vone.javarest.service.CommentService;

@RestController
@RequestMapping(value="/comments")
public class CommentController {
    
    @Autowired
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    
}
