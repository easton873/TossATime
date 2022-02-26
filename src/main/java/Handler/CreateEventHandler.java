package Handler;

import Request.CreateEventRequest;
import Response.CreateEventResponse;

public class CreateEventHandler extends Handler<CreateEventRequest, CreateEventResponse> {

    @Override
    protected CreateEventResponse handle(CreateEventRequest request) {
        System.out.println("Success");
        System.out.println(request);
        return null;
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
