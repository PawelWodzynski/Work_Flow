package com.workflow.WorkFlowDEMO.api.documentation.todo;

public class TodoRestControllerDocumentation {

    public static final String addTodoDateDsc =
            "This endpoint handles a POST request for adding a To Do Date to which To Do Points can later be added," +
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
            "Possible responses with JSON parameters or Keys with parameters: <br><br>" +
            "Response ok: <br>" +
            "successfulMessage : (string) <br>" +
            "year : (int) <br>" +
            "monthNumber : (int) <br> " +
            "employeeId : (int) <br>" +
            "todoDateId : (int) <br> " +
            "<br>" +
            "Bad Request: <br>" +
            "message : (String)<br>" +
            "<br>" +
            "OR: <br>" +
            "|KEYS WITH PARAMETERS|<br>" +
            "ENTITY_VALIDATION_ERRORS : (KEY)<br>" +
            "Possible ENTITY_VALIDATION_ERRORS KEY parameters : <br>" +
            "id : (String)<br>" +
            "monthNumber : (String)<br>" +
            "pointOrder : (String)<br>" +
            "year : (String) <br>" +
            "employeeId : (String)<br>" +
            "<br>" +
            "OR: <br>" +
            "DTO_VALIDATION_ERRORS : (KEY)<br>" +
            "Possible DTO_VALIDATION_ERRORS KEY parameters : <br>" +
            "monthNumber : (String) <br>" +
            "year : (String)" +
            "employeeId : (String)<br>";

    public final static String addTodoPointDsc =
            "This endpoint handle a POST request for adding To Do Point to which To Do Extended Points can later be added," +
            "<br>" +
            "The required parameters to provide are: " +
            "<br>" +
            "content : (string)  max 256 characters. <br>" +
            "pointOrder : (int) it cannot be repeated in this same fromDayNumber <br> " +
            "fromDayNumber : (int) number of the day on which the point is to be assigned <br> " +
            "toDayNumber : (int) task end date number, cannot be lower than fromDayNumber<br> " +
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
            "message : (string) <br>" +
            "<br>" +
            "OR:<br>" +
            "|KEYS WITH PARAMETERS|<br>" +
            "ENTITY_VALIDATION_ERRORS : (KEY)<br>" +
            "Possible ENTITY_VALIDATION_ERRORS KEY parameters : <br>" +
            "id : (String)<br>" +
            "content : (String)<br>" +
            "pointOrder : (String)<br>" +
            "fromDayNumber : (String) <br>" +
            "toDayNumber : (String)<br>" +
            "completed : (String)<br>" +
            "todoDateId : (String)<br>" +
            "<br>" +
            "OR: <br>" +
            "DTO_VALIDATION_ERRORS : (KEY)<br>" +
            "Possible DTO_VALIDATION_ERRORS KEY parameters : <br>" +
            "content : (String) <br>" +
            "pointOrder : (String)<br>" +
            "fromDayNumber : (String)<br>" +
            "toDayNumber : (String)<br>" +
            "todoDateId : (String)<br>";

    public static final String addTodoExtendedPointDsc =
            "This endpoint handle a POST request for adding To Do Extended Point <br>" +
            "<br>" +
            "The required parameters to provide are: <br>" +
            "content : (string) max 256 characters. <br>" +
            "pointOrder : (int)  cannot be repeated in this same To Do Point ID<br>" +
            "todoPointId : (int) the ID must match the real To Do Point ID <br>"  +
            "If you are curious how exactly validation works in the given parameters, visit the com.workflow.WorkFlowDEMO.api.utils.validation.validators.universal.implementations package," +
            " there you will find the code regarding DTO and Entity <br>" +
            "<br>" +
            "Possible responses with JSON parameters <br><br>" +
            "Response ok: <br>" +
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
            "message : (string) <br>" +
            "OR : <br>" +
            "|KEYS WITH PARAMETERS|<br>" +
            "ENTITY_VALIDATION_ERRORS : (KEY)<br>" +
            "Possible ENTITY_VALIDATION_ERRORS KEY parameters<br>" +
            "id : (String)<br>" +
            "content : (String)<br>" +
            "pointOrder : (String)<br>" +
            "completed : (String)<br>" +
            "todoPointId : (String)<br>" +
            "<br>" +
            "OR : <br>" +
            "DTO_VALIDATION_ERRORS : (KEY)<br>" +
            "Possible DTO_VALIDATION_ERRORS KEY parameters<br>" +
            "content : (String)<br>" +
            "pointOrder : (String)<br>" +
            "todoPointId : (String)<br>";


