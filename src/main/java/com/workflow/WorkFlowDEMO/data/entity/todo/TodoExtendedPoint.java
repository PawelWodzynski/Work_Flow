package com.workflow.WorkFlowDEMO.data.entity.todo;

import jakarta.persistence.*;

@Entity
@Table(name = "todo_extended_point")
public class TodoExtendedPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "order")
    private int order;

    @Column(name = "completed")
    private boolean completed;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "todo_point_id")
    private TodoPoint todoPoint;

    public TodoExtendedPoint(){}

    public TodoExtendedPoint(String content, int order, boolean completed){
        this.content = content;
        this.order = order;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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

    public void setTodoPoint(TodoPoint todoPoint) {
        this.todoPoint = todoPoint;
    }

    @Override
    public String toString() {
        return "TodoExtendedPoint{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", order=" + order +
                ", completed=" + completed +
                ", todoPoint=" + todoPoint +
                '}';
    }
}
