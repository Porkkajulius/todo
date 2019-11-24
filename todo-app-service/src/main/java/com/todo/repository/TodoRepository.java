package com.todo.repository;

import com.todo.model.Todo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class TodoRepository {

  private static final String COLLECTION = "Todo";

  private final MongoTemplate mongoTemplate;

  public TodoRepository(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  public List<Todo> findAll() {
    return mongoTemplate.findAll(Todo.class, COLLECTION);
  }

  public Todo save(Todo todo) {
    return mongoTemplate.save(todo, COLLECTION);
  }
}
