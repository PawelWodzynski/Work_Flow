import React from "react";
import "./BodyLayout.css";
import Navbar from "../Navbar/Navbar";
import LeftSidebar from "../LeftSidebar/LeftSidebar";
import RightSidebar from "../RightSidebar/RightSidebar";
import ContentContainer from "../ContentContainer/ContentContainer";
import { CarouselProvider } from "../Carousel/CarouselContext";
import { SlideOutButtonsProvider } from "../LeftSidebar/CallendarrButton/SlideOutsContext";
import { CallendarSlideOutMenu } from "../LeftSidebar/CallendarrButton/CallendarSlideOutMenu/CallendarSlideOutMenu";
import { SlideOutMenu } from "../Navbar/MenuButton/SlideOutMenu/SlideOutMenu";

const BodyLayout = () => {
  return (
    <>
      <SlideOutButtonsProvider>
        <CallendarSlideOutMenu />
        <SlideOutMenu />
        <div className="body-container body-grid">
          <Navbar />
          <CarouselProvider>
            <LeftSidebar />
            <RightSidebar />
            <ContentContainer />
          </CarouselProvider>
        </div>
      </SlideOutButtonsProvider>
    </>
  );
};

export default BodyLayout;
