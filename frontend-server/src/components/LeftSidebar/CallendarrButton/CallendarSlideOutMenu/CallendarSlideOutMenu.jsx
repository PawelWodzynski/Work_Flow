import React from "react";
import { useSlideOutButtons } from "../CallendarButtonsContext";
import "./CallendarSlideOutMenu.css";

export const CallendarSlideOutMenu = () => {
  const { isCallendarSlideOutVisible, setCallendarSlideOutVisible } =
    useSlideOutButtons();

  const setSlideOutVisible = () => {
    setCallendarSlideOutVisible(!isCallendarSlideOutVisible);
  };

  return (
    <div
      className={`slide-out-callendar-menu slide-out-callendar-menu-grid ${
        isCallendarSlideOutVisible ? "visible" : ""
      }`}
    >
      <div className="slide-out-callendar-menu-header-item-1">
        <button
          className="slide-out-callendar-menu-header-close close-icon"
          onClick={setSlideOutVisible}
        ></button>
        <p className="slide-out-callendar-menu-header-title-item">Calendars</p>
      </div>
    </div>
  );
};
