package com.workflow.WorkFlowDEMO.data.repository.todo;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoExtendedPoint;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Hidden
public interface TodoExtendedPointJpaRepository extends JpaRepository<TodoExtendedPoint,Integer> {

    boolean existsByTodoPointIdAndPointOrderEquals(int todoPointId,int pointOrder);

}
