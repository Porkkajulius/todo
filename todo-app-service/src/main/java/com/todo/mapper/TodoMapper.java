package com.todo.mapper;

import com.todo.dto.TodoDto;
import com.todo.model.Todo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

  private final ModelMapper modelMapper;

  public TodoMapper(ModelMapper modelMapper) { this.modelMapper = modelMapper; }

  public Todo mapToModel(final TodoDto todoDto) {
    return modelMapper.map(todoDto, Todo.class);
  }

  public TodoDto mapToDto(final Todo todo) {
    return modelMapper.map(todo, TodoDto.class);
  }
}
