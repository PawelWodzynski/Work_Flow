import React from "react";
import "./DeleteTaskButton.css";

const DeleteTaskButton = () => {
  return (
    <button className="delete-task-button">
      <span className="trash-icon"></span>
    </button>
  );
};

export default DeleteTaskButton;
