package com.workflow.WorkFlowDEMO.data.repository.todo;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoPoint;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Hidden
public interface TodoPointJpaRepository extends JpaRepository<TodoPoint,Integer> {

    boolean existsById(int todoPointId);

    boolean existsByTodoDateIdAndFromDayNumberEqualsAndPointOrderEquals(int todoDateId,int fromDayNumber,int PointOrder);

    List<TodoPoint> findAllByTodoDateIdOrderByFromDayNumberAsc(int todoDateId);

}
