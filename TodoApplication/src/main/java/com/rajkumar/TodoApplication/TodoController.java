package com.rajkumar.TodoApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    List<Todo> todoList;

    //add TODOs -PostAPI

    //add a todo
    @PostMapping("todo/add")
    public String addTodo(@RequestBody Todo mytodo)
    {

        todoList.add(mytodo);
        return "Todo Added Successfully";

    }

    // get api
    //get all todos
    @GetMapping("todo/show")
    public List<Todo> getAllTodo()
    {

        return todoList;
    }

    //delet todo by Id
    @PutMapping("todo/id/{id}/Status")
    public String setTodoStatusById(@PathVariable Integer id, @RequestParam boolean flag)
    {
        for(Todo todo : todoList){
            if(todo.getTodoId().equals(id)){
                todo.setTodoStatus(flag);
                return "todo: "+ id +" updated to "+ flag;
            }
        }
        return "invalid Id";
    }


}
