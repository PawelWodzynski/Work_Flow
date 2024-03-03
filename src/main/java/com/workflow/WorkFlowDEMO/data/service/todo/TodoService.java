package com.workflow.WorkFlowDEMO.data.service.todo;

import com.workflow.WorkFlowDEMO.data.entity.todo.TodoDate;
import com.workflow.WorkFlowDEMO.data.entity.todo.TodoExtendedPoint;
import com.workflow.WorkFlowDEMO.data.entity.todo.TodoPoint;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.stereotype.Service;

@Service
@Hidden
public interface TodoService {

/////////////////////////////////// TODO DATE //////////////////////////////////////////////////////////////////
    TodoDate saveTodoDate(TodoDate todoDate);

    boolean findTodoDateDuplicateForEmployeeId(int employeeId,String todoDate);

    boolean checkExistenceOfTodoDateById(int todoDateId);


    /////////////////////////////////////// TODO POINT ///////////////////////////////////////////////////////////
    TodoPoint saveTodoPoint(TodoPoint todoPoint);

    boolean checkExistenceOfTodoPointById(int todoPointId);

    boolean checkOrderExistenceOfTodoPointByTodoDateIdAndOrder(int todoDateId,String fromDate,int pointOrder);


    //////////////////////////////////// TODO EXTENDED POINT/////////////////////////////////////////////////////
    TodoExtendedPoint saveTodoExtendedPoint(TodoExtendedPoint todoExtendedPoint);

    boolean checkOrderExistenceOfTodoExtendedPointByTodoPointIdAndOrder(int todoPointId, int pointOrder);



}
