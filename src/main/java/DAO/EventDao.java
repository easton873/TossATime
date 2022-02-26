package DAO;

import Exceptions.DataAccessException;
import Model.Event;

import java.sql.SQLException;

public class EventDao implements DAO<Event> {
    @Override
    public void createTable() throws DataAccessException {
        String sql = "create table if not exists event(\n" +
            "event_id varchar(255) primary key unique not null,\n" +
            "event_name varchar(255) not null,\n" +
            "event_creator varchar(255) not null,\n" +
            "event_description varchar(255) not null\n" +
            ");\n";
        try {
            Database.getInstance().openConnection().createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean create() throws DataAccessException {
        return false;
    }

    @Override
    public Event read() throws DataAccessException {
        return null;
    }

    @Override
    public boolean update() throws DataAccessException {
        return false;
    }

    @Override
    public boolean delete() throws DataAccessException {
        return false;
    }
}
