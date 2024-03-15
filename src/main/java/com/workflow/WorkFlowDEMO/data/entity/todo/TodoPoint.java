package com.workflow.WorkFlowDEMO.data.entity.todo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "todo_point")
public class TodoPoint {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NullAccessIdValidation
    private int id;
    @ContentValidation
    @Column(name = "content")
    private String content;
    @NumberValidation
    @Column(name = "point_order")
    private Integer pointOrder;
    @NumberValidation
    @Column(name = "from_day_number")
    private Integer fromDayNumber;
    @NumberValidation
    @Column(name = "to_day_number")
    private Integer toDayNumber;
    @BooleanValidation
    @Column(name = "completed")
    private Boolean completed;
    @NotNullIdValidation
    @Column(name = "todo_date_id")
    private Integer todoDateId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "todo_date_id", insertable = false, updatable = false)
    private TodoDate todoDate;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "todo_point_id")
    private List<TodoExtendedPoint> todoExtendedPoints;

    public TodoPoint(){}

    public TodoPoint(String content, int pointOrder, int fromDayNumber, int toDayNumber, Boolean completed) {
        this.content = content;
        this.pointOrder = pointOrder;
        this.fromDayNumber = fromDayNumber;
        this.toDayNumber = toDayNumber;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPointOrder() {
        return pointOrder;
    }

    public void setPointOrder(Integer pointOrder) {
        this.pointOrder = pointOrder;
    }

    public Integer getFromDayNumber() {
        return fromDayNumber;
    }

    public void setFromDayNumber(Integer fromDayNumber) {
        this.fromDayNumber = fromDayNumber;
    }

    public Integer getToDayNumber() {
        return toDayNumber;
    }

    public void setToDayNumber(Integer toDayNumber) {
        this.toDayNumber = toDayNumber;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getTodoDateId() {
        return todoDateId;
    }

    public void setTodoDateId(Integer todoDateId) {
        this.todoDateId = todoDateId;
    }

    public TodoDate getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(TodoDate todoDate) {
        this.todoDate = todoDate;
    }

    public List<TodoExtendedPoint> getTodoExtendedPoints() {
        return todoExtendedPoints;
    }

    public void setTodoExtendedPoints(List<TodoExtendedPoint> todoExtendedPoints) {
        this.todoExtendedPoints = todoExtendedPoints;
    }

    public void addExtendedTodoPoint(TodoExtendedPoint todoExtendedPoint){
        if (todoExtendedPoints == null){
            todoExtendedPoints = new ArrayList<>();
        }

        todoExtendedPoints.add(todoExtendedPoint);
    }

    @Override
    public String toString() {
        return "TodoPoint{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", pointOrder=" + pointOrder +
                ", fromDate='" + fromDayNumber + '\'' +
                ", toDate='" + toDayNumber + '\'' +
                ", completed=" + completed +
                ", todoDate=" + todoDate +
                '}';
    }
}
