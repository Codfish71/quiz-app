package com.app.quiz.service;

import com.app.quiz.model.user.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {

    Mono<User> saveUser(User user);

    Flux<User> getAllUsers();
}
