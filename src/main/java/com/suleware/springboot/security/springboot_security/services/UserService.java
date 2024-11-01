package com.suleware.springboot.security.springboot_security.services;

import java.util.List;

import com.suleware.springboot.security.springboot_security.entities.User;

public interface UserService {
    List<User> findAll();

    User save(User user);

}
