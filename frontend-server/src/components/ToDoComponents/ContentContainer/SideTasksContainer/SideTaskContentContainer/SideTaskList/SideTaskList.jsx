import React from "react";
import "./SideTaskList.css";
import CreateSideTaskField from "./CreateSideTaskField/CreateSideTaskField";

const SideTaskList = ({ listColumnNumber }) => {
  return (
    <ul className={`no-dots side-task-list-${listColumnNumber}`}>
      <li className="task-border task-flex">
        {" "}
        <CreateSideTaskField></CreateSideTaskField>
      </li>
      <li className="task-border task-flex">
        <CreateSideTaskField></CreateSideTaskField>
      </li>
      <li className="task-border task-flex">
        <CreateSideTaskField></CreateSideTaskField>
      </li>
      <li className="task-border task-flex">
        <CreateSideTaskField></CreateSideTaskField>
      </li>
      <li className="task-border task-flex">
        <CreateSideTaskField></CreateSideTaskField>
      </li>
    </ul>
  );
};

export default SideTaskList;
