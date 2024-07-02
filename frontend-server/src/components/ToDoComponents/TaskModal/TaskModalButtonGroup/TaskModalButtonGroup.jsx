import React from "react";
import "./TaskModalButtonGroup.css";
import DeleteTaskButton from "./DeleteTaskButton/DeleteTaskButton";
import CloseModalButton from "./CloseModalButton/CloseModalButton";

const TaskModalButtonGroup = ({ setModalVisible }) => {
  return (
    <div className="task-modal-button-group">
      <DeleteTaskButton></DeleteTaskButton>
      <CloseModalButton setModalVisible={setModalVisible}></CloseModalButton>
    </div>
  );
};

export default TaskModalButtonGroup;
