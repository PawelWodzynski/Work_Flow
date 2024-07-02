import React from "react";
import "./MenuButton.css";
import "../../../../assets/styles/to-do/icons.css";
import { useSlideOutButtons } from "../../LeftSidebar/CallendarrButton/SlideOutsContext";

const MenuButton = () => {
  const { isMenuSlideOutVisible, setMenuSlideOutVisible } =
    useSlideOutButtons();

  const handleAction = () => {
    setMenuSlideOutVisible(!isMenuSlideOutVisible);
  };

  return (
    <>
      <button
        className="navbar-menu-list menu-list-icon"
        onClick={handleAction}
      ></button>
    </>
  );
};

export default MenuButton;
