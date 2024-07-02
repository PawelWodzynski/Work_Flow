import React from "react";
import "./ButtonGroup.css";

const ButtonGroup = () => {
  return (
    <div className="navbar-menubar navbar-button-group">
      <button className="navbar-todo-button"> To Do</button>
      <button className="navbar-notes-button">Notes</button>
      <button className="navbar-chat-button">Chat</button>
      <button className="navbar-schedule-button">Schedule</button>
    </div>
  );
};

export default ButtonGroup;
