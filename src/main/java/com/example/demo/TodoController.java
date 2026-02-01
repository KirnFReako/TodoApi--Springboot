package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController  // it is a combination of two annotation controller and response body
// it will act as controller point of your project , collecting the request and responding to request
public class TodoController {

    private static List<Todo> todos;

    public TodoController(){
        todos  = new ArrayList<>();
        todos.add(new Todo(1,false, "Todo 1",1));
        todos.add(new Todo(2,true,"Todo 2",2));
    }
}
