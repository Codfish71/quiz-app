package com.app.quiz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthCheckController() {
        return new ResponseEntity<>("HealthCheck Successful", HttpStatus.OK);
    }
}
