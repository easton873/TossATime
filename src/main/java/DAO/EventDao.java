package DAO;

import Exceptions.DataAccessException;
import Model.Event;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class EventDao implements DAO<Event> {
    @Override
    public void createTable() {
        String sql = "create table if not exists event(\n" +
            "event_id varchar(255) primary key unique not null,\n" +
            "event_name varchar(255) not null,\n" +
            "event_creator varchar(255) not null,\n" +
            "event_description varchar(255) not null\n" +
            ");\n";
        Database.execute(sql);
    }

    @Override
    public boolean create(Event event) {
        String sql = "INSERT INTO event (event_id,event_name,event_creator,event_description) values (?,?,?,?)";
        try {
            PreparedStatement stmt = Database.getInstance().getConnection().prepareStatement(sql);
            stmt.setString(1, event.getUuid());
            stmt.setString(2, event.getName());
            stmt.setString(3, event.getCreator());
            stmt.setString(4, event.getDescription());
            stmt.execute();
            Database.getInstance().closeConnection(true);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Event read(String id) {
        String sql = "SELECT * FROM event WHERE event_id=?";
        try {
            PreparedStatement stmt = Database.getInstance().getConnection().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new Event(rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(2));
            }
            Database.getInstance().closeConnection(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
