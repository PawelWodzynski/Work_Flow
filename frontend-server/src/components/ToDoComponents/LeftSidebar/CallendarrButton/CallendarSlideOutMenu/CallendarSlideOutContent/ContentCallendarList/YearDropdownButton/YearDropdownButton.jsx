import React, { useState, useEffect } from "react";
import "./YearDropdownButton.css";

const YearDropdownButton = () => {
  const [isOpen, setOpen] = useState(false);

  const changeOpenState = () => {
    setOpen(!isOpen);
  };

  useEffect(() => {
    const handleOutsideClick = (event) => {
      if (isOpen && !event.target.closest(".year-dropdown")) {
        setOpen(false);
      }
    };

    document.addEventListener("click", handleOutsideClick);

    return () => {
      document.removeEventListener("click", handleOutsideClick);
    };
  }, [isOpen]);

  return (
    <div className="year-dropdown">
      <button onClick={changeOpenState} className="add-year-button">
        Year
      </button>

      {isOpen ? (
        <ul className="year-menu">
          <li className="year-menu-item">
            <button onClick={changeOpenState}>Menu 1</button>
          </li>
          <li className="year-menu-item">
            <button onClick={changeOpenState}>Menu 2</button>
          </li>
        </ul>
      ) : null}
    </div>
  );
};

export default YearDropdownButton;
