package Response;

import Model.Time;
import Model.TimeStamp;
import Model.Vote;

import java.util.Arrays;

public class GetEventResponse extends Response{
    String eventID;
    String eventName;
    String creator;
    String description;
    Time[] hostTimes;
    Vote[] votes;

    public GetEventResponse(String message) {
        super(message);
    }

    public GetEventResponse() {
        super();
    }

    public GetEventResponse(String eventID, String eventName, String creator, String description, Time[] hostTimes, Vote[] votes) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.creator = creator;
        this.description = description;
        this.hostTimes = hostTimes;
        this.votes = votes;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time[] getHostTimes() {
        return hostTimes;
    }

    public void setHostTimes(Time[] hostTimes) {
        this.hostTimes = hostTimes;
    }

    public Vote[] getVotes() {
        return votes;
    }

    public void setVotes(Vote[] votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "GetEventResponse{" +
            "eventID='" + eventID + '\'' +
            ", eventName='" + eventName + '\'' +
            ", creator='" + creator + '\'' +
            ", description='" + description + '\'' +
            ", hostTimes=" + Arrays.toString(hostTimes) +
            ", votes=" + Arrays.toString(votes) +
            '}';
    }
}
