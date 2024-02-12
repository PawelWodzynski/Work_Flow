package com.workflow.WorkFlowDEMO.api.utils.validation.employee.validators;

import com.workflow.WorkFlowDEMO.data.entity.Employee;
import com.workflow.WorkFlowDEMO.data.entity.Role;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Collection;

public class EmployeeRoleValidationImpl implements ConstraintValidator<EmployeeRoleValidation, Employee> {

    @Override
    public void initialize(EmployeeRoleValidation constraintAnnotation) {
    }


    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext context) {
        boolean isValid = true;

        StringBuilder errorMessage = new StringBuilder();

        // Validation condition for minimum size and not null
        if (employee.getRoles() == null) {
            isValid = false;
            errorMessage.append("Role Of Employee Is Required. ");
        } else {
            if (employee.getRoles() == null ||
                    !rolesToString(employee.getRoles()).toUpperCase().contains("ADMIN") &&
                            !rolesToString(employee.getRoles()).toUpperCase().contains("MANAGER") &&
                            !rolesToString(employee.getRoles()).toUpperCase().contains("EMPLOYEE")) {
                isValid = false;
                errorMessage.append("Invalid role for employee. ");
            }
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMessage.toString()).addPropertyNode("roles").addConstraintViolation();
        }

        return isValid;
    }



    // Method to convert collection to string
    private String rolesToString(Collection<Role> roles) {
        StringBuilder result = new StringBuilder();

        for (Role role : roles) {
            result.append(role.toString()).append(",");
        }

        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1); // Remove the last comma
        }

        return result.toString();
    }


}
