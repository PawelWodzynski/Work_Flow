package com.workflow.WorkFlowDEMO.api.utils.todo;

import java.time.YearMonth;

public class NumberOfDaysInMonth {
    public int numberOfDays(int year, int monthNumber){
        YearMonth yearMonth = YearMonth.of(year, monthNumber);
        int daysInMonth = yearMonth.lengthOfMonth();
        return daysInMonth;
    }
}