    public static final String findAllTodoDatesByEmployeeIdDsc =
            "This endpoint handle GET request to get all user-created 'To Do Dates' <br>" +
                    "The required parameters to provide are: <br>" +
                    "<br>" +
                    "employeeId : (int) <br>" +
                    "<br>" +
                    "Possible responses with JSON keys, and parameters <br>" +
                    "<br>" +
                    "Response ok: <br>" +
                    "In response ok, you will get KEY, with will have parameters under it <br>" +
                    "<br>" +
                    "|KEY| <br>" +
                    "<br>" +
                    "Date-x : ( x = iteration ) <br>" +
                    "<br>" +
                    "|PARAMETERS|<br>" +
                    "<br>" +
                    "id : (int | To Do Date ID) <br>" +
                    "monthNumber : (int) <br>" +
                    "year : (int) <br>" +
                    "employeeId : (int) <br>" +
                    "<br>" +
                    "<br>" +
                    "Bad Request: <br>" +
                    "<br>" +
                    "message : (String) <br>";

    public static final String findAllTodoPointsByTodoDateIdDsc =
            "This endpoint handle GET request to get all user-created 'To Do Points with To Do Extended Points (subpoints)'" +
                    "The required parameters to provide are: <br>" +
                    "<br>" +
                    "todoDateId : (int | provide ID for find appropriate point) <br>" +
                    "<br>" +
                    "Possible responses with JSON keys, and parameters <br>" +
                    "<br>" +
                    "Response ok: <br>" +
                    "In response ok, you will get KEY, with will have SUBKEYS with parameters under it  <br>" +
                    "<br>" +
                    "|MAIN KEY|<br>" +
                    "Point-x ( x = iteration | a set of keys with their subkeys )<br>" +
                    "<br>" +
                    "|SUBKEYS| <br>" +
                    "|KEY|<br>" +
                    "todoPoint : ( it have parameters under it ) <br>" +
                    "<br>" +
                    "|todoPoint KEY PARAMETERS| <br>" +
                    "id : (int | To Do Point ID  )<br>" +
                    "content : (String)<br>" +
                    "pointOrder : (int) <br>" +
                    "fromDayNumber : (int) <br>" +
                    "toDayNumber : (int) <br>" +
                    "completed : (boolean) <br>" +
                    "todoDateId : (int) <br>" +
                    "<br>" +
                    "|KEY| <br>" +
                    "ExtendedPoint : (has a set of subkeys, is provided if the 'To Do Point' contains an 'Extended Point')<br>" +
                    "<br>" +
                    "|SUBKEY OF ExtendedPoint KEY| <br>" +
                    "Extended-x : ( x = iteration )<br>" +
                    "<br>" +
                    "|Extended-x KEY PARAMETERS|<br>" +
                    "id : (int | To Do Extended Point ID )<br>" +
                    "content : (String)<br>" +
                    "pointOrder : (int)<br>" +
                    "completed : (boolean)<br>" +
                    "todoPointId : (int)<br>" +
                    "<br>" +
                    "<br>" +
                    "Bad Request: <br>" +
                    "message: (String)<br>";


