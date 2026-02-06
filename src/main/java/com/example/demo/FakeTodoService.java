package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("FakeTodoService")

public class FakeTodoService implements TodoService {

    @TimeMonitor

    public String doSomething() {

        for (int i = 0; i < 1000000; i++) {}
            return "Something";  // join point
        }

    }

