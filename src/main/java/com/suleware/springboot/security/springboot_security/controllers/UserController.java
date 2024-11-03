package com.suleware.springboot.security.springboot_security.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suleware.springboot.security.springboot_security.entities.User;
import com.suleware.springboot.security.springboot_security.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService uService;

    public UserController(UserService uService) {
        this.uService = uService;
    }

    @GetMapping
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok().body(uService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<User> create(@Valid @RequestBody User user) {

        return ResponseEntity.status(HttpStatus.CREATED).body(uService.save(user));
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user) {
        user.setAdmin(false);
        return create(user);
    }

}
