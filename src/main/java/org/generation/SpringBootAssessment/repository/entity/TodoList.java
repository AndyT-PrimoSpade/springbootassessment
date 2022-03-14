package org.generation.SpringBootAssessment.repository.entity;

import org.generation.SpringBootAssessment.controller.dto.TodoDTO;
import javax.persistence.*;

@Entity
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String targetDate;

    public TodoList() {}

    public TodoList(TodoDTO todoDTO) {

        this.title = todoDTO.getTitle();
        this.description = todoDTO.getDescription();
        this.targetDate = todoDTO.getTargetDate();
    }

    public Integer getId()
    {
        return id;
    }
    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTitle( String title )
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }
    public void setDescription( String description )
    {
        this.description = description;
    }

    public String getTargetDate() { return targetDate; }
    public void setTargetDate( String targetDate )
    {
        this.targetDate = targetDate;
    }


    @Override
    public String toString()
    {
        return "Item{" + "title=" + title + '\'' + ", description='" + description + '\'' + ", targetDate='"
                + targetDate + '}';
    }
}
