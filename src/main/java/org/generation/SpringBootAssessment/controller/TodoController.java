package org.generation.SpringBootAssessment.controller;

import org.generation.SpringBootAssessment.controller.dto.TodoDTO;
import org.generation.SpringBootAssessment.repository.entity.*;
import org.generation.SpringBootAssessment.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/list")

public class TodoController {


    private final TodoService todoService;

    public TodoController(@Autowired TodoService todoService)
    {
        this.todoService = todoService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<TodoList> getItems()
    {
        return todoService.all();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public TodoList findItemById(@PathVariable Integer id )
    {
        return todoService.findById( id );
    }

    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id ) { todoService.delete( id ); }

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="title", required = true) String title,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="targetDate", required = true) String targetDate){
        TodoDTO todoDto = new TodoDTO(title, description, targetDate);
        todoService.save(new TodoList(todoDto));
    }

}
