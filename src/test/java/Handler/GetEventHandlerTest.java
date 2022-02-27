package Handler;

import DAO.Database;
import Request.GetEventRequest;
import Response.GetEventResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetEventHandlerTest {
    GetEventHandler subj;

    @BeforeEach
    void setup(){
        Database.init();
        subj = new GetEventHandler();
    }

    @Test
    void test(){
        GetEventRequest req = new GetEventRequest("cfaac0a0-8d8c-4a23-908f-ee6180db9fb1");
        GetEventResponse resp = subj.handle(req);
        assertTrue(resp.isSuccess());
        System.out.println(resp);
    }
}