import React from "react";
import "./TaskList.css";
import CreateTaskField from "../CreateTaskField/CreateTaskField";
import Task from "./Task/Task";
const TaskList = () => {
  return (
    <ul className="no-dots">
      <li className="task-border task-flex">
        <Task></Task>
      </li>
      <li className="task-border task-flex">
        <Task></Task>
      </li>
      <li className="faded-task-border">
        <CreateTaskField></CreateTaskField>
      </li>
    </ul>
  );
};
export default TaskList;
