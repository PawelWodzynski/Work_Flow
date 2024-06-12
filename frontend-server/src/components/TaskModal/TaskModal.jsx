import React, { useState } from "react";
import "./TaskModal.css";
import TaskModalTextarea from "./TaskModalTextarea/TaskModalTextarea";
import TaskModalSaveButton from "./TaskModalSaveButton/TaskModalSaveButton";
import ModalTaskDate from "./ModalTaskDate/ModalTaskDate";
import TaskModalButtonGroup from "./TaskModalButtonGroup/TaskModalButtonGroup";
import ModalDropDownButton from "./ModalDropDownButton/ModalDropDownButton";

const TaskModal = () => {
  const [isVisible, setModalVisible] = useState(true);

  const changeVisible = () => {
    setModalVisible(!isVisible);
  };

  return (
    <>
      <div
        className={`modal-shadow-screen  ${
          isVisible ? "modal-shadow-screen-showed" : ""
        }`}
        onClick={changeVisible}
      ></div>

      <div
        className={`task-modal-body task-modal-body-grid ${
          isVisible ? "task-modal-showed" : ""
        }`}
      >
        <TaskModalTextarea></TaskModalTextarea>
        <TaskModalSaveButton></TaskModalSaveButton>
        <ModalTaskDate></ModalTaskDate>
        <TaskModalButtonGroup
          setModalVisible={setModalVisible}
        ></TaskModalButtonGroup>
        <ModalDropDownButton></ModalDropDownButton>
      </div>
    </>
  );
};

export default TaskModal;
