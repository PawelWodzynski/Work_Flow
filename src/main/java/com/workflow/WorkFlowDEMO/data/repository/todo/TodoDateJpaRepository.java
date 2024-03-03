package com.workflow.WorkFlowDEMO.data.repository.todo;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoDate;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Hidden
public interface TodoDateJpaRepository extends JpaRepository<TodoDate,Integer> {
    boolean existsByEmployeeIdAndDateContaining(int employeeId, String todoDate);

    boolean existsById(int todoDateId);
}
