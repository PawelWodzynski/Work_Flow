import React from "react";
import "./TodoListContentContainer.css";
import TaskList from "./TaskList/TaskList";

const TodoListContentContainer = () => {
  return (
    <div className="todo-list-content-container">
      <TaskList></TaskList>
    </div>
  );
};

export default TodoListContentContainer;
