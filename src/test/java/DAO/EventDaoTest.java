package DAO;

import Exceptions.DataAccessException;
import Model.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventDaoTest {
    private EventDao eventDao;
    @BeforeEach
    void setUp(){
        Database.init();
        eventDao = new EventDao();
    }

    @Test
    void test() {
        eventDao.create(new Event(null, "testGuy", "what an event", "AnEvent"));
        Event event = eventDao.read("e28f4309-6c6f-4caa-8f99-80108b9545a9");
        assertEquals("AnEvent", event.getName());
    }
}