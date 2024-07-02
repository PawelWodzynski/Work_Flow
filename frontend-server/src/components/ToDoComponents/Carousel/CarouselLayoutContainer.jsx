import React from "react";
import "./Carousel.css";
import TodoListBody from "./TodoList/TodoList";

const CarouselLayoutContainer = () => {
  return (
    <div className="carousel-grid">
      <div className="carousel-row-1">
        <TodoListBody number={1}></TodoListBody>
        <TodoListBody number={2}></TodoListBody>
        <TodoListBody number={3}></TodoListBody>
        <TodoListBody number={4}></TodoListBody>
        <TodoListBody number={5}></TodoListBody>
        <TodoListBody number={6}></TodoListBody>
      </div>

      <div className="carousel-row-2">
        <TodoListBody number={1}></TodoListBody>
        <TodoListBody number={2}></TodoListBody>
        <TodoListBody number={3}></TodoListBody>
        <TodoListBody number={4}></TodoListBody>
        <TodoListBody number={5}></TodoListBody>
        <TodoListBody number={6}></TodoListBody>
      </div>
    </div>
  );
};

export default CarouselLayoutContainer;
