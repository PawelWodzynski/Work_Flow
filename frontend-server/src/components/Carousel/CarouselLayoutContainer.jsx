import React from "react";
import "./Carousel.css";
import "./TodoList.css";

const CarouselLayoutContainer = () => {
  return (
    <div className="carousel-grid">
      <div className="carousel-row-1">
        <div className="todo-list-body carousel-row-item-1"></div>
        <div className="todo-list-body carousel-row-item-2"></div>
        <div className="todo-list-body carousel-row-item-3"></div>
        <div className="todo-list-body carousel-row-item-4"></div>
        <div className="todo-list-body carousel-row-item-5"></div>
        <div className="todo-list-body carousel-row-item-6"></div>
      </div>

      <div className="carousel-row-2">
        <div className="todo-list-body carousel-row-item-1"></div>
        <div className="todo-list-body carousel-row-item-2"></div>
        <div className="todo-list-body carousel-row-item-3"></div>
        <div className="todo-list-body carousel-row-item-4"></div>
        <div className="todo-list-body carousel-row-item-5"></div>
        <div className="todo-list-body carousel-row-item-6"></div>
      </div>
    </div>
  );
};

export default CarouselLayoutContainer;
