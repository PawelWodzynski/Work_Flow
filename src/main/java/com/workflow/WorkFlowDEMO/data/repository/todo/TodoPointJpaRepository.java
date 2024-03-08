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

    TodoPoint findById(int todoPointId);

    List<TodoPoint> findAllByTodoDateIdAndFromDayNumberAndPointOrderIsLessThan(int todoDateId,int fromDayNumber, int pointOrder);

    List<TodoPoint> findAllByTodoDateIdAndFromDayNumberAndPointOrderIsGreaterThan(int todoDateId,int fromDayNumber, int pointOrder);

    List<TodoPoint> findAllByTodoDateIdAndFromDayNumberOrderByPointOrder(int todoDateId, int fromDayNumber);

    int countByTodoDateIdAndFromDayNumber(int todoDateId, int fromDayNumber);

    TodoPoint deleteById(int todoPointId);
}
