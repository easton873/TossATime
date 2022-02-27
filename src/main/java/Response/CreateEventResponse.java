package Response;

public class CreateEventResponse extends Response {
    private String eventID;

    public CreateEventResponse(String id) {
        super();
        eventID = id;
    }

    public CreateEventResponse(String message, boolean success) {
        super(message);
    }
}
