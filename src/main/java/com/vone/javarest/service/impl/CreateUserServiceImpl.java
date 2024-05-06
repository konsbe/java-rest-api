package com.vone.javarest.service.impl;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import com.vone.javarest.entity.SciUserEntity;
import com.vone.javarest.repository.UserRepository;
import com.vone.javarest.service.CreateUserService;
import com.vone.javarest.utils.ErrorResponse;

@Service
public class CreateUserServiceImpl implements CreateUserService {

    @Autowired
    private final UserRepository userRepository;

    public CreateUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @SuppressWarnings("null")
    @Override
    public ResponseEntity<?> createUser(SciUserEntity sci_user_ent) {

        try {
            // save user information in our database
            userRepository.save(sci_user_ent);
            return new ResponseEntity<>(sci_user_ent, HttpStatus.OK);

        } catch (HttpClientErrorException e) {
            ErrorResponse error = new ErrorResponse(
                    OffsetDateTime.now(),
                    e.getStatusCode().toString(),
                    e.toString(),
                    "/api/keycloak-service/signup");
            return new ResponseEntity<>(error, e.getStatusCode());
        }
    }

}
