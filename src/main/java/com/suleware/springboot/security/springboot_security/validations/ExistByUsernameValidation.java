package com.suleware.springboot.security.springboot_security.validations;

import org.springframework.stereotype.Component;

import com.suleware.springboot.security.springboot_security.services.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExistByUsernameValidation implements ConstraintValidator<ExistByUsername, String> {

    private UserService userService;

    public ExistByUsernameValidation(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return !userService.existByUsername(username);
    }

}
