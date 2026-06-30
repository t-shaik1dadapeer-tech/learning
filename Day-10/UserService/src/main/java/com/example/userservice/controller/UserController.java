package com.example.userservice.controller;

import com.example.userservice.model.User;
import com.example.userservice.model.UserRequest;
import com.example.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE USER
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest request) {
        logger.info("Received request to create user: {}",request.getEmail());
        return ResponseEntity.status(201).body(userService.createUser(request));
    }

    // GET ALL USERS
    @GetMapping
    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return userService.getAllUsers();
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestBody UserRequest request) {
        logger.info("updating user with id:{}",id);
        return userService.updateUser(id, request).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        logger.info("Deleting user with id:{}",id);
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}