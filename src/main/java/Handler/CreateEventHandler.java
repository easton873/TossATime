package Handler;

import DAO.Database;
import Model.Event;
import Model.Time;
import Model.TimeStamp;
import Request.CreateEventRequest;
import Response.CreateEventResponse;

import java.util.UUID;

public class CreateEventHandler extends Handler<CreateEventRequest, CreateEventResponse> {

    @Override
    protected CreateEventResponse handle(CreateEventRequest request) {
        String eventID = UUID.randomUUID().toString();
        Database.getInstance().getEventDao().create(new Event(
            eventID, request.getCreator(), request.getDescription(), request.getName()
        ));
        for (TimeStamp ts : request.getTimes()){
            Database.getInstance().getTimeDao().create(new Time(
                null, eventID, ts.getYear(), ts.getMonth(), ts.getDay(), ts.getHour()
            ));
        }
        return new CreateEventResponse();
    }

    @Override
    protected CreateEventResponse fail(Exception e) {
        return new CreateEventResponse(e.getMessage());
    }

    @Override
    protected CreateEventRequest emptyRequest() {
        return new CreateEventRequest();
    }
}
