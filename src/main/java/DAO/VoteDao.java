package DAO;

import Exceptions.DataAccessException;
import Model.Vote;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VoteDao implements DAO<Vote> {
    @Override
    public void createTable() {
        String sql = "create table if not exists vote(\n" +
            "vote_id varchar(255) primary key unique not null,\n" +
            "event_id varchar(255) not null,\n" +
            "vote_name varchar(255) not null,\n" +
            "vote_year varchar(255) not null,\n" +
            "vote_month varchar(255) not null,\n" +
            "vote_day varchar(255) not null,\n" +
            "vote_hour varchar(255) not null,\n" +
            "foreign key(event_id) references event(event_id)\n" +
            ");";
        Database.execute(sql);
    }

    @Override
    public String create(Vote vote) {
        String sql = "INSERT INTO vote (vote_id,event_id,vote_name,vote_year,vote_month,vote_day,vote_hour) values (?,?,?,?,?,?,?)";
        String id = UUID.randomUUID().toString();
        try {
            PreparedStatement stmt = Database.getInstance().getConnection().prepareStatement(sql);
            stmt.setString(1, id);
            stmt.setString(2, vote.getEventID());
            stmt.setString(3, vote.getName());
            stmt.setString(4, vote.getYear());
            stmt.setString(5, vote.getMonth());
            stmt.setString(6, vote.getDay());
            stmt.setString(7, vote.getHour());
            stmt.execute();
            Database.getInstance().closeConnection(true);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Vote> readVotes(String eventID){
        String sql = "SELECT * FROM vote WHERE event_id=?";
        List<Vote> votes = new ArrayList<>();
        try {
            PreparedStatement stmt = Database.getInstance().getConnection().prepareStatement(sql);
            stmt.setString(1, eventID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                votes.add(new Vote(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
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
    public Vote read(String id) {
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
