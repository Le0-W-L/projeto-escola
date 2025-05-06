package com.example.projetoescola.configs.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = SenhasIguaisConstraint.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SenhasIguaisValidation {
    String message() default "As senhas não coincidem.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}