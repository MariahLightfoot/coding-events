package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model){

        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());

        return"events/index";
    }

    @GetMapping("create")
    public String renderCreteEventForm(Model model){

        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());

        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@ModelAttribute @Valid Event newEvent, Errors errors, Model model){

        if(errors.hasErrors()){

            model.addAttribute("title", "Create Event");

            return "events/create";
        }

        EventData.add((newEvent));

        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){

        model.addAttribute("title", "Delete Event");
        model.addAttribute("events", EventData.getAll());

        return "events/delete";
    }

    @PostMapping("delete")
    public String renderDeleteEventForm(@RequestParam(required=false) int[] eventIds){

        if(eventIds != null){
            for(int id : eventIds){
                EventData.remove(id);
            }
        }

        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId){

        Event chosenEvent = EventData.getById(eventId);

        model.addAttribute("title", "Edit Event " + chosenEvent.getName() + " (id=" + eventId + ")");
        model.addAttribute("event", chosenEvent);
        model.addAttribute("edit", EventData.getById(eventId));


        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditFrom(int eventId, String name, String description){

        Event chosenEvent = EventData.getById(eventId);

        chosenEvent.setName(name);
        chosenEvent.setDescription(description);

        return "redirect:";

    }
}


















