import React, { createContext, useContext, useState } from "react";

const SlideOutButtonsContext = createContext();

export const SlideOutButtonsProvider = ({ children }) => {
  const [isCallendarSlideOutVisible, setCallendarSlideOutVisible] =
    useState(false);
  const [isMenuSlideOutVisible, setMenuSlideOutVisible] = useState(false);

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
