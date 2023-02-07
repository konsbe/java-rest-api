package com.vone.javarest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.vone.javarest.entity.CommentEntity;
import com.vone.javarest.repository.CommentRepositrory;
import com.vone.javarest.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private final CommentRepositrory commentRepository;

    public CommentServiceImpl(CommentRepositrory commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    @Query("select * from \"mt-comments\" where mt where mt.c_thread_id LIKE %?1%")
    public List<CommentEntity> getAllThreadComments(Long threadId) {
        return commentRepository.findBycThreadId(threadId);
    }

    @Override
    public Optional<CommentEntity> getCommentById(Long commentId) {
        return commentRepository.findById(commentId);
    }

    @Override
    public CommentEntity postComment(CommentEntity commentEntity) {
        return commentRepository.save(commentEntity);
    }
    
    @Override
    public CommentEntity updateComment(CommentEntity commentEntity) {
        return commentRepository.save(commentEntity);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);        
    }
    
}
