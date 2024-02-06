package com.workflow.WorkFlowDEMO.api.utils.validation.employee.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmployeeRoleValidationImpl.class})
@Documented
public @interface EmployeeRoleValidation {

    String message() default "Role Validation Error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
