package com.vone.javarest.service;

import java.util.List;
import java.util.Optional;

import com.vone.javarest.entity.CommentEntity;

public interface CommentService {
    List<CommentEntity> getAllThreadComments(Long threadId);
    Optional<CommentEntity> getCommentById(Long id);
    CommentEntity postComment(CommentEntity commentEntity);
    CommentEntity updateComment(CommentEntity commentEntity);
    void deleteComment(Long id);
}

