package com.workflow.WorkFlowDEMO.api.utils.validation.employee;

import com.workflow.WorkFlowDEMO.data.entity.Employee;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// Implementation of EmployeeValidation annotate
public class EmployeeValidationImpl implements ConstraintValidator<EmployeeValidation, Employee> {



    // initialize validator before start validation process
    @Override
    public void initialize(EmployeeValidation constraintAnnotation) {
    }


    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext context) {
        boolean isValid = true;

        StringBuilder errorMessage = new StringBuilder();

        // validation condition for minimum size and not null
        if (employee.getFirstName() == null || employee.getFirstName().trim().isEmpty()) {
            isValid = false;
            errorMessage.append("First Name Of Employee Is Required. ");
        }

        // validation condition for requirded uppercased first letter
        if (!employee.getFirstName().matches("^[A-Z].*")) {
            isValid = false;
            errorMessage.append("First Character Must Be An Uppercase Letter. ");
        }

        // validation condition for only english letterz without numbers and special characters
        if (!employee.getFirstName().matches("^[A-Za-z]*$")) {
            isValid = false;
            errorMessage.append("Only English Letters Are Allowed, And There Cannot Be Any Special Characters Or Numbers. ");
        }

        // validation condition for whitespaces
        if (employee.getFirstName().contains(" ")) {
            // Warunek spełniony - w ciągu jest przynajmniej jedna spacja
            isValid = false;
            errorMessage.append("The first name cannot contain spaces. ");
        }


        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMessage.toString()).addPropertyNode("firstName").addConstraintViolation();
        }

        return isValid;
    }


}