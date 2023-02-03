package com.rifat.springbootbootseller.service;


import com.rifat.springbootbootseller.model.Role;
import com.rifat.springbootbootseller.model.User;
import com.rifat.springbootbootseller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreatedAt(LocalDateTime.now());

        return   userRepository.save(user);

    }

    @Override
    public Optional<User> findByUserName(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    @Transactional
    public void makeAdmin(String username) {
        userRepository.updateUserRole(username,Role.ADMIN);
    }
}
