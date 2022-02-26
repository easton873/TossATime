package DAO.Mongo;

import DAO.UserDao;
import Model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBObject;

import java.util.NoSuchElementException;
import java.util.UUID;

public class MongoUserDao extends MongoDAO implements UserDao {
    public MongoUserDao(DB database) {
        super(database);
    }

    @Override
    String getCollectionName() {
        return "user";
    }

    @Override
    public void createUser(User user) {
        collection.insert(convert(user));
    }

    @Override
    public void updateUser(User user) {
        collection.update(idConvert(user), convert(user));
    }

    @Override
    public void deleteUser(String id) {
        collection.remove(idConvert(id));
    }

    @Override
    public User getUser(String username, String password) {
        try {
            return convert(collection.find(usernamePasswordConvert(username, password)).next());
        } catch (NoSuchElementException e) {
            throw new RuntimeException("No user found");
        }
    }

    private User convert(DBObject object){
        return new User(UUID.fromString((String)object.get("userID")), (String) object.get("username"), (String) object.get("password"));
    }

    private DBObject convert(User user){
        return new BasicDBObject("userID", user.getId().toString()).append("username", user.getUsername())
            .append("password", user.getPassword());
    }

    private DBObject idConvert(User user){
        return new BasicDBObject("userID", user.getId().toString());
    }

    private DBObject idConvert(String id){
        return new BasicDBObject("userID", id.toString());
    }

    private DBObject usernamePasswordConvert(String username, String pasword){
        return new BasicDBObject("username", username)
            .append("password", pasword);
    }
}
