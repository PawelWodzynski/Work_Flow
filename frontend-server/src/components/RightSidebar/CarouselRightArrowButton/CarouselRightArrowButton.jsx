import React from "react";
import "./CarouselRightArrowButton.css";
import "../../../assets/styles/to-do/icons.css";
import { useCarousel } from "../../Carousel/CarouselContext";

const CarouselRightArrowButton = () => {
  const { goToNext } = useCarousel();

  return (
    <button
      className="sidebar-right-arrow-item right-arrow-icon"
      onClick={goToNext}
    ></button>
  );
};

export default CarouselRightArrowButton;
