package com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations;


import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations.MonthValidationImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MonthValidationImpl.class)
public @interface MonthValidation {
    String message() default "Month Validation Error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
