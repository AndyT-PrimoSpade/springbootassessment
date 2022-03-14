package org.generation.SpringBootAssessment.repository;

import org.generation.SpringBootAssessment.repository.entity.TodoList;
import org.springframework.data.repository.CrudRepository;

public interface TodoListRepository extends CrudRepository<TodoList, Integer>{

}
