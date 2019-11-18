import React, { useState, useEffect } from "react";
import { ITodo } from "../interface/ITodo";
import TodoService from "../service/TodoService";
import { TodoComponent } from "../component/TodoComponent";

const TodoView: React.FC = () => {
  const [todos, setTodos] = useState<ReadonlyArray<ITodo>>([]);
  const todoService = TodoService.useTodoService();

  useEffect(() => {
    const fetchTodos = async () => {
      setTodos(await todoService.getTodos());
    };
    fetchTodos();
  }, [todoService]);

  return <TodoComponent todos={todos}></TodoComponent>;
};

export { TodoView };
