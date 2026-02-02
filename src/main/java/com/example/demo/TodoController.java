package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController  // it is a combination of two annotation controller and response body
// it will act as controller point of your project , collecting the request and responding to request
@RequestMapping("/api/v1/todos")
public class TodoController {

    private static List<Todo> todoList;

    public TodoController(){
        todoList  = new ArrayList<>();
        todoList.add(new Todo(1,false, "Todo 1",1));
        todoList.add(new Todo(2,true,"Todo 2",2));
    }
@GetMapping
    public ResponseEntity<List<Todo>> getTodos(){
        return ResponseEntity.ok(todoList);
}

@PostMapping
//@ResponseStatus(HttpStatus.CREATED) // at creation of new object it will show status code 201
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
        todoList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
}

@GetMapping("/{todoId}")
    public ResponseEntity<?> getTodoById(@PathVariable Long todoId) {
    for (Todo todo : todoList) {
        if (Objects.equals(todo.getId(), todoId)) {
            return ResponseEntity.ok(todo);
        }
    }

        Map<String, Object> error = new HashMap<>();
        error.put("messsage", "Todo with Id : " + todoId + " not found");
        error.put("status", HttpStatus.NOT_FOUND.value());


        // along with 404, trying to send json file
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }




}
