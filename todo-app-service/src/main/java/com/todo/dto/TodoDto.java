package com.todo.dto;

import com.todo.model.TodoStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDto {
  private String task;
  private String priority;
  private TodoStatus todoStatus;
}
