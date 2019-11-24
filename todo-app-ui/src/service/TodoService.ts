import HttpUtil from "../util/HttpUtil";
import * as config from "../config/uriConfig.json";
import { ITodo } from "../interface/ITodo";

const useTodoService = () => {
  const { fetchGet, fetchPost } = HttpUtil.useHttpService();
  return {
    getTodos: async () => {
      const result = await fetchGet(config.todoURI);
      const todos: ITodo[] = await result.json();
      return todos.map((i: ITodo) => i);
    },
    postTodo: async (body: ITodo) => {
      const result = await fetchPost(config.todoURI, body);
      return result;
    }
  };
};

const TodoService = {
  useTodoService
};

export default TodoService;
