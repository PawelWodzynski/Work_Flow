package com.workflow.WorkFlowDEMO.data.entity.todo;


import com.workflow.WorkFlowDEMO.data.entity.employee.Employee;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "todo_date")
public class TodoDate {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private String date;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "todo_date_id")
    private List<TodoPoint> todoPoints;



    public TodoDate(){}

    public TodoDate(String date){
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @Override
    public String toString() {
        return "TodoDate{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", employee=" + employee +
                '}';
    }
}
