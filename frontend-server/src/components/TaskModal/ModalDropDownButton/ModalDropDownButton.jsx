import { useState, useEffect } from "react";
import React from "react";
import "./ModalDropDownButton.css";

const ModalDropDownButton = () => {
  const [open, setOpen] = useState(false);

  const handleOpen = () => {
    setOpen(!open);
  };

  const handleMenuOne = () => {
    setOpen(false);
  };

  const handleMenuTwo = () => {
    setOpen(false);
  };

  useEffect(() => {
    const handleOutsideClick = (event) => {
      if (open && !event.target.closest(".modal-dropdown")) {
        setOpen(false);
      }
    };

    document.addEventListener("click", handleOutsideClick);

    return () => {
      document.removeEventListener("click", handleOutsideClick);
    };
  }, [open]);

  return (
    <div className="modal-dropdown">
      <button onClick={handleOpen} className="modal-drop-down-button ">
        Task Deadline
      </button>
      {open ? (
        <ul className="menu">
          <li className="menu-item">
            <button onClick={handleMenuOne}>Menu 1</button>
          </li>
          <li className="menu-item">
            <button onClick={handleMenuTwo}>Menu 2</button>
          </li>
        </ul>
      ) : null}
    </div>
  );
};

export default ModalDropDownButton;
