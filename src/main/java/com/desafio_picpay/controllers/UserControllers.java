package com.desafio_picpay.controllers;

import com.desafio_picpay.domain.user.User;
import com.desafio_picpay.dtos.UserDTO;
import com.desafio_picpay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserControllers {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(UserDTO user){

        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }
}