    public static final String updateTodoPointByIdDsc =
            "This method handle PUT request to update 'To Do Point' content and change 'toDayNumber'<br>" +
                    "The required parameters to provide are: <br>" +
                    "<br>" +
                    "todoPointId : (int | provide ID for find appropriate point)<br>" +
                    "content : (String | if you want to leave the same content unchanged, enter the current content) <br>" +
                    "toDayNumber : (int | if you want to leave the same number unchanged, enter the current value) <br>" +
                    "<br>" +
                    "Possible responses with JSON keys and parameters<br>" +
                    "<br>" +
                    "Response ok: <br>" +
                    "In response ok, you will get all parameters of 'To Do Point'<br>" +
                    "<br>" +
                    "id : (int | To Do Point ID)<br>" +
                    "content : (String | content of To Do Point)<br>" +
                    "pointOrder : (int | order of To Do Point)<br>" +
                    "fromDayNumber : (int | the day to witch the point is assigned)<br>" +
                    "toDayNumber : (int | deadline of task time)<br>" +
                    "completed : (boolean)<br>" +
                    "todoDateId : (int)<br>" +
                    "<br>" +
                    "Bad Request: <br>" +
                    "message : (String)<br>" +
                    "<br>" +
                    "OR:<br>" +
                    "|KEYS WITH PARAMETERS|<br>" +
                    "ENTITY_VALIDATION_ERRORS : (KEY)<br>" +
                    "Possible ENTITY_VALIDATION_ERRORS KEY parameters : <br>" +
                    "id : (String)<br>" +
                    "content : (String)<br>" +
                    "pointOrder : (String)<br>" +
                    "fromDayNumber : (String) <br>" +
                    "toDayNumber : (String)<br>" +
                    "completed : (String)<br>" +
                    "todoDateId : (String)<br>" +
                    "<br>" +
                    "OR: <br>" +
                    "DTO_VALIDATION_ERRORS : (KEY)<br>" +
                    "Possible DTO_VALIDATION_ERRORS KEY parameters : <br>" +
                    "todoPointId : (String) <br>" +
                    "content : (String) <br>" +
                    "toDayNumber : (String)";


    public static final String updateTodoExtendedPointDsc =
            "This method handle PUT request to update 'To Do Extended Point' content <br>" +
                    "The required parameters to provide are: <br>" +
                    "<br>" +
                    "todoExtendedPointId : (int | provide id for find appropriate Extended Point)<br>" +
                    "content : (String | if you want to leave the same content unchanged, enter the current content)<br>" +
                    "<br>" +
                    "Possible responses with JSON parameters or Keys with parameters <br>" +
                    "<br>" +
                    "Response ok: <br>" +
                    "In response ok, you will get all parameters of 'To Do Extended Point'<br>" +
                    "id : (int | To Do Extended Point ID)<br>" +
                    "content : (String | content of edited Extended Point)<br>" +
                    "pointOrder : (int | order of Extended Point)<br>" +
                    "completed : (boolean)<br>" +
                    "todoPointId : (int | id of To Do Point to witch the Extended Point belongs)<br>" +
                    "<br>" +
                    "Bad Request : <br>" +
                    "message : (String)<br>" +
                    "<br>" +
                    "OR : <br>" +
                    "|KEYS WITH PARAMETERS|<br>" +
                    "ENTITY_VALIDATION_ERRORS : (KEY)<br>" +
                    "Possible ENTITY_VALIDATION_ERRORS KEY parameters<br>" +
                    "id : (String)<br>" +
                    "content : (String)<br>" +
                    "pointOrder : (String)<br>" +
                    "completed : (String)<br>" +
                    "todoPointId : (String)<br>" +
                    "<br>" +
                    "OR : <br>" +
                    "DTO_VALIDATION_ERRORS : (KEY)<br>" +
                    "Possible DTO_VALIDATION_ERRORS KEY parameters<br>" +
                    "todoExtendedPointId : (String)<br>" +
                    "content : (String)<br>" ;


