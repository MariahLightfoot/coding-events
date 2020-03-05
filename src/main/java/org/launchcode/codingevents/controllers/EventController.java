package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.HashMap;

@Controller
public class EventController {

    HashMap<String, String> events = new HashMap<String, String>();

    @GetMapping("events")
    public String displayAllEvents(Model model){
        events.put("StrangeLoop", "Multi-disciplinary conference.");
        events.put("Code Til Dawn", "Code until the sun comes up!");
        events.put("Code with Pride", "Support for LGBTQ coders.");

        model.addAttribute("events", events);
        model.addAttribute("eventNames", events.keySet());
        model.addAttribute("eventDescriptions", events.values());

        return"events/index";
    }
}
