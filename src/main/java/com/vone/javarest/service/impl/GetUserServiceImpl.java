package com.vone.javarest.service.impl;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.databind.JsonNode;
import com.vone.javarest.entity.SciUserEntity;
import com.vone.javarest.repository.UserRepository;
import com.vone.javarest.service.GetUserInfoService;
import com.vone.javarest.utils.ErrorResponse;
import com.vone.javarest.utils.ObjectKey;

@Service
public class GetUserServiceImpl implements GetUserInfoService {
    @Autowired
    private ObjectKey objKey;
    @Autowired
    private final UserRepository userRepository;

    public GetUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @SuppressWarnings("null")
    @Override
    public ResponseEntity<?> getUserInfo(String username) {

        try {
            // save user information in our database

                SciUserEntity sciUserEntity = userRepository.findByEmail(username);
                String jsonSciUserEntity = objKey.createObject(sciUserEntity);
                JsonNode sciUserJSONObject = objKey.createJSONObject(jsonSciUserEntity);
                
                ResponseEntity<?> combinedResponseEntity = new ResponseEntity<>(sciUserJSONObject,
                HttpStatus.OK);

                return combinedResponseEntity;

        } catch (HttpClientErrorException e) {
            ErrorResponse error = new ErrorResponse(OffsetDateTime.now(), e.getStatusCode().toString(), e.toString(),
                    "/api/keycloak-service/signup");
            return new ResponseEntity<>(error, e.getStatusCode());
        }
    }

}
