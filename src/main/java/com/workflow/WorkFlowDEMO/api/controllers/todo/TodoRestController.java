package com.workflow.WorkFlowDEMO.api.controllers.todo;

import com.workflow.WorkFlowDEMO.data.dto.employee.response.SimpleResponseMessageDTO;
import com.workflow.WorkFlowDEMO.data.dto.todo.request.AddTodoDateRequestDTO;
import com.workflow.WorkFlowDEMO.data.dto.todo.request.AddTodoExtendedPointRequestDTO;
import com.workflow.WorkFlowDEMO.data.dto.todo.request.AddTodoPointRequestDTO;
import com.workflow.WorkFlowDEMO.data.dto.todo.response.AddTodoDateResponseDTO;
import com.workflow.WorkFlowDEMO.data.dto.todo.response.AddTodoExtendedPointResponseDTO;
import com.workflow.WorkFlowDEMO.data.dto.todo.response.AddTodoPointResponseDTO;
import com.workflow.WorkFlowDEMO.data.entity.todo.TodoDate;
import com.workflow.WorkFlowDEMO.data.entity.todo.TodoExtendedPoint;
import com.workflow.WorkFlowDEMO.data.entity.todo.TodoPoint;
import com.workflow.WorkFlowDEMO.data.service.employee.EmployeeService;
import com.workflow.WorkFlowDEMO.data.service.todo.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todoRequest")
public class TodoRestController {

