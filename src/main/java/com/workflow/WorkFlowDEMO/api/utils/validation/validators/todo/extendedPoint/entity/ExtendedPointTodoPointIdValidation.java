package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.extendedPoint.entity;


import com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.point.dto.PointRequestDtoTodoContentValidationImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ExtendedPointTodoPointIdValidationImpl.class})
public @interface ExtendedPointTodoPointIdValidation {
    String message() default "To Do Point ID validation error ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
