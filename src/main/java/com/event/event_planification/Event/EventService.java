package com.event.event_planification.Event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

//    @Autowired
//    public BookService(EventRepository eventRepository, ConsumeService consumeService) {
//        this.eventRepository = eventRepository;
//        this.consumeService = consumeService;
//    }

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping
    public List<Event> getEvents(){
        return eventRepository.findAll();
    }

    public Optional<Event> getEventbyID(Integer id) {
        return eventRepository.findById(id);
    }

    public void saveEvent(Event e){
        eventRepository.save(e);
    }

    public void deleteEvent(Integer id){
        if (!eventRepository.existsById(id)){
            throw new IllegalStateException("event with id " + id + " not found");
        }
        eventRepository.deleteById(id);
    }
}
