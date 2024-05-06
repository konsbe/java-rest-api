package com.vone.javarest.service.impl;

import java.time.OffsetDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateUserServiceImpl.class);

    @SuppressWarnings("null")
    @Override
    @RabbitListener(queues = { "${rabbitmq.queue.name}" })
    public void createUser(SciUserEntity sci_user_ent) {
        try {

            LOGGER.info("User get --> {}", sci_user_ent.getEmail());
            // save user information in our database
            userRepository.save(sci_user_ent);

        } catch (HttpClientErrorException e) {
            ErrorResponse error = new ErrorResponse(OffsetDateTime.now(), e.getStatusCode().toString(), e.toString(),
                    "/api/keycloak-service/signup");
            LOGGER.info("Error User get --> {}", error.toString());

        }

    }

}
