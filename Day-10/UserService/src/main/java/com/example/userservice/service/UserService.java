package com.example.userservice.service;

import com.example.userservice.model.User;
import com.example.userservice.model.UserRequest;
import com.example.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final KafkaProducerService kafkaProducerService;

    public UserService(UserRepository userRepository,
                       KafkaProducerService kafkaProducerService) {
        this.userRepository = userRepository;
        this.kafkaProducerService = kafkaProducerService;
    }

    // CREATE USER + SEND EVENT
    public User createUser(UserRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        User savedUser = userRepository.save(user);

        // 🔥 Send event to Kafka
        kafkaProducerService.sendUserCreatedEvent(savedUser.toString());

        return savedUser;
    }

    // GET ALL USERS
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET USER BY ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // UPDATE USER
    public Optional<User> updateUser(Long id, UserRequest request) {
        return userRepository.findById(id).map(user -> {
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            return userRepository.save(user);
        });
    }

    // DELETE USER
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}