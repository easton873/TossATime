package Request;

import Model.TimeStamp;

public class CreateEventRequest {
    String creator;
    String description;
    String name;
    TimeStamp[] times;

    public CreateEventRequest() {
    }

    public CreateEventRequest(String creator, String description, String name, TimeStamp[] times) {
        this.creator = creator;
        this.description = description;
        this.name = name;
        this.times = times;
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

    public TimeStamp[] getTimes() {
        return times;
    }

    public void setTimes(TimeStamp[] times) {
        this.times = times;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
