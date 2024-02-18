package com.workflow.WorkFlowDEMO.api.utils.validation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ValidationService {

    @Autowired
    Validator validator;

    public Map<String,String> validateObject(Object object, String objectName){
        // Creates a BindingResult object to collect validation results
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(object, objectName);
        // Invokes employee validation
        validator.validate(object, result);
        // Collects validation errors and returns them as a map
        return result.getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }

}
