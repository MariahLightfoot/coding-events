package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank (message="Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters long!")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank (message="Email is required.")
    @Email(message = "Invalid email, try again.")
    private String contactEmail;

    @NotNull(message="Location is required.")
    @NotBlank(message="Location is required.")
    private String location;

    @AssertTrue(message="All events must be registered for!")
    private boolean mustRegister;

    @Min(value = 1, message = "Number of attendees must be greater than zero!")
    private int numberOfAttendees;

    public Event(String name, String description, String contactEmail, String location, boolean mustRegister, int numberOfAttendees) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.mustRegister = mustRegister;
        this.numberOfAttendees = numberOfAttendees;
    }

    public Event(){
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isMustRegister() {
        return mustRegister;
    }

    public void setMustRegister(boolean mustRegister) {
        this.mustRegister = mustRegister;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
