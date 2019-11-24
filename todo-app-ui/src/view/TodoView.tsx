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

  const createTodo = (todo: ITodo) => {
    setTodos([...todos, todo]);
    todoService.postTodo(todo);
  };

  return <TodoComponent todos={todos} createTodo={createTodo}></TodoComponent>;
};

export { TodoView };
