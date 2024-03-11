package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.entity;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DateIdValidationImpl.class})
public @interface DateIdValidation {

    String message() default "ID validation error ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
