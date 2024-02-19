package com.workflow.WorkFlowDEMO.data.entity.employee;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment strategy
    @Column(name = "id") // Database column mapping
    private Long id;

    @Column(name = "name")
    private String name;

    // Default constructor
    public Role() {
    }

    // Constructor with one field for the role name
    public Role(String name) {
        this.name = name;
    }

    // Getter and setter methods for the 'id' field
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and setter methods for the 'name' field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Adding toString method for debugging
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
