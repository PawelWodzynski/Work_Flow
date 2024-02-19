package com.workflow.WorkFlowDEMO.api.utils.validation.employee.validators;

import com.workflow.WorkFlowDEMO.data.entity.employee.Employee;
import com.workflow.WorkFlowDEMO.data.entity.employee.Role;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Collection;


// Validation expects ROLE_ADMIN, ROLE_MANAGER , ROLE_EMPLOYEE or ADMIN, MANAGER or EMPLOYEE
public class EmployeeRoleValidationImpl implements ConstraintValidator<EmployeeRoleValidation, Employee> {

    @Override
    public void initialize(EmployeeRoleValidation constraintAnnotation) {
    }


    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext context) {
        boolean isValid = true;

        StringBuilder errorMessage = new StringBuilder();

        Collection<Role> roles = employee.getRoles();
        Role role = roles.iterator().next();
        String roleName = role.getName();



        // Validation condition for minimum size and not null
        if (employee.getRoles() == null) {
            isValid = false;
            errorMessage.append("Role Of Employee Is Required. ");
        } else {
            if  (!"ADMIN".equals(roleName) && !"MANAGER".equals(roleName) && !"EMPLOYEE".equals(roleName) &&
                    !"ROLE_ADMIN".equals(roleName) && !"ROLE_MANAGER".equals(roleName) && !"ROLE_EMPLOYEE".equals(roleName)){

                isValid = false;
                errorMessage.append("Invalid role for employee." +
                        " Role must be either ROLE_ADMIN, or ROLE_MANAGER, or ROLE_EMPLOYEE in uppercase." +
                        " Or you can write either ADMIN, or MANAGER, or EMPLOYEE in uppercase. ");

            }
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMessage.toString()).addPropertyNode("roles").addConstraintViolation();
        }

        return isValid;
    }
}
