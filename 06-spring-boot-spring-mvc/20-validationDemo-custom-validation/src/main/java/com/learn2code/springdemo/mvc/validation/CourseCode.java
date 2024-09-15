package com.learn2code.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    //Defines Default Course Code
    public  String value() default "LEA";

    //Defines Default Error Messages
    public String message() default "must Start with LEA";

    //Define Defalut Groups
    public Class<?>[] groups() default {};

    //Defines Default payloads
    public Class<? extends Payload>[] payloads() default {};



}
