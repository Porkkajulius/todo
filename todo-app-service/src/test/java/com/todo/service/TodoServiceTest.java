package com.todo.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import com.todo.dto.TodoDto;
import com.todo.mapper.TodoMapper;
import com.todo.model.Todo;
import com.todo.repository.TodoRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

@Slf4j
public class TodoServiceTest {

  private static final String PRIORITY = "Do it fast or wife doesn't like";

  @Mock
  private TodoRepository todoRepository;
  private ModelMapper modelMapper;
  private TodoMapper todoMapper;
  private TodoService todoService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    modelMapper = new ModelMapper();
    todoMapper = new TodoMapper(modelMapper);
    todoService = new TodoService(todoRepository, todoMapper);
  }

  @Test
  public void saveTest() {
    Todo todo = Todo.builder()
        .priority(PRIORITY)
        .build();

    TodoDto todoDto = TodoDto.builder()
        .priority(PRIORITY)
        .build();

    Mockito.when(todoRepository.save(any(Todo.class))).thenReturn(todo);
    TodoDto savedTodoDto = todoService.save(todoDto);
    assertEquals(PRIORITY, savedTodoDto.getPriority());
  }

  @Test
  public void findAllTest() {
    // Create List with one object
    List<Todo> todos = new ArrayList<>();
    todos.add(Todo.builder()
        .priority(PRIORITY)
        .build());

    Mockito.when(todoRepository.findAll()).thenReturn(todos);
    List<TodoDto> todoDtos = todoService.findAll();
    assertEquals(PRIORITY, todoDtos.get(0).getPriority());
  }
}
