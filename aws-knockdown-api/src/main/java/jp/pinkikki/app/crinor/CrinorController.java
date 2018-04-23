package jp.pinkikki.app.crinor;

import jp.pinkikki.domain.event.entity.Event;
import jp.pinkikki.domain.event.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("crinor")
public class CrinorController {

    private final EventService eventService;

    public CrinorController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("eventall")
    public Stream<Event> eventAll() {
        return eventService.findAll();
    }
}
