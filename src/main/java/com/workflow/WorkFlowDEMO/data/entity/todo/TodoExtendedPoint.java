package com.workflow.WorkFlowDEMO.data.entity.todo;

import jakarta.persistence.*;

@Entity
@Table(name = "todo_extended_point")
public class TodoExtendedPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "point_order")
    private int pointOrder;

    @Column(name = "completed")
    private boolean completed;

    @Column(name = "todo_point_id")
    private int todoPointId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "todo_point_id",insertable = false, updatable = false)
    private TodoPoint todoPoint;

    public TodoExtendedPoint(){}

    public TodoExtendedPoint(String content, int pointOrder, boolean completed){
        this.content = content;
        this.pointOrder = pointOrder;
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

    public int getPointOrder() {
        return pointOrder;
    }

    public void setPointOrder(int pointOrder) {
        this.pointOrder = pointOrder;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public TodoPoint getTodoPoint() {
        return todoPoint;
    }

    public int getTodoPointId() {
        return todoPointId;
    }

    public void setTodoPointId(int todoPointId) {
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
