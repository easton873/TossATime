package DAO.Mongo;

import DAO.BudgetDao;
import Model.Budget;
import Model.User;
import com.mongodb.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MongoBudgetDao extends MongoDAO implements BudgetDao {
    public MongoBudgetDao(DB database) {
        super(database);
    }

    @Override
    public void insert(Budget budget, User user) {
        collection.insert(convert(budget, user));
    }

    @Override
    public List<Budget> getBudgets(User user) {
        List<Budget> budgets = new ArrayList<>();
        DBCursor cursor = collection.find(convert(user));
        while  (cursor.hasNext()){
            budgets.add(convert(cursor.next()));
        }
        return budgets;
    }

    @Override
    public void delete(Budget budget) {
        collection.remove(convert(budget));
    }

    @Override
    public void update(Budget budget, User user) {
        collection.update(convert(budget), convert(budget, user));
    }

    @Override
    String getCollectionName() {
        return "budget";
    }

    private BasicDBObject convert(Budget budget){
        return new BasicDBObject("id", budget.getBudgetID().toString());
    }

    private BasicDBObject convert(Budget budget, User user){
        return new BasicDBObject("id", budget.getBudgetID().toString()).append("name", budget.getName())
            .append("timestamp", budget.getTimestamp().toString()).append("userID", user.getId());
    }

    private BasicDBObject convert(User user){
        return new BasicDBObject("userID", user.getId());
    }

    private Budget convert(DBObject object){
        return new Budget(UUID.fromString((String) object.get("id")),
            (String) object.get("name"),
            LocalDateTime.parse((String) object.get("timestamp")));
    }
}
