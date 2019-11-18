import React from "react";
import { ITodo } from "../interface/ITodo";

interface ITodoRowsProps {
  todos: ReadonlyArray<ITodo>;
}

const TodoComponent: React.FC<ITodoRowsProps> = ({ todos }) => {
  return (
    <>
      <table>
        <thead>
          <tr>
            <th>Priority</th>
            <th>Task</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {todos.map((todo, index) => (
            <tr key={index}>
              <td>{todo.priority}</td>
              <td>{todo.task}</td>
              <td>{todo.todoStatus}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
};

export { TodoComponent };
