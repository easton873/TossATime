package DAO;

import Model.Time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TimeDao implements DAO<Time> {
    @Override
    public void createTable() {
        String sql = "create table if not exists time(\n" +
            "time_id varchar(255) primary key unique not null,\n" +
            "event_id varchar(255) not null,\n" +
            "time_year varchar(255) not null,\n" +
            "time_month varchar(255) not null,\n" +
            "time_day varchar(255) not null,\n" +
            "time_hour varchar(255) not null,\n" +
            "foreign key(event_id) references event(event_id)\n" +
            ");";
        Database.execute(sql);
    }

    @Override
    public boolean create(Time time) {
        String sql = "INSERT INTO time (time_id,event_id,time_year,time_month,time_day,time_hour) values (?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = Database.getInstance().getConnection().prepareStatement(sql);
            stmt.setString(1, UUID.randomUUID().toString());
            stmt.setString(2, time.getEventID());
            stmt.setString(3, time.getYear());
            stmt.setString(4, time.getMonth());
            stmt.setString(5, time.getDay());
            stmt.setString(6, time.getHour());
            stmt.execute();
            Database.getInstance().closeConnection(true);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Time> readTimes(String eventID){
        String sql = "SELECT * FROM time WHERE event_id=?";
        List<Time> votes = new ArrayList<>();
        try {
            PreparedStatement stmt = Database.getInstance().getConnection().prepareStatement(sql);
            stmt.setString(1, eventID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                votes.add(new Time(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                ));
            }
            Database.getInstance().closeConnection(true);
            return votes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Time read(String id) {
        return null;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }
}
