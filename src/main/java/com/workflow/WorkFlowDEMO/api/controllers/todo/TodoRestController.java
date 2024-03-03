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
                if (!todoService.findTodoDateDuplicateForEmployeeId(addTodoDateRequestDTO.getEmployeeId(), addTodoDateRequestDTO.getTodoDate())){
                    TodoDate todoDate = new TodoDate();
                    todoDate.setDate(addTodoDateRequestDTO.getTodoDate());
                    todoDate.setEmployeeId(addTodoDateRequestDTO.getEmployeeId());
                    todoService.saveTodoDate(todoDate);
                    return ResponseEntity.ok(
                            new AddTodoDateResponseDTO(
                                    "TODO date successfully added",
                                    addTodoDateRequestDTO.getTodoDate(),
                                    addTodoDateRequestDTO.getEmployeeId(),
                                    todoDate.getId()
                            ));
                }else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "You can't have the same two months of TODO " +
                                            addTodoDateRequestDTO.getTodoDate()
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
                                addTodoPointRequestDTO.getFromDate(),
                                addTodoPointRequestDTO.getTodoPointOrder()
                        )){
                    TodoPoint todoPoint = new TodoPoint(
                            addTodoPointRequestDTO.getTodoContent(),
                            addTodoPointRequestDTO.getTodoPointOrder(),
                            addTodoPointRequestDTO.getFromDate(),
                            addTodoPointRequestDTO.getToDate(),
                            false
                    );
                    todoPoint.setTodoDateId(addTodoPointRequestDTO.getTodoDateId());
                    todoService.saveTodoPoint(todoPoint);
                    return ResponseEntity.ok(
                            new AddTodoPointResponseDTO(
                                    "TODO point successfully added",
                                    addTodoPointRequestDTO.getTodoContent(),
                                    addTodoPointRequestDTO.getTodoPointOrder(),
                                    addTodoPointRequestDTO.getFromDate(),
                                    addTodoPointRequestDTO.getToDate(),
                                    false,
                                    addTodoPointRequestDTO.getTodoDateId(),
                                    todoPoint.getId()
                            ));
                }else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "Error adding a point to the todo date, " +
                                            "the added point cannot have the same order as the one already existing on a given fromDate " +
                                            "(fromDate: " + addTodoPointRequestDTO.getFromDate() + " ) " +
                                            "(!!!! pointOrder: " + addTodoPointRequestDTO.getTodoPointOrder() + " !!!! ) " +
                                            "(todoDateId: " + addTodoPointRequestDTO.getTodoDateId() + " ) "

                            ));
                }
            }else {
                return ResponseEntity.badRequest().body(
                        new SimpleResponseMessageDTO(
                                "todo date does not exist ID " +
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
                                    "TODO extended point successfully added",
                                    addTodoExtendedPointRequestDTO.getTodoExtendedPointContent(),
                                    addTodoExtendedPointRequestDTO.getTodoExtededPointOrder(),
                                    addTodoExtendedPointRequestDTO.getTodoPointId(),
                                    false,
                                    todoExtendedPoint.getId()
                            ));
                }else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "Error adding a extended point to the todo point, " +
                                            "the added point cannot have the same order as the one already existing on a given todoPointId " +
                                            "( todoPointId: " + addTodoExtendedPointRequestDTO.getTodoPointId() + ") " +
                                            "(!!!!! pointOrder: " + addTodoExtendedPointRequestDTO.getTodoExtededPointOrder() + "!!!!! ) "

                            ));
                }
            }else {
                return  ResponseEntity.badRequest().body(
                        new SimpleResponseMessageDTO(
                                "todo point does not exist ID " +
                                addTodoExtendedPointRequestDTO.getTodoPointId() +
                                " to assign an extended point you must first create a date "
                        ));
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO(e.getMessage()));
        }
    }




}
