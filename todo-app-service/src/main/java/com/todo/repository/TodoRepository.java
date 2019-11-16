package com.todo.repository;

import com.todo.model.Todo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class TodoRepository {

  private final MongoTemplate mongoTemplate;

  public TodoRepository(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  public List<Todo> findTodos() {
    return mongoTemplate.findAll(Todo.class);
  }
}
