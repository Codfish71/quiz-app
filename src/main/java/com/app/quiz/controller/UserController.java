package com.app.quiz.controller;

import com.app.quiz.model.user.User;
import com.app.quiz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthCheckController() {
        return new ResponseEntity<>("HealthCheck Successful", HttpStatus.OK);
    }

    @PostMapping("/saveUser")
    public Mono<User> createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping(path = "/getallusers", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
