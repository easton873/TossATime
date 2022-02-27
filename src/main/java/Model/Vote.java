package Model;

public class Vote {
    String id;
    String eventID;
    String name;
    String year;
    String month;
    String day;
    String hour;

    public Vote(String id, String eventID, String name, String year, String month, String day, String hour) {
        this.id = id;
        this.eventID = eventID;
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
    }

    public String getId() {
        return id;
    }

    public String getEventID() {
        return eventID;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getHour() {
        return hour;
    }
}
