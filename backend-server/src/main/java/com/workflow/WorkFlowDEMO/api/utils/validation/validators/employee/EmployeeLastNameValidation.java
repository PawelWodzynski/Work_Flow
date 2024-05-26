package com.workflow.WorkFlowDEMO.api.utils.validation.validators.employee;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmployeeLastNameValidationImpl.class})
@Documented
public @interface EmployeeLastNameValidation {

    String message() default "Last Name Validation Error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
