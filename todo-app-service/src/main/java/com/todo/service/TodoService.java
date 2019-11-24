package com.todo.service;

import com.todo.dto.TodoDto;
import com.todo.mapper.TodoMapper;
import com.todo.model.Todo;
import com.todo.repository.TodoRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TodoService {

  private final TodoRepository todoRepository;
  private final TodoMapper todoMapper;

  public TodoService(TodoRepository todoRepository, TodoMapper todoMapper) {
    this.todoRepository = todoRepository;
    this.todoMapper = todoMapper;
  }

  public List<TodoDto> findAll() {
    return todoRepository.findAll()
        .stream()
        .map(todoMapper::mapToDto)
        .collect(Collectors.toList());
  }

  public TodoDto save(TodoDto todoDto) {
    final Todo todo = todoRepository.save(todoMapper.mapToModel(todoDto));
    return todoMapper.mapToDto(todo);
  }
}
