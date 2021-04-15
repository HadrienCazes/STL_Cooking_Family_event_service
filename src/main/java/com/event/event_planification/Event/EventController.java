package com.event.event_planification.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/Event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/all")
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    @GetMapping("/get/{id}")
    public Optional<Event> getEventByID(@PathVariable Integer id){
        return eventService.getEventbyID(id);
    }

    @PostMapping(path = "/post")
    public void addEvent(@RequestBody Event event) {
        eventService.saveEvent(event);
    }

    @DeleteMapping(path = "/delete/{eventid}")
    public void deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
    }
}
