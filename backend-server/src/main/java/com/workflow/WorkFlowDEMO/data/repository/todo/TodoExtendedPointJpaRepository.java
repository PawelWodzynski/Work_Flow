package com.workflow.WorkFlowDEMO.data.repository.todo;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoExtendedPoint;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Hidden
public interface TodoExtendedPointJpaRepository extends JpaRepository<TodoExtendedPoint,Integer> {

    boolean existsByTodoPointIdAndPointOrderEquals(int todoPointId,int pointOrder);
    List<TodoExtendedPoint> findAllByTodoPointIdOrderByPointOrderAsc(int todoPointId);

    boolean existsByTodoPointId(int todoPointId);

    boolean existsById(int extendedPointId);

    TodoExtendedPoint findById(int extendedPointId);

    int countByTodoPointId(int todoPointId);

    List<TodoExtendedPoint> findAllByTodoPointIdAndPointOrderIsGreaterThan(int todoPointId, int pointOrder);

    List<TodoExtendedPoint> findAllByTodoPointIdAndPointOrderIsLessThan(int todoPointId, int pointOrder);

    TodoExtendedPoint deleteById(int extendedPointId);

    @Query("SELECT MAX(t.pointOrder) FROM TodoExtendedPoint t WHERE t.todoPointId = :todoPointId")
    Integer findMaxExtendedPointOrderByTodoPointId(Integer todoPointId);




}
