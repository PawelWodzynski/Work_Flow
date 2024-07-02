import React from "react";
import "./CallendarSlideOutHeader.css";
import CallendarSlideOutCloseButton from "../CallendarSlideOutCloseButton/CallendarSlideOutCloseButton";
import CallendarSlideOutHeaderTitle from "./CallendarSlideOutHeaderTitle/CallendarSlideOutHeaderTitle";
import CallendarSlideOutAddButton from "./CallendarSlideOutAddButton/CallendarSlideOutAddButton";

const CallendarSlideOutHeader = ({ setSlideOutVisible, setAddMenuVisible }) => {
  return (
    <>
      <div className="slide-out-callendar-menu-header-item-1">
        <CallendarSlideOutCloseButton
          setSlideOutVisible={setSlideOutVisible}
        ></CallendarSlideOutCloseButton>
        <CallendarSlideOutHeaderTitle></CallendarSlideOutHeaderTitle>
        <CallendarSlideOutAddButton
          setAddMenuVisible={setAddMenuVisible}
        ></CallendarSlideOutAddButton>
      </div>
    </>
  );
};

export default CallendarSlideOutHeader;
