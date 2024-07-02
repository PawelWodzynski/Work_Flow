import React from "react";
import "./SideTasksContainer.css";
import SideTaskHeader from "./SideTaskHeader/SideTaskHeader";
import SideTaskContentContainer from "./SideTaskContentContainer/SideTaskContentContainer";

const SideTasksContainer = () => {
  return (
    <div className="side-tasks-container content-container-side-tasks-grid-item">
      <SideTaskHeader></SideTaskHeader>
      <SideTaskContentContainer></SideTaskContentContainer>
    </div>
  );
};

export default SideTasksContainer;
