package com.workflow.WorkFlowDEMO.data.entity.todo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "todo_point")
public class TodoPoint {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "order")
    private int order;

    @Column(name = "from_date")
    private String fromDate;

    @Column(name = "to_date")
    private String toDate;

    @Column(name = "completed")
    private boolean completed;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "todo_date_id")
    private TodoDate todoDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "todo_point_id")
    private List<TodoExtendedPoint> todoExtendedPoints;

    public TodoPoint(){}

    public TodoPoint(String content, int order, String fromDate, String toDate, boolean completed){
        this.content = content;
        this.order = order;
        this.fromDate = fromDate;
        this.toDate = toDate;
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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public TodoDate getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(TodoDate todoDate) {
        this.todoDate = todoDate;
    }

    @Override
    public String toString() {
        return "TodoPoint{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", order=" + order +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", completed=" + completed +
                ", todoDate=" + todoDate +
                '}';
    }
}
