import React from "react";
import "./CloseModalButton.css";

const CloseModalButton = ({ setModalVisible }) => {
  const changeModalVisible = () => {
    setModalVisible((prevState) => !prevState);
  };

  return (
    <button
      className="close-modal-icon close-modal-button"
      onClick={changeModalVisible}
    ></button>
  );
};

export default CloseModalButton;
