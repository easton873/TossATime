package Model;

import java.util.UUID;

public class Event {
    String uuid;
    String creator;
    String description;
    String name;

    public Event(String uuid, String creator, String description, String name) {
        this.uuid = uuid;
        this.creator = creator;
        this.description = description;
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
