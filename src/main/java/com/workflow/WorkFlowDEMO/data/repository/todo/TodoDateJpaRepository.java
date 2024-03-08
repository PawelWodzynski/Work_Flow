package com.workflow.WorkFlowDEMO.data.repository.todo;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoDate;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Hidden
public interface TodoDateJpaRepository extends JpaRepository<TodoDate,Integer> {

    boolean existsByEmployeeIdAndYearEqualsAndAndMonthNumberEquals(int employeeId, int year, int monthNumber);

    boolean existsById(int todoDateId);

    List<TodoDate> findAllByEmployeeIdOrderByYearDescMonthNumberDesc(int employeeId);

    TodoDate deleteById(int todoDateId);

}
