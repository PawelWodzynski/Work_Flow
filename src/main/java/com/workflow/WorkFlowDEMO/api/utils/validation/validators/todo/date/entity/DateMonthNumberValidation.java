package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.entity;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DateMonthNumberValidationImpl.class})
public @interface DateMonthNumberValidation {

    String message() default "Month Number validation error ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
