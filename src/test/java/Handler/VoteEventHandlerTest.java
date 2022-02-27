package Handler;

import DAO.Database;
import Model.TimeStamp;
import Request.VoteEventRequest;
import Response.VoteEventResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoteEventHandlerTest {
    VoteEventHandler subj;

    @BeforeEach
    void setUp(){
        Database.init();
        subj = new VoteEventHandler();
    }

    @Test
    void work(){
        TimeStamp[] times = new TimeStamp[2];
        times[0] = new TimeStamp("2022", "2", "3", "3");
        times[1] = new TimeStamp("2022", "2", "3", "4");
        String eventID = "cfaac0a0-8d8c-4a23-908f-ee6180db9fb1";
        VoteEventRequest req = new VoteEventRequest(eventID, "Fred", times);
        VoteEventResponse resp = subj.handle(req);
        assertTrue(resp.isSuccess());
    }
}