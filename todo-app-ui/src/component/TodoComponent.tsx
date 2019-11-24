import React from "react";
import { ITodo } from "../interface/ITodo";
import { TodoListComponent } from "./subComponent/TodoListComponent";
import { TodoCreateComponent } from "./subComponent/TodoCreateComponent";

interface ITodoRowsProps {
  todos: ReadonlyArray<ITodo>;
  createTodo: (createdTodo: ITodo) => void;
}

const TodoComponent: React.FC<ITodoRowsProps> = ({ todos, createTodo }) => {
  return (
    <>
      <TodoCreateComponent createTodo={createTodo}></TodoCreateComponent>
      <TodoListComponent todos={todos}></TodoListComponent>
    </>
  );
};

export { TodoComponent };
