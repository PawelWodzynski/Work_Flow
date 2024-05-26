package com.workflow.WorkFlowDEMO.data.dto.todo.request;


import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.MonthValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.NotNullIdValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.YearCreatingValidation;


public class AddTodoDateRequestDTO {
    @MonthValidation
    private Integer monthNumber;
    @YearCreatingValidation
    private Integer year;
    @NotNullIdValidation
    private Integer employeeId;

    public AddTodoDateRequestDTO(int monthNumber, int year, int employeeId) {
        this.monthNumber = monthNumber;
        this.year = year;
        this.employeeId = employeeId;
    }

    public Integer getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(Integer monthNumber) {
        this.monthNumber = monthNumber;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
