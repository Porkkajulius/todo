package com.todo.controller;

import com.todo.dto.TodoDto;
import com.todo.exception.ErrorMessages;
import com.todo.exception.ErrorResponse;
import com.todo.model.Todo;
import com.todo.service.TodoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Validated
@RequestMapping("/api/v1/todos")
public class TodoController {

  private final TodoService todoService;

  public TodoController (final TodoService todoService) {
    this.todoService = todoService;
  }

  @ApiOperation("Find all Todo objects")
  @ApiResponses({
      @ApiResponse(code = 200, message = "List of Todos.", response = Todo.class, responseContainer = "List"),
      @ApiResponse(code = 400, message = ErrorMessages.BAD_REQUEST, response = ErrorResponse.class),
      @ApiResponse(code = 403, message = ErrorMessages.FORBIDDEN),
      @ApiResponse(code = 404, message = ErrorMessages.NOT_FOUND)
  })
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<TodoDto>> findAll() {
    return ResponseEntity.ok(todoService.findTodos());
  }

  @ApiOperation("Save a new Todo")
  @ApiResponses({
      @ApiResponse(code = 201, message = "Todo was successfully created.", response = TodoDto.class),
      @ApiResponse(code = 400, message = ErrorMessages.BAD_REQUEST, response = ErrorResponse.class),
      @ApiResponse(code = 403, message = ErrorMessages.FORBIDDEN)
  })
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TodoDto> save(@RequestBody @Valid TodoDto todoDto) {
    return new ResponseEntity<>(todoService.save(todoDto), HttpStatus.CREATED);
  }
}
