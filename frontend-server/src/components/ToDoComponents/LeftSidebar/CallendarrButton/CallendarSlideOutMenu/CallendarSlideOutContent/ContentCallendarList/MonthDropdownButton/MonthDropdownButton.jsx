import React, { useState, useEffect } from "react";
import "./MonthDropdownButton.css";

const MonthDropdownButton = () => {
  const [isOpen, setOpen] = useState(false);

  const changeOpenState = () => {
    setOpen(!isOpen);
  };

  useEffect(() => {
    const handleOutsideClick = (event) => {
      if (isOpen && !event.target.closest(".month-dropdown")) {
        setOpen(false);
      }
    };

    document.addEventListener("click", handleOutsideClick);

    return () => {
      document.removeEventListener("click", handleOutsideClick);
    };
  }, [isOpen]);

  return (
    <div className="month-dropdown">
      <button onClick={changeOpenState} className="add-month-button">
        Month
      </button>

      {isOpen ? (
        <ul className="month-menu">
          <li className="month-menu-item">
            <button onClick={changeOpenState}>Menu 1</button>
          </li>
          <li className="month-menu-item">
            <button onClick={changeOpenState}>Menu 2</button>
          </li>
        </ul>
      ) : null}
    </div>
  );
};

export default MonthDropdownButton;
