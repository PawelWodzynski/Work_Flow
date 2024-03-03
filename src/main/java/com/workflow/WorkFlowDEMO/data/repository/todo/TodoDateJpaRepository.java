package com.workflow.WorkFlowDEMO.data.repository.todo;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoDate;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Hidden
public interface TodoDateJpaRepository extends JpaRepository<TodoDate,Integer> {

    boolean existsByEmployeeIdAndYearEqualsAndAndMounthNumberEquals(int employeeId, int year, int mounthNumber);

    boolean existsById(int todoDateId);

    List<TodoDate> findAllByEmployeeId(int employeeId);

}
