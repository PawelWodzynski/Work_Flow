import React from "react";
import "./CallendarSlideOutAddButton.css";

const CallendarSlideOutAddButton = ({ setAddMenuVisible }) => {
  const handleAddButton = () => {
    setAddMenuVisible((prevState) => !prevState);
  };

  return (
    <button onClick={handleAddButton} className="slide-out-header-add-button">
      Add
    </button>
  );
};

export default CallendarSlideOutAddButton;
