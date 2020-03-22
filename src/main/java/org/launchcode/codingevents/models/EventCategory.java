package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class EventCategory extends AbstractEntity{

    @NotBlank(message = "Category name cannot be blank!")
    @Size(max = 50, message = "Category name cannot be more than 50 characters!")
    private String name;

    public EventCategory(){

    }

    public EventCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
