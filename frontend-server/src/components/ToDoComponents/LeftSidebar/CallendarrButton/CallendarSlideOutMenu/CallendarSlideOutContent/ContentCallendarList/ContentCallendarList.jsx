import React from "react";
import "./ContentCallendarList.css";
import Callendar from "../../Callendar/Callendar";
import MonthDropdownButton from "./MonthDropdownButton/MonthDropdownButton";
import SaveCallendarButton from "./SaveCallendarButton/SaveCallendarButton";
import YearDropdownButton from "./YearDropdownButton/YearDropdownButton";

const ContentCallendarList = ({ isAddMenuVisible }) => {
  return (
    <ul className="slide-out-callendar-list ">
      <li
        className={
          isAddMenuVisible
            ? "slide-out-callendar-list-li-showed"
            : "slide-out-callendar-list-li-hidden"
        }
      >
        <div className="add-slider">
          <YearDropdownButton></YearDropdownButton>
          <MonthDropdownButton></MonthDropdownButton>
          <SaveCallendarButton></SaveCallendarButton>
        </div>
      </li>

      <li className="slide-out-callendar-li">
        <Callendar></Callendar>
      </li>
    </ul>
  );
};

export default ContentCallendarList;
