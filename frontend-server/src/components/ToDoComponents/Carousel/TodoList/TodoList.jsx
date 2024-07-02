import React from "react";
import "./TodoList.css";
import TodoListHeader from "./TodoListHeader/TodoListHeader";
import TodoListContentContainer from "./TodoListContentContainer/TodoListContentContainer";

const TodoListBody = ({ number }) => {
  return (
    <>
      <div className={`todo-list-body carousel-row-item-${number}`}>
        <TodoListHeader></TodoListHeader>
        <TodoListContentContainer></TodoListContentContainer>
      </div>
    </>
  );
};

export default TodoListBody;
