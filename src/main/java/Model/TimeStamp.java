package Model;

public class TimeStamp {
    String year;
    String month;
    String day;
    String hour;

    public TimeStamp() {
    }

    public TimeStamp(String year, String month, String day, String hour) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
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
