package DAO;

import Exceptions.DataAccessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database instance;

    private List<DAO> daos;
    private EventDao eventDao;
    private VoteDao voteDao;
    private TimeDao timeDao;

    private Database(){
        daos = new ArrayList<>();
        eventDao = new EventDao();
        daos.add(eventDao);
        voteDao = new VoteDao();
        daos.add(voteDao);
        timeDao = new TimeDao();
        daos.add(timeDao);
    }

    public EventDao getEventDao() {
        return eventDao;
    }

    public VoteDao getVoteDao() {
        return voteDao;
    }

    public TimeDao getTimeDao() {
        return timeDao;
    }

    public static void init(){
        instance = new Database();
        instance.createTables();
    }

    public static Database getInstance(){
        return instance;
    }

    private Connection conn;

    public static void execute(String sql){
        try {
            Database.getInstance().getConnection().createStatement().execute(sql);
            Database.getInstance().closeConnection(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public Connection openConnection() throws DataAccessException {
        try {
            final String CONNECTION_URL = "jdbc:sqlite:database.sqlite";

            conn = DriverManager.getConnection(CONNECTION_URL);

            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Unable to open connection to database");
        }

        return conn;
    }

    public Connection getConnection() throws DataAccessException {
        if(conn == null) {
            return openConnection();
        } else {
            return conn;
        }
    }

    public void closeConnection(boolean commit) throws DataAccessException {
        try {
            if (commit) {
                conn.commit();
            } else {
                conn.rollback();
            }

            conn.close();
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Unable to close database connection");
        }
    }

    public void clearTables() throws DataAccessException {

        try (Statement stmt = conn.createStatement()) {
            String sql = "DELETE FROM Events";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new DataAccessException("SQL Error encountered while clearing tables");
        }
    }

    public void createTables() {
        for (DAO dao : daos){
            dao.createTable();
        }
    }

    public void clearAll() throws DataAccessException{

    }

    public void dropTables() throws DataAccessException {
        try (Statement stmt = conn.createStatement()) {
            String sql = "drop table if exists user;\ndrop table if exists person;\ndrop table if exists event;\ndrop table if exists authToken;";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }
    }
}
