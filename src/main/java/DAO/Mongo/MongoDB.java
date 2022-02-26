package DAO.Mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.ClientSession;

public class MongoDB {
    private static MongoDB instance;
    private String dbName;
    private MongoClient client;
    private DB database;
    private ClientSession session;

    public static MongoDB getInstance(String dbName){
        if (instance == null){
            instance = new MongoDB(dbName);
        }
        return instance;
    }

    private MongoDB(String dbName) {
        connect(dbName);
    }

    private void connect(String dbName){
        client = new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017"));
        session = client.startSession();
        this.database = client.getDB(dbName);
    }

    public void commit(){
        if (session != null){
            session.commitTransaction();
        }
    }

    public DB getDatabase() {
        return database;
    }
}
