import React, { useState } from "react";
import { useSlideOutButtons } from "../SlideOutsContext";
import "./CallendarSlideOutMenu.css";
import CallendarSlideOutHeader from "./CallendarSlideOutHeader/CallendarSlideOutHeader";
import CallendarSlideOutContent from "./CallendarSlideOutContent/CallendarSlideOutContent";

export const CallendarSlideOutMenu = () => {
  const { isCallendarSlideOutVisible, setCallendarSlideOutVisible } =
    useSlideOutButtons();

  const [isAddMenuVisible, setAddMenuVisible] = useState();

  const setSlideOutVisible = () => {
    setCallendarSlideOutVisible(!isCallendarSlideOutVisible);
  };

  return (
    <>
      <div
        onClick={setSlideOutVisible}
        className={`shadow-screen ${
          isCallendarSlideOutVisible ? "visible" : ""
        }`}
      ></div>

      <div
        className={`slide-out-callendar-menu slide-out-callendar-menu-grid ${
          isCallendarSlideOutVisible ? "visible" : ""
        }`}
      >
        <CallendarSlideOutHeader
          setSlideOutVisible={setSlideOutVisible}
          setAddMenuVisible={setAddMenuVisible}
        ></CallendarSlideOutHeader>

        <CallendarSlideOutContent
          isAddMenuVisible={isAddMenuVisible}
        ></CallendarSlideOutContent>
      </div>
    </>
  );
};
