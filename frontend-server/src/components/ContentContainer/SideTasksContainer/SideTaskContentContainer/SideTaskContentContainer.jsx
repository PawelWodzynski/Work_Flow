import React from "react";
import "./SideTaskContentContainer.css";
import SideTaskList from "./SideTaskList/SideTaskList";

const SideTaskContentContainer = () => {
  return (
    <div className="side-task-content-container">
      <SideTaskList listColumnNumber={1}></SideTaskList>
      <SideTaskList listColumnNumber={2}></SideTaskList>
      <SideTaskList listColumnNumber={3}></SideTaskList>
    </div>
  );
};

export default SideTaskContentContainer;
