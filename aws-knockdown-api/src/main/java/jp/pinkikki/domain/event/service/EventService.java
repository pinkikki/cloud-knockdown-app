package jp.pinkikki.domain.event.service;

import jp.pinkikki.domain.event.dao.EventDao;
import jp.pinkikki.domain.event.entity.Event;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class EventService {

    EventDao eventDao;

    public EventService(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public Stream<Event> findAll() {
        return eventDao.findAll();
    }
}
