package com.todo.repository;

import com.todo.model.Todo;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class TodoRepository {

  public List<Todo> findTodos() {
    // TODO get data from databse in this case it will be mongoDB
    Todo todo = new Todo();
    List<Todo> todos = new ArrayList<>();
    todos.add(todo);
    return todos;
  }
}