    public static final String changeCompletedStatusOfTodoPointDsc =
            "This endpoint handle PUT request for update 'completed' status od 'To Do Point' <br>" +
                    "The required parameters to provide are: <br>" +
                    "<br>" +
                    "todoPointId : (int | provide for find appropriate 'To Do Point')<br>" +
                    "completed : (boolean)<br>" +
                    "<br>" +
                    "Possible responses with JSON parameters or keys with parameters <br>" +
                    "<br>" +
                    "Response ok: <br>" +
                    "In response ok, you will get all parameters of 'To Do Point'<br>" +
                    "<br>" +
                    "id : (int | To Do Point ID)<br>" +
                    "content : (String | content of To Do Point)<br>" +
                    "pointOrder : (int | order of To Do Point)<br>" +
                    "fromDayNumber : (int | the day to witch the point is assigned)<br>" +
                    "toDayNumber : (int | deadline of task time)<br>" +
                    "completed : (boolean)<br>" +
                    "todoDateId : (int)<br>" +
                    "<br>" +
                    "Bad Request : <br>" +
                    "message : (String)<br>" +
                    "<br>" +
                    "OR: <br>" +
                    "|KEYS WITH PARAMETERS|<br>" +
                    "ENTITY_VALIDATION_ERRORS : (KEY)<br>" +
                    "Possible ENTITY_VALIDATION_ERRORS KEY parameters : <br>" +
                    "id : (String)<br>" +
                    "content : (String)<br>" +
                    "pointOrder : (String)<br>" +
                    "fromDayNumber : (String) <br>" +
                    "toDayNumber : (String)<br>" +
                    "completed : (String)<br>" +
                    "todoDateId : (String)<br>" +
                    "<br>" +
                    "DTO_VALIDATION_ERRORS : (KEY)<br>" +
                    "Possible DTO_VALIDATION_ERRORS KEY parameters<br>" +
                    "todoPointId : (String) <br>" +
                    "completed : (String)<br>";


    public static final String changeCompletedStatusOfTodoExtendedPointDsc =
            "This endpoint handle PUT request for change 'completed' status of To Do Extended Point<br>" +
                    "The required parameters to provide are: <br>" +
                    "<br>" +
                    "todoExtendedPointId : (int | provide for find appropriate 'To Do Extended Point')<br>" +
                    "completed : (boolean)<br>" +
                    "<br>" +
                    "Possible responses with JSON parameters or keys with parameters <br>" +
                    "<br>" +
                    "Response ok: <br>" +
                    "In response ok, you will get all parameters of 'To Do Extended Point'<br>" +
                    "id : (int | To Do Extended Point ID)<br>" +
                    "content : (String | content of edited Extended Point)<br>" +
                    "pointOrder : (int | order of Extended Point)<br>" +
                    "completed : (boolean)<br>" +
                    "todoPointId : (int | id of To Do Point to witch the Extended Point belongs)<br>" +
                    "<br>" +
                    "OR : <br>" +
                    "|KEYS WITH PARAMETERS|<br>" +
                    "ENTITY_VALIDATION_ERRORS : (KEY)<br>" +
                    "Possible ENTITY_VALIDATION_ERRORS KEY parameters<br>" +
                    "id : (String)<br>" +
                    "content : (String)<br>" +
                    "pointOrder : (String)<br>" +
                    "completed : (String)<br>" +
                    "todoPointId : (String)<br>" +
                    "<br>" +
                    "OR : <br>" +
                    "DTO_VALIDATION_ERRORS : (KEY)<br>" +
                    "Possible DTO_VALIDATION_ERRORS KEY parameters<br>" +
                    "todoExtendedPointId : (String)<br>" +
                    "completed : (String)<br>";

    public static final String changeOrderOfTodoPointDsc =
            "This endpoint handle PUT request for change order of 'To Do Point' <br>" +
                    "The required parameters to provide are: <br>" +
                    "<br>" +
                    "todoPointId : (int | provide for find appropriate 'To Do Point')<br>" +
                    "order : (int | enter the sequence number of the point on which the point is to be located)<br>" +
                    "<br>" +
                    "Possible responses with JSON keys with parameters: <br>" +
                    "<br>" +
                    "Response ok: <br>" +
                    "When editing a To Do Point order, the order of all points from the appropriate day on which the To Do Point order was changed is changed <br>" +
                    "In the response ok, you will receive a list of keys, that is a list of all 'To Do Points' from the appropriately edited day of the To Do point <br>" +
                    "<br>" +
                    "|KEY|<br>" +
                    "todoPoint-x : (KEY | x = iteration)<br>" +
                    "<br>" +
                    "|'todoPoint-x' KEY PARAMETERS|<br>" +
                    "id : (int | ID of 'To Do Point')<br>" +
                    "content : (String)<br>" +
                    "pointOrder : (int)<br>" +
                    "fromDayNumber : (int)<br>" +
                    "toDayNumber : (int)<br>" +
                    "completed : (boolean)<br>" +
                    "todoDateId : (int)<br>" +
                    "<br>" +
                    "Bad Request: <br>" +
                    "message : (String) <br>" +
                    "<br>" +
                    "OR: <br>" +
                    "DTO_VALIDATION_ERRORS : (KEY)<br>" +
                    "Possible DTO_VALIDATION_ERRORS KEY parameters<br>" +
                    "todoPointId : (String)<br>" +
                    "order : (String)<br>";

