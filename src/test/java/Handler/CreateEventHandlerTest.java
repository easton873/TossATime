package Handler;

import DAO.Database;
import Model.TimeStamp;
import Request.CreateEventRequest;
import Response.CreateEventResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateEventHandlerTest {

    CreateEventHandler subj;

    @BeforeEach
    void setUp(){
        Database.init();
        subj = new CreateEventHandler();
    }

    @Test
    void works(){
        TimeStamp[] times = new TimeStamp[2];
        times[0] = new TimeStamp("2022", "2", "3", "3");
        times[1] = new TimeStamp("2022", "2", "3", "4");
        CreateEventRequest request = new CreateEventRequest("jimbo", "a good event", "Hackathon", times);
        CreateEventResponse resp = subj.handle(request);
        assertTrue(resp.isSuccess());
    }

}