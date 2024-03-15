package com.workflow.WorkFlowDEMO.api.documentation.todo;

public class TodoRestControllerDocumentation {

    public static final String addTodoDateDsc = "This endpoint handles a POST request for adding a To Do Date to which To Do Points can later be added," +
            "<br>"
            + "The required parameters to provide are: " +
            "<br>" +
            "monthNumber : (int) the month number must refer to an actual month number in the calendar, for example January = 1 , February = 2 , March = 3" +
            "<br>" +
            "year : (int) the given year must correspond to the current year, must consist of four digits, the next year can only be added to the twelfth month of the current year " +
            "<br>" +
            "employeeId : (int) date is saved for a specific user ID, the ID must match the real user ID" +
            "<br>" +
            "If you are curious how exactly validation works in the given parameters, visit the com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations package," +
            " there you will find the code regarding DTO and Entity " +
            "<br><br>" +
            "Possible responses with JSON parameters: <br><br>" +
            "Response ok: <br>" +
            "successfulMessage : (string) <br>" +
            "year : (int) <br>" +
            "monthNumber : (int) <br> " +
            "employeeId : (int) <br>" +
            "todoDateId : (int) <br> " +
            "<br>" +
            "Bad Request: <br>" +
            "id : (string) <br>" +
            "monthNumber : (string) <br>" +
            "year : (string) <br>" +
            "employeeId : (string) <br> " +
            "OR: <br>" +
            "message : (string) <br> ";

    public final static String addTodoPointDsc ="This endpoint handle a POST request for adding To Do Point to which To Do Extended Points can later be added," +
            "<br>" +
            "The required parameters to provide are: " +
            "<br>" +
            "content : (string)  max 256 characters. <br>" +
            "pointOrder : (int) it cannot be repeated in this same fromDayNumber <br> " +
            "fromDayNumber : (int) number of the day on which the point is to be assigned <br> " +
            "toDayNumber : (int) cannot be lower than fromDayNumber<br> " +
            "todoDateId : (int) the ID must match the real To Do Date ID <br> " +
            "If you are curious how exactly validation works in the given parameters, visit the com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations package," +
            " there you will find the code regarding DTO and Entity <br>" +
            "<br>" +
            "Possiible responses with JSON parameters: <br><br>" +
            "Response ok: <br>" +
            "successfulMessage : (string) <br>" +
            "todoContent : (string) <br> " +
            "todoPointOrder : (int) <br> " +
            "fromDayNumber : (int) <br> " +
            "toDayNumber : (int) <br> " +
            "completed : (boolean) <br> " +
            "todoDateId : (int) <br> " +
            "todoPointId : (int) <br>" +
            "<br>" +
            "Bad Request: <br> " +
            "id : (string) <br> " +
            "content : (string) <br>" +
            "pointOrder : (string) <br>" +
            "fromDayNumber : (string) <br>" +
            "toDayNumber : (string) <br>" +
            "completed : (string) <br>" +
            "todoDateId : (string) <br>" +
            "OR: <br>" +
            "message : (string) <br>";

    public static final String addTodoExtendedPointDsc = "This endpoint handle a POST request for adding To Do Extended Point <br>" +
            "<br>" +
            "The required parameters to provide are: <br>" +
            "content : (string) max 256 characters. <br>" +
            "pointOrder : (int)  cannot be repeated in this same To Do Point ID<br>" +
            "todoPointId : (int) the ID must match the real To Do Point ID <br>"  +
            "If you are curious how exactly validation works in the given parameters, visit the com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations package," +
            " there you will find the code regarding DTO and Entity <br>" +
            "<br>" +
            "Possible responses with JSON parameters <br><br>" +
            "successfulMessage : (string) <br>" +
            "todoExtendedPointContent : (string) <br> " +
            "todoExtededPointOrder : (int) <br>" +
            "todoPointId : (int) <br>" +
            "completed : (boolean) <br> " +
            "todoExtededPointId : <br>" +
            "<br>" +
            "Bad Request: <br>" +
            "id : (string) <br>" +
            "content : (string) <br>" +
            "pointOrder : (string) <br>" +
            "completed : (string) <br>" +
            "todoPointId : (string) <br>" +
            "OR: <br>" +
            "message : (string) <br>";



}
