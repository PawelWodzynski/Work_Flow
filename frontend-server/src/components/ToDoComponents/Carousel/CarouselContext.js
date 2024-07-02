import React, { createContext, useState, useContext } from "react";

const CarouselContext = createContext();

export const CarouselProvider = ({ children }) => {
  const [currentIndex, setCurrentIndex] = useState(0);
  const [slidesCount, setSlidesCount] = useState(0);

  const goToNext = () => {
    setCurrentIndex((prevIndex) => (prevIndex + 1) % slidesCount);
  };

  const goToPrevious = () => {
    setCurrentIndex((prevIndex) => (prevIndex - 1 + slidesCount) % slidesCount);
  };

  return (
    <CarouselContext.Provider
      value={{ currentIndex, goToNext, goToPrevious, setSlidesCount }}
    >
      {children}
    </CarouselContext.Provider>
  );
};

export const useCarousel = () => useContext(CarouselContext);
