package Request;

import Model.TimeStamp;

public class VoteEventRequest {
    String eventID;
    String name;
    TimeStamp[] times;

    public VoteEventRequest() {
    }

    public VoteEventRequest(String eventID, String name, TimeStamp[] times) {
        this.eventID = eventID;
        this.name = name;
        this.times = times;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimeStamp[] getTimes() {
        return times;
    }

    public void setTimes(TimeStamp[] times) {
        this.times = times;
    }
}
