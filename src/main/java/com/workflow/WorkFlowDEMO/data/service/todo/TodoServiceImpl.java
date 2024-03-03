package com.workflow.WorkFlowDEMO.data.service.todo;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoDate;
import com.workflow.WorkFlowDEMO.data.entity.todo.TodoExtendedPoint;
import com.workflow.WorkFlowDEMO.data.entity.todo.TodoPoint;
import com.workflow.WorkFlowDEMO.data.repository.todo.TodoDateJpaRepository;
import com.workflow.WorkFlowDEMO.data.repository.todo.TodoExtendedPointJpaRepository;
import com.workflow.WorkFlowDEMO.data.repository.todo.TodoPointJpaRepository;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Hidden
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoDateJpaRepository todoDateJpaRepository;

    @Autowired
    TodoPointJpaRepository todoPointJpaRepository;

    @Autowired
    TodoExtendedPointJpaRepository todoExtendedPointJpaRepository;



    //////////////////////////////////////// TODO DATE ///////////////////////////////////////////////////////
    @Override
    public TodoDate saveTodoDate(TodoDate todoDate) {
        return todoDateJpaRepository.save(todoDate);
    }

    @Override
    public boolean findTodoDateDuplicateForEmployeeId(int employeeId, int year, int mounthNumber) {
        return todoDateJpaRepository.existsByEmployeeIdAndYearEqualsAndAndMounthNumberEquals(employeeId,year,mounthNumber);
    }

    @Override
    public boolean checkExistenceOfTodoDateById(int todoDateId) {
        return todoDateJpaRepository.existsById(todoDateId);
    }

    @Override
    public List<TodoDate> findAllTodoDatesByEmployeeId(int employeeId) {
        return todoDateJpaRepository.findAllByEmployeeId(employeeId);
    }


    ///////////////////////////////////// TODO POINT ////////////////////////////////////////////////////////////
    @Override
    public TodoPoint saveTodoPoint(TodoPoint todoPoint) {
        return todoPointJpaRepository.save(todoPoint);
    }

    @Override
    public boolean checkExistenceOfTodoPointById(int todoPointId) {
        return todoPointJpaRepository.existsById(todoPointId);
    }

    @Override
    public boolean checkOrderExistenceOfTodoPointByTodoDateIdAndOrder(int todoDateId,int fromDayNumber,int pointOrder) {
        return todoPointJpaRepository.existsByTodoDateIdAndFromDayNumberEqualsAndPointOrderEquals(todoDateId,fromDayNumber,pointOrder);
    }


    //////////////////////////////////// TODO EXTENDED POINT //////////////////////////////////////////////////////
    @Override
    public TodoExtendedPoint saveTodoExtendedPoint(TodoExtendedPoint todoExtendedPoint) {
        return todoExtendedPointJpaRepository.save(todoExtendedPoint);
    }

    @Override
    public boolean checkOrderExistenceOfTodoExtendedPointByTodoPointIdAndOrder(int todoPointId, int pointOrder) {
        return todoExtendedPointJpaRepository.existsByTodoPointIdAndPointOrderEquals(todoPointId,pointOrder);
    }


}
