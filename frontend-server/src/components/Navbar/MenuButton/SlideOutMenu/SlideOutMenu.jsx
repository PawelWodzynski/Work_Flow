import React from "react";
import "./SlideOutMenu.css";
import { useSlideOutButtons } from "../../../LeftSidebar/CallendarrButton/CallendarButtonsContext";

export const SlideOutMenu = () => {
  const { isMenuSlideOutVisible, setMenuSlideOutVisible } =
    useSlideOutButtons();

  const setSlideOutVisible = () => {
    setMenuSlideOutVisible(!isMenuSlideOutVisible);
  };

  return (
    <div
      className={`slide-main-menu slide-main-menu-grid  ${
        isMenuSlideOutVisible ? "visible" : ""
      }`}
    >
      <div className="slide-main-menu-header-item-1">
        <button
          className="close-icon slide-main-menu-close"
          onClick={setSlideOutVisible}
        ></button>

        <p className="slide-main-menu-header-title-item">Menu</p>
      </div>
    </div>
  );
};
