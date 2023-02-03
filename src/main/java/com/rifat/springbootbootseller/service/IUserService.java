package com.rifat.springbootbootseller.service;

import com.rifat.springbootbootseller.model.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUserName(String username);

    void makeAdmin(String username);
}
