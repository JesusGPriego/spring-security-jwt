package com.suleware.springboot.security.springboot_security.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistByUsernameValidation.class)
public @interface ExistByUsername {
    String message() default "{ExistByUsername.user.username}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
