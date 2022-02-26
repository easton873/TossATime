package DAO;

import Model.Time;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class TimeDaoTest {
    private TimeDao timeDao;

    @BeforeEach
    void setUp(){
        Database.init();
        timeDao = new TimeDao();
    }

    @Test
    void test(){
        Time time = new Time(null, "event_id", "2022", "2", "26", "3");
        timeDao.create(time);
        List<Time> times = timeDao.readTimes(time.getEventID());
        Assertions.assertEquals(1, times.size());
    }
}