package com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.entity;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DateYearValidationImpl.class})
public @interface DateYearValidation {

    String message() default "Year validation error ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
