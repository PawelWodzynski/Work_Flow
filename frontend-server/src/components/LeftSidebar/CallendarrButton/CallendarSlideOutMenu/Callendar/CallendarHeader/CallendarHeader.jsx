import React from "react";
import "./CallendarHeader.css";
import MonthName from "./MonthName/MonthName";
import CallendarDeleteButton from "./CallendarDeleteButton/CallendarDeleteButton";
import CallendarDate from "./CallendarDate/CallendarDate";
const CallendarHeader = () => {
  return (
    <>
      <div className="callendar-header">
        <MonthName></MonthName>
        <CallendarDeleteButton></CallendarDeleteButton>
        <CallendarDate></CallendarDate>
      </div>
    </>
  );
};

export default CallendarHeader;
