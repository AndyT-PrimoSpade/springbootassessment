package org.generation.SpringBootAssessment.service;

import org.generation.SpringBootAssessment.repository.entity.TodoList;

import java.util.List;

public interface TodoService {

    TodoList save(TodoList todoList);

    void delete(int itemId);

    List<TodoList> all();

    TodoList findById(int itemId);
}


