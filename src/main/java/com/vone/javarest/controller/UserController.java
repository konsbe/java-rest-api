package com.vone.javarest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vone.javarest.entity.SciUserEntity;
import com.vone.javarest.entity.UserFindRequestParamsEntity;
import com.vone.javarest.service.CreateUserService;
import com.vone.javarest.service.GetUserInfoService;

@RestController
@RequestMapping(value = "/user-info")
public class UserController {

    @Autowired
    private final GetUserInfoService getUserInfoService;
    @Autowired
    private final CreateUserService createUserService;

    public UserController(GetUserInfoService getUserInfoService, CreateUserService createUserService) {
        this.getUserInfoService = getUserInfoService;
        this.createUserService = createUserService;
    }

    @GetMapping
    public ResponseEntity<?> getUserByEmail(
            @RequestBody UserFindRequestParamsEntity userFindRequestParamsEntity) {
        return new ResponseEntity<>(getUserInfoService.getUserInfo(userFindRequestParamsEntity.getEmail()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody SciUserEntity userData) {
        return new ResponseEntity<>(createUserService.createUser(userData), HttpStatus.OK);
    }

}
