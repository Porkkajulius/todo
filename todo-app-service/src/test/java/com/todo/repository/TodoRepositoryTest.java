package com.todo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.todo.model.Todo;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoTemplate;

public class TodoRepositoryTest {

  private static final String COLLECTION = "Todo";

  Todo todo = new Todo();
  List<Todo> todos = new ArrayList<>();

  @Mock
  private MongoTemplate mongoTemplate;
  private TodoRepository todoRepository;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    todoRepository = new TodoRepository(mongoTemplate);
  }

  @Test
  public void saveTest() {
    Mockito.when(mongoTemplate.save(todo, COLLECTION)).thenReturn(todo);
    assertEquals (todo, todoRepository.save(todo));
  }

  @Test
  public void findAllTest() {
    Mockito.when(mongoTemplate.findAll(Todo.class, COLLECTION)).thenReturn(todos);
    assertEquals (todos, todoRepository.findAll());
  }
}
