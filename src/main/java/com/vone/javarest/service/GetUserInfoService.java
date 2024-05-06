package com.vone.javarest.service;

import org.springframework.http.ResponseEntity;

public interface GetUserInfoService {
    public ResponseEntity<?> getUserInfo(String userName);
}
