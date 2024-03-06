package com.workflow.WorkFlowDEMO.data.repository.todo;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoExtendedPoint;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Hidden
public interface TodoExtendedPointJpaRepository extends JpaRepository<TodoExtendedPoint,Integer> {

    boolean existsByTodoPointIdAndPointOrderEquals(int todoPointId,int pointOrder);
    List<TodoExtendedPoint> findAllByTodoPointIdOrderByPointOrderDesc(int todoPointId);

    boolean existsByTodoPointId(int todoPointId);

}
