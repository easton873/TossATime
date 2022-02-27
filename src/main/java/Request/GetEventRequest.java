package Request;

public class GetEventRequest {
    String eventID;

    public GetEventRequest() {
    }

    public GetEventRequest(String eventID) {
        this.eventID = eventID;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }
}
