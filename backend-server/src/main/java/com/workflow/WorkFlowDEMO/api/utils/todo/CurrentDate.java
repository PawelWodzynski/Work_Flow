package com.workflow.WorkFlowDEMO.api.utils.todo;

import java.time.LocalDate;

public class CurrentDate {

    public int getCurrentYear(){
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        return year;
    }

    public int getCurrentMonth(){
        LocalDate currentDate = LocalDate.now();
        int month = currentDate.getMonthValue();
        return month;
    }
}
