package DAO.Mongo;

import DAO.CategoryDao;
import Model.Budget;
import Model.Category;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class MongoCategoryDao extends MongoDAO implements CategoryDao {
    public MongoCategoryDao(DB database) {
        super(database);
    }

    @Override
    public void create(Category category, Budget budget) {
        collection.insert(convert(category, budget));
    }

    @Override
    public void update(Category category, Budget budget) {
        collection.update(convert(category), convert(category, budget));
    }

    @Override
    public void delete(Category category) {
        collection.remove(convert(category));
    }

    @Override
    public Category getCategory(Category category) {
        try{
            return convert(collection.find(convert(category)).next());
        } catch (NoSuchElementException e){
            return null;
        }
    }

    @Override
    public List<Category> getCategories(Budget budget) {
        List<Category> categories = new ArrayList<>();
        Cursor cursor = collection.find(convert(budget));
        while(cursor.hasNext()){
            categories.add(convert(cursor.next()));
        }
        return categories;
    }

    @Override
    String getCollectionName() {
        return "category";
    }

    DBObject convert(Category category){
        return new BasicDBObject("id", category.getId().toString());
    }

    DBObject convert(Budget budget){
        return new BasicDBObject("budgetID", budget.getBudgetID().toString());
    }

    DBObject convert(Category category, Budget budget){
        return new BasicDBObject("id", category.getId().toString())
            .append("budgetID", budget.getBudgetID().toString())
            .append("name", category.getName())
            .append("allotment", category.getAllotment());
    }

    Category convert(DBObject object){
        return new Category(UUID.fromString((String) object.get("id")),
            (String) object.get("name"), ((Double) object.get("allotment")).floatValue());
    }
}
