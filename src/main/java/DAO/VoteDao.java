package DAO;

import Model.Vote;

public class VoteDao implements DAO<Vote> {
    @Override
    public void createTable() {
        String sql = "create table if not exists vote(\n" +
            "vote_id varchar(255) primary key unique not null,\n" +
            "event_id varchar(255) not null,\n" +
            "vote_name varchar(255) not null,\n" +
            "vote_time varchar(255) not null,\n" +
            "foreign key(event_id) references event(event_id)\n" +
            ");";
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public Vote read() {
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
