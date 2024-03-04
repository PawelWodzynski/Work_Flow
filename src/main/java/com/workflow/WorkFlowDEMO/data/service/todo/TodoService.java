package com.workflow.WorkFlowDEMO.data.service.todo;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoDate;
import com.workflow.WorkFlowDEMO.data.entity.todo.TodoExtendedPoint;
import com.workflow.WorkFlowDEMO.data.entity.todo.TodoPoint;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Hidden
public interface TodoService {

/////////////////////////////////// TODO DATE //////////////////////////////////////////////////////////////////
    TodoDate saveTodoDate(TodoDate todoDate);

    boolean findTodoDateDuplicateForEmployeeId(int employeeId,int year, int monthNumber);

    boolean checkExistenceOfTodoDateById(int todoDateId);

    List<TodoDate> findAllTodoDatesByEmployeeId(int employeeId);


    /////////////////////////////////////// TODO POINT ///////////////////////////////////////////////////////////
    TodoPoint saveTodoPoint(TodoPoint todoPoint);

    boolean checkExistenceOfTodoPointById(int todoPointId);

    boolean checkOrderExistenceOfTodoPointByTodoDateIdAndOrder(int todoDateId,int fromDayNumber,int pointOrder);


    //////////////////////////////////// TODO EXTENDED POINT/////////////////////////////////////////////////////
    TodoExtendedPoint saveTodoExtendedPoint(TodoExtendedPoint todoExtendedPoint);

    boolean checkOrderExistenceOfTodoExtendedPointByTodoPointIdAndOrder(int todoPointId, int pointOrder);



}
