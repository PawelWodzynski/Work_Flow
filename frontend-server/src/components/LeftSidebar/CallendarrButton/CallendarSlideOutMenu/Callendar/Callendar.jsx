import React from "react";
import "./Callendar.css";
import CallendarHeader from "./CallendarHeader/CallendarHeader";
import CallendarContent from "./CallendarContent/CallendarContent";

const Callendar = () => {
  return (
    <>
      <div className="callendar-card">
        <CallendarHeader></CallendarHeader>
        <CallendarContent></CallendarContent>
      </div>
    </>
  );
};

export default Callendar;
