package com.vone.javarest.service;

import org.springframework.http.ResponseEntity;

import com.vone.javarest.entity.SciUserEntity;

public interface CreateUserService {
    public ResponseEntity<?> createUser(SciUserEntity userData);
}
