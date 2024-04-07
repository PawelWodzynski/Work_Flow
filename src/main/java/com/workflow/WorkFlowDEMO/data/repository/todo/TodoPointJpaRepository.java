package com.workflow.WorkFlowDEMO.data.repository.todo;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoPoint;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    @Query("SELECT MAX(t.pointOrder) FROM TodoPoint t WHERE t.todoDateId = :todoDateId AND t.fromDayNumber = :fromDayNumber")
    Integer findMaxPointOrderByTodoDateIdAndFromDayNumber(Integer todoDateId, Integer fromDayNumber);

    @Query("SELECT CONCAT('point-', t.id) AS key, CONCAT(MIN(t.fromDayNumber), '-', MAX(t.toDayNumber)) AS value " +
            "FROM TodoPoint t WHERE t.todoDateId = :todoDateId " +
            "GROUP BY t.id " +
            "ORDER BY MIN(t.fromDayNumber) ASC, t.pointOrder ASC")
    List<Map<String, String>> findDayRangesMapByTodoDateIdOrderByFromDayNumberAndPointOrder(@Param("todoDateId") Integer todoDateId);



}
