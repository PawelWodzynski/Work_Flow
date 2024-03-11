package com.workflow.WorkFlowDEMO.data.entity.todo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.entity.DateEmployeeIdValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.entity.DateIdValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.entity.DateMonthNumberValidation;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.todo.date.entity.DateYearValidation;
import com.workflow.WorkFlowDEMO.data.entity.employee.Employee;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "todo_date")
@DateIdValidation
@DateMonthNumberValidation
@DateYearValidation
@DateEmployeeIdValidation
public class TodoDate {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "month_number")
    private Integer monthNumber;

    @Column(name = "year")
    private Integer year;

    @Column(name = "employee_id")
    private Integer employeeId;

    @JsonIgnore
    @ManyToOne( fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "todo_date_id")
    private List<TodoPoint> todoPoints;



    public TodoDate(){}

    public TodoDate(int monthNumber, int year) {
        this.monthNumber = monthNumber;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<TodoPoint> getTodoPoints() {
        return todoPoints;
    }

    public void setTodoPoints(List<TodoPoint> todoPoints) {
        this.todoPoints = todoPoints;
    }

    public void addTodoPoint(TodoPoint thePoint){
        if (todoPoints == null){
            todoPoints = new ArrayList<>();
        }

        todoPoints.add(thePoint);
    }


}
