package com.workflow.WorkFlowDEMO.api.controllers.todo;

import com.workflow.WorkFlowDEMO.api.documentation.todo.TodoRestControllerDocumentation;
import com.workflow.WorkFlowDEMO.api.utils.validation.service.ValidationService;
import com.workflow.WorkFlowDEMO.data.dto.employee.response.SimpleResponseMessageDTO;
import com.workflow.WorkFlowDEMO.data.dto.todo.request.*;
import com.workflow.WorkFlowDEMO.data.dto.todo.response.AddTodoDateResponseDTO;
import com.workflow.WorkFlowDEMO.data.dto.todo.response.AddTodoExtendedPointResponseDTO;
import com.workflow.WorkFlowDEMO.data.dto.todo.response.AddTodoPointResponseDTO;
import com.workflow.WorkFlowDEMO.data.entity.todo.TodoDate;
import com.workflow.WorkFlowDEMO.data.entity.todo.TodoExtendedPoint;
import com.workflow.WorkFlowDEMO.data.entity.todo.TodoPoint;
import com.workflow.WorkFlowDEMO.data.service.employee.EmployeeService;
import com.workflow.WorkFlowDEMO.data.service.todo.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/todoRequest")
public class TodoRestController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ValidationService validationService;

    @Operation(summary = "Add To Do Date for Employee",
            description = TodoRestControllerDocumentation.addTodoDateDsc
    )
    @PostMapping("/addTodoDate")
    public ResponseEntity<?> addTodoDate(@RequestBody AddTodoDateRequestDTO addTodoDateRequestDTO) {
        try {
          Map<String,String> errorsFromDTO = validationService.validateObject(addTodoDateRequestDTO, "addTodoRequestDto");
          if (errorsFromDTO.isEmpty()) {
              if (employeeService.existById(addTodoDateRequestDTO.getEmployeeId())) {
                  if (!todoService.findTodoDateDuplicateForEmployeeId(addTodoDateRequestDTO.getEmployeeId(), addTodoDateRequestDTO.getYear(), addTodoDateRequestDTO.getMonthNumber())) {
                      TodoDate todoDate = new TodoDate(addTodoDateRequestDTO.getMonthNumber(), addTodoDateRequestDTO.getYear());
                      todoDate.setEmployeeId(addTodoDateRequestDTO.getEmployeeId());
                      Map<String, String> errorsFromEntity = validationService.validateObject(todoDate, "todoDate");
                      if (errorsFromEntity.isEmpty()) {
                          todoService.saveTodoDate(todoDate);
                          return ResponseEntity.ok(
                                  new AddTodoDateResponseDTO(
                                          "TODO date successfully added",
                                          addTodoDateRequestDTO.getYear(),
                                          addTodoDateRequestDTO.getMonthNumber(),
                                          addTodoDateRequestDTO.getEmployeeId(),
                                          todoDate.getId()
                                  ));
                      } else {
                          return ResponseEntity.badRequest().body(errorsFromEntity);
                      }
                  } else {
                      return ResponseEntity.badRequest().body(
                              new SimpleResponseMessageDTO(
                                      "Error of adding TO DO date" +
                                              "You can't have the same two months of TO DO in the same year " +
                                              "( year: " + addTodoDateRequestDTO.getYear() + " ) " +
                                              "(!!!! month: " + addTodoDateRequestDTO.getMonthNumber() + " !!!! ) "
                              ));
                  }
              } else {
                  return ResponseEntity.badRequest().body(
                          new SimpleResponseMessageDTO(
                                  "Employee not found ID: " +
                                          addTodoDateRequestDTO.getEmployeeId()
                          ));
              }
          }else {
              return ResponseEntity.badRequest().body(errorsFromDTO);
          }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO(e.getMessage()));
        }
    }


    @Operation(summary = "Add To Do Point for To Do Date",
            description = TodoRestControllerDocumentation.addTodoPointDsc
    )
    @PostMapping("/addTodoPoint")
    public ResponseEntity<?> addTodoPoint(@RequestBody AddTodoPointRequestDTO addTodoPointRequestDTO) {
        try {
            Map<String,String> dtoErrors = validationService.validateObject(addTodoPointRequestDTO,"addTodoPointRequestDTO");
            if (dtoErrors.isEmpty()) {
                if (todoService.checkExistenceOfTodoDateById(addTodoPointRequestDTO.getTodoDateId())) {
                    if (!todoService.checkOrderExistenceOfTodoPointByTodoDateIdAndOrder
                            (addTodoPointRequestDTO.getTodoDateId(),
                                    addTodoPointRequestDTO.getFromDayNumber(),
                                    addTodoPointRequestDTO.getPointOrder()
                            )) {
                        TodoPoint todoPoint = new TodoPoint(
                                addTodoPointRequestDTO.getContent(),
                                addTodoPointRequestDTO.getPointOrder(),
                                addTodoPointRequestDTO.getFromDayNumber(),
                                addTodoPointRequestDTO.getToDayNumber(),
                                false
                        );
                        todoPoint.setTodoDateId(addTodoPointRequestDTO.getTodoDateId());

                        Map<String,String> entityErrors = validationService.validateObject(todoPoint,"todoPoint");
                        if (entityErrors.isEmpty()) {
                            todoService.saveTodoPoint(todoPoint);
                            return ResponseEntity.ok(
                                    new AddTodoPointResponseDTO(
                                            "TO DO point successfully added",
                                            addTodoPointRequestDTO.getContent(),
                                            addTodoPointRequestDTO.getPointOrder(),
                                            addTodoPointRequestDTO.getFromDayNumber(),
                                            addTodoPointRequestDTO.getToDayNumber(),
                                            false,
                                            addTodoPointRequestDTO.getTodoDateId(),
                                            todoPoint.getId()
                                    ));
                        }else {
                            return ResponseEntity.badRequest().body(entityErrors);
                        }
                    } else {
                        return ResponseEntity.badRequest().body(
                                new SimpleResponseMessageDTO(
                                        "Error adding a point to the TO DO date, " +
                                                "the added point cannot have the same order as the one already existing on a given fromDayNumber " +
                                                "(fromDayNumber: " + addTodoPointRequestDTO.getFromDayNumber() + " ) " +
                                                "(!!!! pointOrder: " + addTodoPointRequestDTO.getPointOrder() + " !!!! ) " +
                                                "(todoDateId: " + addTodoPointRequestDTO.getTodoDateId() + " ) "

                                ));
                    }
                } else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "TO DO date does not exist ID " +
                                            addTodoPointRequestDTO.getTodoDateId() +
                                            ", to assign a point you must first create a date"
                            ));
                }
            }else {
                return ResponseEntity.badRequest().body(dtoErrors);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO(e.getMessage()));
        }
    }


    @Operation(summary = "Add To Do Extended Point for To Do Point",
            description = TodoRestControllerDocumentation.addTodoExtendedPointDsc
    )
    @PostMapping("/addTodoExtendedPoint")
    public ResponseEntity<?> addTodoExtendedPoint(@RequestBody AddTodoExtendedPointRequestDTO addTodoExtendedPointRequestDTO) {
        try {
            Map<String,String> dtoErrors = validationService.validateObject(addTodoExtendedPointRequestDTO,"addTodoExtendedPointRequestDTO");
            if (dtoErrors.isEmpty()) {
                if (todoService.checkExistenceOfTodoPointById(addTodoExtendedPointRequestDTO.getTodoPointId())) {
                    if (!todoService.checkOrderExistenceOfTodoExtendedPointByTodoPointIdAndOrder(
                            addTodoExtendedPointRequestDTO.getTodoPointId(),
                            addTodoExtendedPointRequestDTO.getPointOrder()
                    )) {
                        TodoExtendedPoint todoExtendedPoint = new TodoExtendedPoint(
                                addTodoExtendedPointRequestDTO.getContent(),
                                addTodoExtendedPointRequestDTO.getPointOrder(),
                                false
                        );
                        todoExtendedPoint.setTodoPointId(addTodoExtendedPointRequestDTO.getTodoPointId());
                        Map<String,String> entityErrors = validationService.validateObject(todoExtendedPoint,"todoExtendedPoint");
                        if (entityErrors.isEmpty()) {
                            todoService.saveTodoExtendedPoint(todoExtendedPoint);
                            return ResponseEntity.ok(
                                    new AddTodoExtendedPointResponseDTO(
                                            "TO DO extended point successfully added",
                                            addTodoExtendedPointRequestDTO.getContent(),
                                            addTodoExtendedPointRequestDTO.getPointOrder(),
                                            addTodoExtendedPointRequestDTO.getTodoPointId(),
                                            false,
                                            todoExtendedPoint.getId()
                                    ));
                        }else {
                            return ResponseEntity.badRequest().body(entityErrors);
                        }
                    } else {
                        return ResponseEntity.badRequest().body(
                                new SimpleResponseMessageDTO(
                                        "Error adding a extended point to the TO DO point, " +
                                                "the added point cannot have the same order as the one already existing on a given todoPointId " +
                                                "( todoPointId: " + addTodoExtendedPointRequestDTO.getTodoPointId() + ") " +
                                                "(!!!!! pointOrder: " + addTodoExtendedPointRequestDTO.getPointOrder() + "!!!!! ) "

                                ));
                    }
                } else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "TO DO point does not exist ID " +
                                            addTodoExtendedPointRequestDTO.getTodoPointId() +
                                            " to assign an extended point you must first create a date "
                            ));
                }
            }else {
                return ResponseEntity.badRequest().body(dtoErrors);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO(e.getMessage()));
        }
    }

    @GetMapping("/findAllTodoDatesByEmployeeId")
    public ResponseEntity<?> findAllTodoDatesByEmployeeId(@RequestParam int employeeId) {
        try {
                if (employeeService.existById(employeeId)) {
                    List<TodoDate> todoDates = todoService.findAllTodoDatesByEmployeeId(employeeId);
                    if (todoDates.size() > 0) {
                        List<Map<String, Object>> formattedDates = new ArrayList<>();
                        int iteration = 0;
                        for (TodoDate todoDate : todoDates) {
                            iteration++;
                            Map<String, Object> dateMap = new HashMap<>();
                            int year = todoDate.getYear();
                            int monthNumber = todoDate.getMonthNumber();
                            dateMap.put("Date-" + iteration, todoDate);
                            formattedDates.add(dateMap);
                        }
                        return ResponseEntity.ok(formattedDates);
                    } else {
                        return ResponseEntity.badRequest().body(
                                new SimpleResponseMessageDTO(
                                        "Employee with ID: " + employeeId + " has no dates"
                                ));
                    }
                } else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "Employee not found ID:" + employeeId
                            ));
                }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    new SimpleResponseMessageDTO(
                            e.getMessage()
                    ));
        }
    }

    @GetMapping("/findAllTodoPointsByTodoDateId")
    public ResponseEntity<?> findAllTodoPointsByTodoDateId(@RequestParam int todoDateId) {
        try {
            if (todoService.checkExistenceOfTodoDateById(todoDateId)) {
                List<TodoPoint> todoPoints = todoService.findAllTodoPointsByTodoDateId(todoDateId);
                if (todoPoints.size() > 0) {
                    List<Map<String, Object>> formattedPoints = new ArrayList<>();
                    int iteration = 0;
                    for (TodoPoint todoPoint : todoPoints) {
                        iteration++;
                        // Using LinkedHashMap to maintain order
                        Map<String, Object> pointMap = new LinkedHashMap<>();
                        pointMap.put("todoPoint", todoPoint);

                        // Add extended points if they exist
                        if (todoService.checkExistenceOfExtendedPointByTodoPointId(todoPoint.getId())) {
                            // Using LinkedHashMap to maintain order
                            Map<String, Object> extendedPointsMap = new LinkedHashMap<>();
                            List<TodoExtendedPoint> todoExtendedPoints = todoService.findAllTodoExtendedPointsByTodoPointId(todoPoint.getId());
                            int extendedIteration = 0;
                            for (TodoExtendedPoint todoExtendedPoint : todoExtendedPoints) {
                                extendedIteration++;
                                // Using LinkedHashMap to maintain order
                                Map<String, Object> extendedPointMap = new LinkedHashMap<>();
                                extendedPointMap.put("id", todoExtendedPoint.getId());
                                extendedPointMap.put("content", todoExtendedPoint.getContent());
                                extendedPointMap.put("pointOrder", todoExtendedPoint.getPointOrder());
                                extendedPointMap.put("completed", todoExtendedPoint.isCompleted());
                                extendedPointMap.put("todoPointId", todoExtendedPoint.getTodoPointId());
                                extendedPointsMap.put("Extended-" + extendedIteration, extendedPointMap);
                            }
                            pointMap.put("ExtendedPoints", extendedPointsMap);
                        }

                        // Add the pointMap to the formattedPoints list
                        formattedPoints.add(Collections.singletonMap("Point-" + iteration, pointMap));
                    }
                    return ResponseEntity.ok(formattedPoints);
                } else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "TO DO Date ID:" + todoDateId +
                                            " has no TO DO points"
                            ));
                }
            } else {
                return ResponseEntity.badRequest().body(
                        new SimpleResponseMessageDTO(
                                "TO DO Date ID:" + todoDateId +
                                        " does not exist"
                        ));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO(e.getMessage()));
        }
    }


    @PutMapping("/updateTodoPoint")
    public ResponseEntity<?> updateTodoPointById(@RequestBody UpdateTodoPointDTO updateTodoPointDTO) {
        try {
            Map<String,String> dtoErrors = validationService.validateObject(updateTodoPointDTO,"updateTodoPointDTO");
            if (dtoErrors.isEmpty()) {
                int todoPointId = updateTodoPointDTO.getTodoPointId();
                String content = updateTodoPointDTO.getContent();
                int toDayNumber = updateTodoPointDTO.getToDayNumber();
                if (todoService.checkExistenceOfTodoPointById(todoPointId)) {
                    TodoPoint todoPoint = todoService.findTodoPointById(todoPointId);
                    todoPoint.setContent(content);
                    if (todoPoint.getToDayNumber() != toDayNumber) {
                        todoPoint.setToDayNumber(toDayNumber);
                    }
                    todoService.saveTodoPoint(todoPoint);
                    return ResponseEntity.ok(todoPoint);
                } else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "To Do point ID:" + todoPointId +
                                            " does not exist"
                            ));
                }
            }else {
                return ResponseEntity.badRequest().body(dtoErrors);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    new SimpleResponseMessageDTO(
                            e.getMessage()
                    ));
        }
    }


    @PutMapping("/updateTodoExtendedPoint")
    public ResponseEntity<?> updateTodoExtendedPoint(@RequestBody UpdateTodoExtendedPointDTO updateTodoExtendedPointDTO) {
        try {
            Map<String,String> dtoErrors = validationService.validateObject(updateTodoExtendedPointDTO,"updateTodoExtendedPointDTO");
            if (dtoErrors.isEmpty()) {
                int todoExtendedPointId = updateTodoExtendedPointDTO.getTodoExtendedPointId();
                String content = updateTodoExtendedPointDTO.getContent();
                if (todoService.checkExistenceOfExtendedPointById(todoExtendedPointId)) {
                    TodoExtendedPoint todoExtendedPoint = todoService.findTodoExtendedPointById(todoExtendedPointId);
                    todoExtendedPoint.setContent(content);
                    todoService.saveTodoExtendedPoint(todoExtendedPoint);
                    return ResponseEntity.ok(todoExtendedPoint);
                } else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "To Do Extended Point ID:" + todoExtendedPointId +
                                            " does not exist"
                            ));
                }
            }else {
                return ResponseEntity.badRequest().body(dtoErrors);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    new SimpleResponseMessageDTO(
                            e.getMessage()
                    ));
        }
    }


    @PutMapping("/changeCompletedStatusOfTodoPoint")
    public ResponseEntity<?> changeCompletedStatusOfTodoPoint(@RequestBody ChangeCompletedTodoPointDTO changeCompletedTodoPointDTO) {
        try {
            Map<String,String> dtoErrors = validationService.validateObject(changeCompletedTodoPointDTO,"changeCompletedTodoPointDTO");
            if (dtoErrors.isEmpty()) {
                int todoPointId = changeCompletedTodoPointDTO.getTodoPointId();
                boolean isCompleted = changeCompletedTodoPointDTO.getCompleted();
                if (todoService.checkExistenceOfTodoPointById(todoPointId)) {
                    TodoPoint todoPoint = todoService.findTodoPointById(todoPointId);
                    if (!todoPoint.isCompleted() == isCompleted) {
                        todoPoint.setCompleted(isCompleted);
                        todoService.saveTodoPoint(todoPoint);
                        return ResponseEntity.ok(todoPoint);
                    } else {
                        return ResponseEntity.badRequest().body(
                                new SimpleResponseMessageDTO(
                                        "Status has not changed"
                                ));
                    }
                } else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "To Do point ID:" + todoPointId +
                                            " does not exist"
                            ));
                }
            }else {
                return ResponseEntity.badRequest().body(dtoErrors);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    new SimpleResponseMessageDTO(
                            e.getMessage()
                    ));
        }
    }


    @PutMapping("/changeCompletedStatusOfTodoExtendedPoint")
    public ResponseEntity<?> changeCompletedStatusOfTodoExtendedPoint(@RequestBody ChangeCompletedExtendedPointDTO changeCompletedExtendedPointDTO) {
        try {
            Map<String,String> dtoErrors = validationService.validateObject(changeCompletedExtendedPointDTO,"changeCompletedExtendedPointDTO");
            if (dtoErrors.isEmpty()) {
                int todoExtendedPointId = changeCompletedExtendedPointDTO.getTodoExtendedPointId();
                boolean isCompleted = changeCompletedExtendedPointDTO.getCompleted();
                if (todoService.checkExistenceOfExtendedPointById(todoExtendedPointId)) {
                    TodoExtendedPoint todoExtendedPoint = todoService.findTodoExtendedPointById(todoExtendedPointId);
                    if (!todoExtendedPoint.isCompleted() == isCompleted) {
                        todoExtendedPoint.setCompleted(isCompleted);
                        todoService.saveTodoExtendedPoint(todoExtendedPoint);
                        return ResponseEntity.ok(todoExtendedPoint);
                    } else {
                        return ResponseEntity.badRequest().body(
                                new SimpleResponseMessageDTO(
                                        "Status has not changed"
                                ));
                    }
                } else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "To Do Extended Point ID:" + todoExtendedPointId +
                                            " does not exist"
                            ));
                }
            }else {
                return ResponseEntity.badRequest().body(dtoErrors);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    new SimpleResponseMessageDTO(
                            e.getMessage()
                    ));
        }
    }







    @PutMapping("/changeOrderOfTodoPoint")
    public ResponseEntity<?> changeOrderOfTodoPoint(@RequestBody ChangeOrderTodoPointDTO changeOrderTodoPointDTO) {
        try {
            Map<String,String> dtoErrors = validationService.validateObject(changeOrderTodoPointDTO,"changeOrderTodoPointDTO");
            if (dtoErrors.isEmpty()) {
                int todoPointId = changeOrderTodoPointDTO.getTodoPointId();
                int order = changeOrderTodoPointDTO.getOrder();
                if (todoService.checkExistenceOfTodoPointById(todoPointId)) {
                    TodoPoint todoPoint = todoService.findTodoPointById(todoPointId);
                    if (order <= todoService.checkCountOfTodoPointsByTodoDateIdAndFromDayNumber(todoPoint.getTodoDateId(), todoPoint.getFromDayNumber())) {
                        if (todoPoint.getPointOrder() < order) {
                            List<TodoPoint> highterOrders = todoService.findAllTodoPointsInHighterOrder(todoPoint.getTodoDateId(), todoPoint.getFromDayNumber(), todoPoint.getPointOrder());
                            todoPoint.setPointOrder(order);
                            for (TodoPoint todoPoint1 : highterOrders) {
                                int pointOrder = todoPoint1.getPointOrder();
                                if (todoPoint1.getPointOrder() <= order) {
                                    pointOrder--;
                                    todoPoint1.setPointOrder(pointOrder);
                                }
                            }
                            todoService.saveTodoPoint(todoPoint);
                            List<TodoPoint> allTodoPointsFromDayNumber = todoService.findAllTodoPointsByTodoDateIdAndByFromDayNumber(todoPoint.getTodoDateId(), todoPoint.getFromDayNumber());
                            Map<String, Object> iteratedPoints = new LinkedHashMap<>();
                            int iteration = 0;
                            for (TodoPoint todoPoint1 : allTodoPointsFromDayNumber) {
                                iteration++;
                                iteratedPoints.put("todoPoint-" + iteration, todoPoint1);
                            }
                            return ResponseEntity.ok(iteratedPoints);
                        } else if (todoPoint.getPointOrder() > order && order == 1) {
                            List<TodoPoint> lowerOrders = todoService.findAllTodoPointsInLowerOrder(todoPoint.getTodoDateId(), todoPoint.getFromDayNumber(), todoPoint.getPointOrder());
                            todoPoint.setPointOrder(order);
                            for (TodoPoint todoPoint1 : lowerOrders) {
                                int pointOrder = todoPoint1.getPointOrder();
                                if (todoPoint1.getPointOrder() >= order) {
                                    pointOrder++;
                                    todoPoint1.setPointOrder(pointOrder);
                                }
                            }
                            todoService.saveTodoPoint(todoPoint);
                            List<TodoPoint> allTodoPointsFromDayNumber = todoService.findAllTodoPointsByTodoDateIdAndByFromDayNumber(todoPoint.getTodoDateId(), todoPoint.getFromDayNumber());
                            Map<String, Object> iteratedPoints = new LinkedHashMap<>();
                            int iteration = 0;
                            for (TodoPoint todoPoint1 : allTodoPointsFromDayNumber) {
                                iteration++;
                                iteratedPoints.put("todoPoint-" + iteration, todoPoint1);
                            }
                            return ResponseEntity.ok(iteratedPoints);
                        } else if (todoPoint.getPointOrder() > order && order > 1) {
                            List<TodoPoint> lowerOrders = todoService.findAllTodoPointsInLowerOrder(todoPoint.getTodoDateId(), todoPoint.getFromDayNumber(), todoPoint.getPointOrder());
                            todoPoint.setPointOrder(order);
                            for (TodoPoint todoPoint1 : lowerOrders) {
                                int pointOrder = todoPoint1.getPointOrder();
                                if (todoPoint1.getPointOrder() >= order) {
                                    if (todoPoint1.getPointOrder() != 1) {
                                        pointOrder++;
                                        todoPoint1.setPointOrder(pointOrder);
                                    }
                                }
                            }
                            todoService.saveTodoPoint(todoPoint);
                            List<TodoPoint> allTodoPointsFromDayNumber = todoService.findAllTodoPointsByTodoDateIdAndByFromDayNumber(todoPoint.getTodoDateId(), todoPoint.getFromDayNumber());
                            Map<String, Object> iteratedPoints = new LinkedHashMap<>();
                            int iteration = 0;
                            for (TodoPoint todoPoint1 : allTodoPointsFromDayNumber) {
                                iteration++;
                                iteratedPoints.put("todoPoint-" + iteration, todoPoint1);
                            }
                            return ResponseEntity.ok(iteratedPoints);
                        } else if (todoPoint.getPointOrder() == order) {
                            return ResponseEntity.badRequest().body(
                                    new SimpleResponseMessageDTO(
                                            "Cannot be changed to the same order"
                                    ));
                        } else {
                            return ResponseEntity.badRequest().body(
                                    new SimpleResponseMessageDTO(
                                            "Unidentified error "
                                    ));
                        }
                    } else {
                        return ResponseEntity.badRequest().body(
                                new SimpleResponseMessageDTO(
                                        "the given point order can't be greater than the number of points"
                                ));
                    }

                } else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "To Do Point ID:" + todoPointId +
                                            " does not exist"
                            ));
                }
            }else {
                return ResponseEntity.badRequest().body(dtoErrors);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO(
                    e.getMessage()
            ));
        }
    }



    @PutMapping("/changeOrderOfTodoExtendedPoint")
    public ResponseEntity<?> changeOrderOfTodoExtendedPoint(@RequestBody ChangeOrderExtendedPointDTO changeOrderExtendedPointDTO) {
        try {
            Map<String,String> dtoErrors = validationService.validateObject(changeOrderExtendedPointDTO,"changeOrderExtendedPointDTO");
            if (dtoErrors.isEmpty()) {
                int todoExtendedPointId = changeOrderExtendedPointDTO.getTodoExtendedPointId();
                int order = changeOrderExtendedPointDTO.getOrder();
                if (todoService.checkExistenceOfExtendedPointById(todoExtendedPointId)) {
                    TodoExtendedPoint todoExtendedPoint = todoService.findTodoExtendedPointById(todoExtendedPointId);
                    if (order <= todoService.checkCountOfTodoExtendedPointsByTodoPointId(todoExtendedPoint.getTodoPointId())) {
                        if (todoExtendedPoint.getPointOrder() < order) {
                            List<TodoExtendedPoint> highterOrders = todoService.findAllTodoExtendedPointsInHighterOrder(todoExtendedPoint.getTodoPointId(), todoExtendedPoint.getPointOrder());
                            todoExtendedPoint.setPointOrder(order);
                            for (TodoExtendedPoint todoExtendedPoint1 : highterOrders) {
                                int pointOrder = todoExtendedPoint1.getPointOrder();
                                if (todoExtendedPoint1.getPointOrder() <= order) {
                                    pointOrder--;
                                    todoExtendedPoint1.setPointOrder(pointOrder);
                                }
                            }
                            todoService.saveTodoExtendedPoint(todoExtendedPoint);
                            List<TodoExtendedPoint> allTodoExtendedPointsFromTodoPoint = todoService.findAllTodoExtendedPointsByTodoPointId(todoExtendedPoint.getTodoPointId());
                            Map<String, Object> iteratedPoints = new LinkedHashMap<>();
                            int iteration = 0;
                            for (TodoExtendedPoint extendedPoint : allTodoExtendedPointsFromTodoPoint) {
                                iteration++;
                                iteratedPoints.put("extendedPoint-" + iteration, extendedPoint);
                            }
                            return ResponseEntity.ok(iteratedPoints);
                        } else if (todoExtendedPoint.getPointOrder() > order && order == 1) {
                            List<TodoExtendedPoint> lowerOrders = todoService.findAllTodoExtendedPointsInLowerOrder(todoExtendedPoint.getTodoPointId(), todoExtendedPoint.getPointOrder());
                            todoExtendedPoint.setPointOrder(order);
                            for (TodoExtendedPoint todoExtendedPoint1 : lowerOrders) {
                                int pointOrder = todoExtendedPoint1.getPointOrder();
                                if (todoExtendedPoint1.getPointOrder() >= order) {
                                    pointOrder++;
                                    todoExtendedPoint1.setPointOrder(pointOrder);
                                }
                            }
                            todoService.saveTodoExtendedPoint(todoExtendedPoint);
                            List<TodoExtendedPoint> allTodoExtendedPointsFromTodoPoint = todoService.findAllTodoExtendedPointsByTodoPointId(todoExtendedPoint.getTodoPointId());
                            Map<String, Object> iteratedPoints = new LinkedHashMap<>();
                            int iteration = 0;
                            for (TodoExtendedPoint extendedPoint : allTodoExtendedPointsFromTodoPoint) {
                                iteration++;
                                iteratedPoints.put("extendedPoint-" + iteration, extendedPoint);
                            }
                            return ResponseEntity.ok(iteratedPoints);
                        } else if (todoExtendedPoint.getPointOrder() > order && order > 1) {
                            List<TodoExtendedPoint> lowerOrders = todoService.findAllTodoExtendedPointsInLowerOrder(todoExtendedPoint.getTodoPointId(), todoExtendedPoint.getPointOrder());
                            todoExtendedPoint.setPointOrder(order);
                            for (TodoExtendedPoint todoExtendedPoint1 : lowerOrders) {
                                if (todoExtendedPoint1.getPointOrder() >= order && todoExtendedPoint1.getPointOrder() != 1) {
                                    int pointOrder = todoExtendedPoint1.getPointOrder();
                                    pointOrder++;
                                    todoExtendedPoint1.setPointOrder(pointOrder);
                                }
                            }
                            todoService.saveTodoExtendedPoint(todoExtendedPoint);
                            List<TodoExtendedPoint> allTodoExtendedPointsFromTodoPoint = todoService.findAllTodoExtendedPointsByTodoPointId(todoExtendedPoint.getTodoPointId());
                            Map<String, Object> iteratedPoints = new LinkedHashMap<>();
                            int iteration = 0;
                            for (TodoExtendedPoint extendedPoint : allTodoExtendedPointsFromTodoPoint) {
                                iteration++;
                                iteratedPoints.put("extendedPoint-" + iteration, extendedPoint);
                            }
                            return ResponseEntity.ok(iteratedPoints);
                        } else if (todoExtendedPoint.getPointOrder() == order) {
                            return ResponseEntity.badRequest().body(
                                    new SimpleResponseMessageDTO(
                                            "Cannot be changed to the same order"
                                    ));
                        } else {
                            return ResponseEntity.badRequest().body(
                                    new SimpleResponseMessageDTO(
                                            "Unidentified error "
                                    ));
                        }
                    } else {
                        return ResponseEntity.badRequest().body(
                                new SimpleResponseMessageDTO(
                                        "the given point order can't be greater than the number of points"
                                ));
                    }
                } else {
                    return ResponseEntity.badRequest().body(
                            new SimpleResponseMessageDTO(
                                    "To Do Extended Point ID:" + todoExtendedPointId +
                                            " does not exist"
                            ));
                }
            }else {
                return ResponseEntity.badRequest().body(dtoErrors);
            }
            }catch (Exception e){
            return ResponseEntity.badRequest().body(new SimpleResponseMessageDTO(
                    e.getMessage()
            ));
        }
    }


    @DeleteMapping("/deleteTodoDate")
    public ResponseEntity<?> deleteTodoDate(@RequestParam int todoDateId){
        try{
            if (todoService.checkExistenceOfTodoDateById(todoDateId)){
                todoService.deleteTodoDateById(todoDateId);
                return ResponseEntity.ok(
                        new SimpleResponseMessageDTO(
                                "To Do Date ID:" + todoDateId +
                                        " has been deleted"
                        ));
            }else {
                return ResponseEntity.badRequest().body(
                        new SimpleResponseMessageDTO(
                                "To Do date ID:" + todoDateId +
                                        " does not exist"
                        ));
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    new SimpleResponseMessageDTO(
                     e.getMessage()
                    ));
        }
    }


    @DeleteMapping("/deleteTodoPoint")
    public ResponseEntity<?> deleteTodoPoint(@RequestParam int todoPointId){
        try{
            if (todoService.checkExistenceOfTodoPointById(todoPointId)){
                todoService.deleteTodoPointById(todoPointId);
                return ResponseEntity.ok(
                        new SimpleResponseMessageDTO(
                                "To Do Point ID:" + todoPointId +
                                        " has been deleted"
                        ));
            }else {
                return ResponseEntity.badRequest().body(
                        new SimpleResponseMessageDTO(
                                "To Do Point ID:" + todoPointId +
                                        " does not exist"
                        ));
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    new SimpleResponseMessageDTO(
                            e.getMessage()
                    ));
        }
    }


    @DeleteMapping("/deleteTodoExtendedPoint")
    public ResponseEntity<?> deleteTodoExtendedPoint(@RequestParam int todoExtendedPointId){
        try {
            if (todoService.checkExistenceOfExtendedPointById(todoExtendedPointId)){
                todoService.deleteTodoExtendedPoint(todoExtendedPointId);
                return ResponseEntity.ok(
                        new SimpleResponseMessageDTO(
                                "To Do Extended Point ID:" + todoExtendedPointId +
                                        " has been deleted"
                        ));
            }else {
                return ResponseEntity.badRequest().body(
                        new SimpleResponseMessageDTO(
                                "To Do Extended Point ID:" + todoExtendedPointId +
                                        " does not exist"
                        ));
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    new SimpleResponseMessageDTO(
                            e.getMessage()
                    ));
        }
    }

}
