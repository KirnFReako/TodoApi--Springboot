package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.deser.jdk.AtomicBooleanDeserializer;

import java.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController  // it is a combination of two annotation controller and response body
// it will act as controller point of your project , collecting the request and responding to request
@RequestMapping("/api/v1/todos")
public class TodoController {



    private TodoService todoService1;

    private TodoService todoService2;

    private static List<Todo> todoList;

    public TodoController( @Qualifier("FakeTodoService") TodoService todoService1,
                           @Qualifier("anotherTodoService") TodoService todoService2){
       this.todoService1= todoService1;
       this.todoService2 = todoService2;
        todoList  = new ArrayList<>();
        todoList.add(new Todo(1,false, "Todo 1",1));
        todoList.add(new Todo(2,true,"Todo 2",2));


    }


@GetMapping
    public ResponseEntity<List<Todo>> getTodos(@RequestParam(required = false) Boolean isCompleted){

       System.out.println("Incoming query param: "  + isCompleted + " " + this.todoService1.doSomething() );
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
