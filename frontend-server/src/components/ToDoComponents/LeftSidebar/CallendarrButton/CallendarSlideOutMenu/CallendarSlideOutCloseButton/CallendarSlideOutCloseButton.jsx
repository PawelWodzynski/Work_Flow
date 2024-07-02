import React from "react";
import "./CallendarSlideOutCloseButton.css";

const CallendarSlideOutCloseButton = ({setSlideOutVisible}) => {
    return <button
    className="slide-out-callendar-menu-header-close close-icon"
    onClick={setSlideOutVisible}
  ></button>
};

export default CallendarSlideOutCloseButton;
