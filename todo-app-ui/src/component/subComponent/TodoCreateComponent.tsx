import React, { useState } from "react";
import { ITodo } from "../../interface/ITodo";

interface ITodoRowsProps {
  createTodo: (createdTodo: ITodo) => void;
}

const initializeTodo: ITodo = {
  priority: "",
  task: "",
  todoStatus: ""
};

const TodoCreateComponent: React.FC<ITodoRowsProps> = ({ createTodo }) => {
  const [todo, setTodo] = useState<ITodo>(initializeTodo);

  const onInputChange = (e: React.FormEvent<HTMLInputElement>) => {
    setTodo({ ...todo, [e.currentTarget.name]: e.currentTarget.value });
  };

  return (
    <>
      <div>
        <form onSubmit={e => createTodo(todo)}>
          <input
            type="text"
            name="priority"
            onChange={e => {
              onInputChange(e);
            }}
          />
          <input
            type="text"
            name="task"
            onChange={e => {
              onInputChange(e);
            }}
          />
          <input
            type="text"
            name="todoStatus"
            onChange={e => {
              onInputChange(e);
            }}
          />
          <input type="submit" value="Add" />
        </form>
      </div>
    </>
  );
};

export { TodoCreateComponent };
