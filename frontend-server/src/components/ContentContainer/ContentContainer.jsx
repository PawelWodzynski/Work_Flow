import React from "react";
import "./ContentContainer.css";
import SideTasksContainer from "./SideTasksContainer/SideTasksContainer";
import Carousel from "../Carousel/Carousel";
import CarouselLayoutContainer from "../Carousel/CarouselLayoutContainer";

const ContentContainer = () => {
  return (
    <div className="content-container content-container-grid ">
      <Carousel>
        <CarouselLayoutContainer />
        <CarouselLayoutContainer />
        <CarouselLayoutContainer />
      </Carousel>
      <SideTasksContainer />
    </div>
  );
};

export default ContentContainer;
