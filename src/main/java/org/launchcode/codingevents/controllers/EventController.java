package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {

    @GetMapping("events")
    public String displayAllEvents(Model model){
        List<String> events = new ArrayList<>();
        events.add("Code with Pride");
        events.add("Code till Dawn");
        events.add("Strange Loop");

        model.addAttribute("events", events);

        return"events/index";
    }
}
