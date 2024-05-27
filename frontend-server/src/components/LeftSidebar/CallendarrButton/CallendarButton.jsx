import React from "react";
import "./CallendarButton.css";
import "../../../assets/styles/to-do/icons.css";
import { useSlideOutButtons } from "./SlideOutsContext";

const CallendarButton = () => {
  const { isCallendarSlideOutVisible, setCallendarSlideOutVisible } =
    useSlideOutButtons();

  const handleAction = () => {
    setCallendarSlideOutVisible(!isCallendarSlideOutVisible);
  };

  return (
    <button
      className="left-sidebar-callendar-button-item callendar-icon"
      onClick={handleAction}
    ></button>
  );
};

export default CallendarButton;
