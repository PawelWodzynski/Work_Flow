import React from "react";
import "./CarouselLeftArrowButton.css";
import "../../../../assets/styles/to-do/icons.css";
import { useCarousel } from "../../Carousel/CarouselContext";

const CarouselLeftArrowButton = () => {
  const { goToPrevious } = useCarousel();

  return (
    <button
      className="sidebar-left-arrow-item left-arrow-icon"
      onClick={goToPrevious}
    ></button>
  );
};

export default CarouselLeftArrowButton;
