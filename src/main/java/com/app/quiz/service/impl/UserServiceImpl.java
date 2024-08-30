package com.app.quiz.service.impl;

import com.app.quiz.model.user.User;
import com.app.quiz.repository.UserRepository;
import com.app.quiz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<User> saveUser(User user) {
        return userRepository.save(user).log();
    }

    @Override
    public Flux<User> getAllUsers() {
        return userRepository.findAll().log();
    }
}
