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
    public boolean findTodoDateDuplicateForEmployeeId(int employeeId, int year, int monthNumber) {
        return todoDateJpaRepository.existsByEmployeeIdAndYearEqualsAndAndMonthNumberEquals(employeeId,year,monthNumber);
    }

    @Override
    public boolean checkExistenceOfTodoDateById(int todoDateId) {
        return todoDateJpaRepository.existsById(todoDateId);
    }

    @Override
    public List<TodoDate> findAllTodoDatesByEmployeeId(int employeeId) {
        return todoDateJpaRepository.findAllByEmployeeIdOrderByYearDescMonthNumberDesc(employeeId);
    }

    @Override
    public TodoDate deleteTodoDateById(int todoDateId) {
        return todoDateJpaRepository.deleteById(todoDateId);
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

    @Override
    public List<TodoPoint> findAllTodoPointsByTodoDateId(int todoDateId) {
        return todoPointJpaRepository.findAllByTodoDateIdOrderByFromDayNumberAsc(todoDateId);
    }

    @Override
    public TodoPoint findTodoPointById(int todoPointId) {
        return todoPointJpaRepository.findById(todoPointId);
    }

    @Override
    public List<TodoPoint> findAllTodoPointsInLowerOrder(int todoDateId, int fromDayNumber, int pointOrder) {
        return todoPointJpaRepository.findAllByTodoDateIdAndFromDayNumberAndPointOrderIsLessThan(todoDateId, fromDayNumber, pointOrder);
    }

    @Override
    public List<TodoPoint> findAllTodoPointsInHighterOrder(int todoDateId, int fromDayNumber, int pointOrder) {
        return todoPointJpaRepository.findAllByTodoDateIdAndFromDayNumberAndPointOrderIsGreaterThan(todoDateId, fromDayNumber, pointOrder);
    }

    @Override
    public List<TodoPoint> findAllTodoPointsByTodoDateIdAndByFromDayNumber(int todoDateId, int fromDayNumber) {
        return todoPointJpaRepository.findAllByTodoDateIdAndFromDayNumberOrderByPointOrder(todoDateId, fromDayNumber);
    }

    @Override
    public int checkCountOfTodoPointsByTodoDateIdAndFromDayNumber(int todoDateId, int fromDayNumber) {
        return todoPointJpaRepository.countByTodoDateIdAndFromDayNumber(todoDateId, fromDayNumber);
    }

    @Override
    public TodoPoint deleteTodoPointById(int todoPointId) {
        return todoPointJpaRepository.deleteById(todoPointId);
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

    @Override
    public List<TodoExtendedPoint> findAllTodoExtendedPointsByTodoPointId(int todoPointId) {
        return todoExtendedPointJpaRepository.findAllByTodoPointIdOrderByPointOrderAsc(todoPointId);
    }

    @Override
    public boolean checkExistenceOfExtendedPointByTodoPointId(int todoPointId) {
        return todoExtendedPointJpaRepository.existsByTodoPointId(todoPointId);
    }

    @Override
    public boolean checkExistenceOfExtendedPointById(int extendedPointId) {
        return todoExtendedPointJpaRepository.existsById(extendedPointId);
    }

    @Override
    public TodoExtendedPoint findTodoExtendedPointById(int extendedPointId) {
        return todoExtendedPointJpaRepository.findById(extendedPointId);
    }

    @Override
    public int checkCountOfTodoExtendedPointsByTodoPointId(int todoPointId) {
        return todoExtendedPointJpaRepository.countByTodoPointId(todoPointId);
    }

    @Override
    public List<TodoExtendedPoint> findAllTodoExtendedPointsInHighterOrder(int todoPointId, int pointOrder) {
        return todoExtendedPointJpaRepository.findAllByTodoPointIdAndPointOrderIsGreaterThan(todoPointId, pointOrder);
    }

    @Override
    public List<TodoExtendedPoint> findAllTodoExtendedPointsInLowerOrder(int todoPointId, int pointOrder) {
        return todoExtendedPointJpaRepository.findAllByTodoPointIdAndPointOrderIsLessThan(todoPointId, pointOrder);
    }

    @Override
    public TodoExtendedPoint deleteTodoExtendedPoint(int extendedPointId) {
        return todoExtendedPointJpaRepository.deleteById(extendedPointId);
    }


}
