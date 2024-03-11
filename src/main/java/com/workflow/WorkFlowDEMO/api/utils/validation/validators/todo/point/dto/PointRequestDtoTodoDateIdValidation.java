package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.point.dto;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PointRequestDtoTodoDateIdValidationImpl.class})
public @interface PointRequestDtoTodoDateIdValidation {
    String message() default "To Do Date ID validation error ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
