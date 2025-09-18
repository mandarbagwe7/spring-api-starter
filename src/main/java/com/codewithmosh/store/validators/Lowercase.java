package com.codewithmosh.store.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {LowercaseValidator.class})
public @interface Lowercase {
    public String message() default "must be in lowercase";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
