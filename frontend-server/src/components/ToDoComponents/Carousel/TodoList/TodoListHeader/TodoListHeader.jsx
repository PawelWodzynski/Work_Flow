import React from "react";
import "./TodoListHeader.css";
import DayName from "./DayName/DayName";
import PreciseDate from "./PreciseDate/PreciseDate";

const TodoListHeader = () => {
  return (
    <div className="day-header">
      <DayName></DayName>
      <PreciseDate></PreciseDate>
    </div>
  );
};

export default TodoListHeader;
