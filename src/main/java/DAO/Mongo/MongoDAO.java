package DAO.Mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public abstract class MongoDAO {
    private DB database;
    protected DBCollection collection;

    public MongoDAO(DB database) {
        this.database = database;
        collection = getCollection();
    }

    abstract String getCollectionName();
    private DBCollection getCollection(){
        return database.getCollection(getCollectionName());
    }

    protected DBCollection getCollection(String collectionName){
        return database.getCollection(collectionName);
    }
}
