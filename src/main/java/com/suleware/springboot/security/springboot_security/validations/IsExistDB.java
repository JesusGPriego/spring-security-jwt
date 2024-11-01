package com.suleware.springboot.security.springboot_security.validations;

import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = IsExistsDBValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsExistDB {
    String message() default "Product already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
