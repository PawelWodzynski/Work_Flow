import React, { createContext, useContext, useEffect, useState } from "react";

const SlideOutButtonsContext = createContext();

export const SlideOutButtonsProvider = ({ children }) => {
  const [isCallendarSlideOutVisible, setCallendarSlideOutVisible] =
    useState(false);
  const [isMenuSlideOutVisible, setMenuSlideOutVisible] = useState(false);

  useEffect(() => {
    if (isCallendarSlideOutVisible) {
      setMenuSlideOutVisible(false);
    }
  }, [isCallendarSlideOutVisible]);

  useEffect(() => {
    if (isMenuSlideOutVisible) {
      setCallendarSlideOutVisible(false);
    }
  }, [isMenuSlideOutVisible]);

  return (
    <SlideOutButtonsContext.Provider
      value={{
        isCallendarSlideOutVisible,
        setCallendarSlideOutVisible,
        isMenuSlideOutVisible,
        setMenuSlideOutVisible,
      }}
    >
      {children}
    </SlideOutButtonsContext.Provider>
  );
};

export const useSlideOutButtons = () => useContext(SlideOutButtonsContext);
