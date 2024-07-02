import React from "react";
import "./LeftSidebar.css";
import CallendarButton from "./CallendarrButton/CallendarButton";
import CarouselLeftArrowButton from "./CarouselLeftArrowButton/CarouselLeftArrowButton";

const LeftSidebar = () => {
  return (
    <div className="left-sidebar sidebar-grid">
      <CallendarButton />
      <CarouselLeftArrowButton />
    </div>
  );
};

export default LeftSidebar;
