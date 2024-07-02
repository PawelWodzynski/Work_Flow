import React, { useEffect } from "react";
import { useCarousel } from "./CarouselContext";
import "./Carousel.css";

const Carousel = ({ children }) => {
  const { currentIndex, setSlidesCount } = useCarousel();

  useEffect(() => {
    setSlidesCount(children.length);
  }, [children, setSlidesCount]);

  return (
    <div className="carousel">
      <div
        className="carousel-content"
        style={{ transform: `translateX(-${currentIndex * 100}%)` }}
      >
        {children.map((child, index) => (
          <div className="carousel-item" key={index}>
            {child}
          </div>
        ))}
      </div>
    </div>
  );
};

export default Carousel;
