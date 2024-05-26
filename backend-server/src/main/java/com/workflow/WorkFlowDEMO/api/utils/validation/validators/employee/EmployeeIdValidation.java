package com.workflow.WorkFlowDEMO.api.utils.validation.validators.employee;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmployeeIdValidationImpl.class})
@Documented
public @interface EmployeeIdValidation {

    String message() default "ID validation error ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
