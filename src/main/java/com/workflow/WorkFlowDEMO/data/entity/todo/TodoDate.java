package com.workflow.WorkFlowDEMO.data.entity.todo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workflow.WorkFlowDEMO.data.entity.employee.Employee;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "todo_date")
public class TodoDate {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mounth_number")
    private int mounthNumber;

    @Column(name = "year")
    private int year;

    @Column(name = "employee_id")
    private int employeeId;

    @JsonIgnore
    @ManyToOne( fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "todo_date_id")
    private List<TodoPoint> todoPoints;



    public TodoDate(){}

    public TodoDate(int mounthNumber, int year) {
        this.mounthNumber = mounthNumber;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMounthNumber() {
        return mounthNumber;
    }

    public void setMounthNumber(int mounthNumber) {
        this.mounthNumber = mounthNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
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
