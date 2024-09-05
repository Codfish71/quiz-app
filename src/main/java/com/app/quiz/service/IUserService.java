package com.app.quiz.service;

import com.app.quiz.model.user.User;

import java.util.List;

public interface IUserService {

    User saveUser(User user);

    List<User> getAllUsers();
}