    public static final String changeOrderOfTodoExtendedPointDsc =
            "This endpoint handle PUT request for change 'order' of 'To Do Extended Point'<br>" +
                    "The required parameters to provide are: <br>" +
                    "<br>" +
                    "todoExtendedPointId : (int | provide for find appropriate 'To Do Extended Point')<br>" +
                    "order : (int | enter the sequence number of the point on which the point is to be located)<br>" +
                    "<br>"+
                    "Possible responses with JSON keys with parameters: <br>" +
                    "<br>" +
                    "Response ok: <br>" +
                    "When editing a To Do Extended Point order, the order of all extended points from the appropriate 'To Do Point' on which the 'To Do Extended Point' order was changed is changed <br>" +
                    "In the response ok, you will receive a list of keys, that is a list of all 'To Do Extended Points' from the appropriately the To Do point <br>" +
                    "<br>" +
                    "|KEY|<br>" +
                    "todoExtendedPoint-x : (KEY | x = iteration)<br>" +
                    "<br>" +
                    "|'todoExtendedPoint-x' KEY PARAMETERS|<br>" +
                    "id : (int | ID of 'To Do Point')<br>" +
                    "content : (String)<br>" +
                    "pointOrder : (int)<br>" +
                    "completed : (boolean)<br>" +
                    "todoPointId : (int)<br>" +
                    "<br>" +
                    "Bad Request: <br>" +
                    "message : (String)<br>" +
                    "<br>" +
                    "OR: <br>" +
                    "DTO_VALIDATION_ERRORS : (KEY)<br>" +
                    "Possible DTO_VALIDATION_ERRORS KEY parameters<br>" +
                    "todoExtendedPointId : (String)<br>" +
                    "order : (String)<br>";



    public static final String deleteTodoDateDsc =
            "This endpoint handle DELETE request for delete 'To Do Date', along with deletion 'To Do Date', all 'To Do Points' and 'To Do Extended Points' will be deleted<br>" +
                    "The required parameters to provide are: <br>" +
                    "<br>" +
                    "todoDateId : (int)<br>" +
                    "<br>" +
                    "Possible responses with JSON parameters: <br>" +
                    "<br>" +
                    "Response ok: <br>" +
                    "message: (String)<br>" +
                    "<br>" +
                    "Bad Request: <br>" +
                    "message : (String)<br>";


    public static final String deleteTodoPointDsc =
            "This endpoint handle DELETE request for delete 'To Do Point', along with deletion 'To Do Point', all 'To Do Extended Points' will be deleted<br>" +
                    "The required parameters to provide are: <br>" +
                    "<br>" +
                    "todoPointId : (int)<br>" +
                    "<br>" +
                    "Possible responses with JSON parameters: <br>" +
                    "<br>" +
                    "Response ok: <br>" +
                    "message: (String)<br>" +
                    "<br>" +
                    "Bad Request: <br>" +
                    "message : (String)<br>";


    public static final String deleteTodoExtendedPointDsc =
            "This endpoint handle DELETE request for delete 'To Do Extended Point'" +
                    "The required parameters to provide are: <br>" +
                    "<br>" +
                    "todoExtendedPointId : (int)<br>" +
                    "<br>" +
                    "Possible responses with JSON parameters: <br>" +
                    "<br>" +
                    "Response ok: <br>" +
                    "message: (String)<br>" +
                    "<br>" +
                    "Bad Request: <br>" +
                    "message : (String)<br>";




















}
