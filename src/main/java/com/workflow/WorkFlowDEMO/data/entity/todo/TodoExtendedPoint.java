package com.workflow.WorkFlowDEMO.data.entity.todo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.annotations.*;
import jakarta.persistence.*;

@Entity
@Table(name = "todo_extended_point")
public class TodoExtendedPoint {

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
    @BooleanValidation
    @Column(name = "completed")
    private Boolean completed;
    @NotNullIdValidation
    @Column(name = "todo_point_id")
    private Integer todoPointId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "todo_point_id",insertable = false, updatable = false)
    private TodoPoint todoPoint;

    public TodoExtendedPoint(){}

    public TodoExtendedPoint(String content, Integer pointOrder, Boolean completed){
        this.content = content;
        this.pointOrder = pointOrder;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public TodoPoint getTodoPoint() {
        return todoPoint;
    }

    public Integer getTodoPointId() {
        return todoPointId;
    }

    public void setTodoPointId(Integer todoPointId) {
        this.todoPointId = todoPointId;
    }

    public void setTodoPoint(TodoPoint todoPoint) {
        this.todoPoint = todoPoint;
    }

    @Override
    public String toString() {
        return "TodoExtendedPoint{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", pointOrder=" + pointOrder +
                ", completed=" + completed +
                ", todoPoint=" + todoPoint +
                '}';
    }
}
