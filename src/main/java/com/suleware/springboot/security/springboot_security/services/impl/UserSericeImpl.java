package com.suleware.springboot.security.springboot_security.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suleware.springboot.security.springboot_security.entities.Role;
import com.suleware.springboot.security.springboot_security.entities.User;
import com.suleware.springboot.security.springboot_security.entities.enums.RoleType;
import com.suleware.springboot.security.springboot_security.repositories.RoleRepository;
import com.suleware.springboot.security.springboot_security.repositories.UserRepository;
import com.suleware.springboot.security.springboot_security.services.UserService;

@Service
public class UserSericeImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserSericeImpl(UserRepository userRepository, RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        Optional<Role> oRole = roleRepository.findByName(RoleType.ROLE_USER.toString());
        List<Role> roles = new ArrayList<>();
        oRole.ifPresent(roles::add);
        if (user.isAdmin()) {
            Optional<Role> oRoleAdmin = roleRepository.findByName(RoleType.ROLE_ADMIN.toString());
            oRoleAdmin.ifPresent(roles::add);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

}
