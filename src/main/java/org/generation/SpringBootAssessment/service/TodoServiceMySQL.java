package org.generation.SpringBootAssessment.service;

import org.generation.SpringBootAssessment.repository.TodoListRepository;
import org.generation.SpringBootAssessment.repository.entity.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoServiceMySQL implements TodoService {

    private final TodoListRepository todoListRepository;

    public TodoServiceMySQL(@Autowired TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public TodoList save (TodoList todoList){
        return todoListRepository.save(todoList);
    }

    @Override
    public  void delete ( int itemId ){
        todoListRepository.deleteById(itemId);
    }

    @Override
    public List<TodoList> all(){
        List<TodoList> result = new ArrayList<>();
        todoListRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public TodoList findById (int itemId ){
        Optional<TodoList> item = todoListRepository.findById(itemId);
        TodoList todoListResponse = item.get();
        return todoListResponse;
    }
}