    @Autowired
    TodoService todoService;

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/addTodoDate")
    public ResponseEntity<?> addTodoDate(@RequestBody AddTodoDateRequestDTO addTodoDateRequestDTO){
        try {
            if (employeeService.existById(addTodoDateRequestDTO.getEmployeeId())){
                if (!todoService.findTodoDateDuplicateForEmployeeId(addTodoDateRequestDTO.getEmployeeId(), addTodoDateRequestDTO.getYear(),addTodoDateRequestDTO.getMounthNumber())){
                    TodoDate todoDate = new TodoDate(addTodoDateRequestDTO.getMounthNumber(), addTodoDateRequestDTO.getYear());
                    todoDate.setEmployeeId(addTodoDateRequestDTO.getEmployeeId());
                    todoService.saveTodoDate(todoDate);
                    return ResponseEntity.ok(
                            new AddTodoDateResponseDTO(
                                    "TODO date successfully added",
                                    addTodoDateRequestDTO.getYear(),
                                    addTodoDateRequestDTO.getMounthNumber(),
                                    addTodoDateRequestDTO.getEmployeeId(),
                                    todoDate.getId()
                            ));
                }else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "Error of adding TO DO date" +
                                    "You can't have the same two months of TO DO in the same year " +
                                            "( year: " + addTodoDateRequestDTO.getYear() + " ) " +
                                            "(!!!! mounth: " + addTodoDateRequestDTO.getMounthNumber() + " !!!! ) "
                            ));
                }
            }else {
                return ResponseEntity.badRequest().body(
                        new SimpleResponseMessageDTO(
                                "Employee not found ID: " +
                                        addTodoDateRequestDTO.getEmployeeId()
                        ));
            }
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO(e.getMessage()));
        }
    }


    @PostMapping("/addTodoPoint")
    public ResponseEntity<?> addTodoPoint(@RequestBody AddTodoPointRequestDTO addTodoPointRequestDTO){
        try {
            if (todoService.checkExistenceOfTodoDateById(addTodoPointRequestDTO.getTodoDateId())){
                if (!todoService.checkOrderExistenceOfTodoPointByTodoDateIdAndOrder
                        (addTodoPointRequestDTO.getTodoDateId(),
                                addTodoPointRequestDTO.getFromDayNumber(),
                                addTodoPointRequestDTO.getTodoPointOrder()
                        )){
                    TodoPoint todoPoint = new TodoPoint(
                            addTodoPointRequestDTO.getTodoContent(),
                            addTodoPointRequestDTO.getTodoPointOrder(),
                            addTodoPointRequestDTO.getFromDayNumber(),
                            addTodoPointRequestDTO.getToDayNumber(),
                            false
                    );
                    todoPoint.setTodoDateId(addTodoPointRequestDTO.getTodoDateId());
                    todoService.saveTodoPoint(todoPoint);
                    return ResponseEntity.ok(
                            new AddTodoPointResponseDTO(
                                    "TO DO point successfully added",
                                    addTodoPointRequestDTO.getTodoContent(),
                                    addTodoPointRequestDTO.getTodoPointOrder(),
                                    addTodoPointRequestDTO.getFromDayNumber(),
                                    addTodoPointRequestDTO.getToDayNumber(),
                                    false,
                                    addTodoPointRequestDTO.getTodoDateId(),
                                    todoPoint.getId()
                            ));
                }else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "Error adding a point to the TO DO date, " +
                                            "the added point cannot have the same order as the one already existing on a given fromDayNumber " +
                                            "(fromDayNumber: " + addTodoPointRequestDTO.getFromDayNumber() + " ) " +
                                            "(!!!! pointOrder: " + addTodoPointRequestDTO.getTodoPointOrder() + " !!!! ) " +
                                            "(todoDateId: " + addTodoPointRequestDTO.getTodoDateId() + " ) "

                            ));
                }
            }else {
                return ResponseEntity.badRequest().body(
                        new SimpleResponseMessageDTO(
                                "TO DO date does not exist ID " +
                                        addTodoPointRequestDTO.getTodoDateId() +
                                        ", to assign a point you must first create a date"
                        ));
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO(e.getMessage()));
        }
    }


    @PostMapping("/addTodoExtendedPoint")
    public ResponseEntity<?> addTodoExtendedPoint(@RequestBody AddTodoExtendedPointRequestDTO addTodoExtendedPointRequestDTO){
        try {
            if (todoService.checkExistenceOfTodoPointById(addTodoExtendedPointRequestDTO.getTodoPointId())){
                if (!todoService.checkOrderExistenceOfTodoExtendedPointByTodoPointIdAndOrder(
                        addTodoExtendedPointRequestDTO.getTodoPointId(),
                        addTodoExtendedPointRequestDTO.getTodoExtededPointOrder()
                )){
                    TodoExtendedPoint todoExtendedPoint = new TodoExtendedPoint(
                            addTodoExtendedPointRequestDTO.getTodoExtendedPointContent(),
                            addTodoExtendedPointRequestDTO.getTodoExtededPointOrder(),
                            false
                    );
                    todoExtendedPoint.setTodoPointId(addTodoExtendedPointRequestDTO.getTodoPointId());
                    todoService.saveTodoExtendedPoint(todoExtendedPoint);
                    return ResponseEntity.ok(
                            new AddTodoExtendedPointResponseDTO(
                                    "TO DO extended point successfully added",
                                    addTodoExtendedPointRequestDTO.getTodoExtendedPointContent(),
                                    addTodoExtendedPointRequestDTO.getTodoExtededPointOrder(),
                                    addTodoExtendedPointRequestDTO.getTodoPointId(),
                                    false,
                                    todoExtendedPoint.getId()
                            ));
                }else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "Error adding a extended point to the TO DO point, " +
                                            "the added point cannot have the same order as the one already existing on a given todoPointId " +
                                            "( todoPointId: " + addTodoExtendedPointRequestDTO.getTodoPointId() + ") " +
                                            "(!!!!! pointOrder: " + addTodoExtendedPointRequestDTO.getTodoExtededPointOrder() + "!!!!! ) "

                            ));
                }
            }else {
                return  ResponseEntity.badRequest().body(
                        new SimpleResponseMessageDTO(
                                "TO DO point does not exist ID " +
                                addTodoExtendedPointRequestDTO.getTodoPointId() +
                                " to assign an extended point you must first create a date "
                        ));
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO(e.getMessage()));
        }
    }

    @GetMapping("/findAllTodoDatesByEmployeeId")
    public ResponseEntity<?> findAllTodoDatesByEmployeeId(@RequestParam int employeeId){

        if (employeeService.existById(employeeId)){
            List<TodoDate> todoDates = todoService.findAllTodoDatesByEmployeeId(employeeId);
            return ResponseEntity.ok(todoDates);
        }else {
            return ResponseEntity.badRequest().body("employee not found");
        }

    }




}
