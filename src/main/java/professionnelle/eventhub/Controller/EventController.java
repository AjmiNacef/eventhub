package professionnelle.eventhub.Controller;

import org.springframework.web.bind.annotation.*;
import professionnelle.eventhub.Entite.Event;
import professionnelle.eventhub.Repository.EventRepository;
import professionnelle.eventhub.Service.EventService;
import java.util.List;
@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "*")
public class EventController {
    private EventService eventService;
    public EventController(EventService eventService){
        this.eventService = eventService;
    }
    @GetMapping
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id){
        return eventService.getEventById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }
    @PostMapping
    public Event createEvent(@RequestBody Event event){
        return eventService.createEvent(event);
    }
    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event){
        event.setId(id);
        return eventService.updateEvent(event);
    }
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id){
        eventService.deleteEvent(id);
    }
}
