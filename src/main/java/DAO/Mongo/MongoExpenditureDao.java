package DAO.Mongo;

import DAO.ExpenditureDao;
import Model.Budget;
import Model.Category;
import Model.Expenditure;
import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MongoExpenditureDao extends MongoDAO implements ExpenditureDao {
    public MongoExpenditureDao(DB database) {
        super(database);
    }

    @Override
    public void createExpenditure(Expenditure expenditure) {
        collection.insert(convert(expenditure, expenditure.getCategory()));
    }

    @Override
    public List<Expenditure> getExpendituresForDay(Budget budget, int year, int month, int day) {
        List<Expenditure> results = new ArrayList<>();
        List<Category> categories = allCategories(budget);
        for (Category c : categories){
            Cursor cursor = collection.find(convert(year, month, day, c));
            while (cursor.hasNext()){
                results.add(convert(cursor.next(), c));
            }
        }
        return results;
    }

    @Override
    public List<Expenditure> getExpendituresAll(Budget budget) {
        List<Expenditure> results = new ArrayList<>();
        List<Category> categories = allCategories(budget);
        for (Category c : categories){
            Cursor cursor = collection.find(convert(c));
            while (cursor.hasNext()){
                results.add(convert(cursor.next(), c));
            }
        }
        return results;
    }

    @Override
    public void delete(Expenditure expenditure) {
        collection.remove(convert(expenditure));
    }

    @Override
    public void update(Expenditure expenditure, Category category) {
        collection.update(convert(expenditure), convert(expenditure, category));
    }

    @Override
    String getCollectionName() {
        return "expenditure";
    }

    private List<Category> allCategories(Budget budget){
        List<Category> categories = new ArrayList<>();
        DBCollection collection = getCollection("category");
        Cursor cursor = collection.find(convert(budget));
        while(cursor.hasNext()){
            categories.add(convertCategory(cursor.next()));
        }
        return categories;
    }

    private DBObject convert(Budget budget){
        return new BasicDBObject("budgetID", budget.getBudgetID().toString());
    }

    private DBObject convert(Category category){
        return new BasicDBObject("categoryID", category.getId().toString());
    }

    private DBObject convert(Expenditure expenditure){
        return new BasicDBObject("id", expenditure.getId().toString());
    }

    private DBObject convert(Expenditure expenditure, Category category){
        return new BasicDBObject("id", expenditure.getId().toString())
            .append("categoryID", category.getId().toString())
            .append("description", expenditure.getDescription())
            .append("amount", expenditure.getAmount())
            .append("year", expenditure.getYear())
            .append("month", expenditure.getMonth())
            .append("day", expenditure.getDay());
    }

    private DBObject convert(int year, int month, int day, Category category){
        return new BasicDBObject("year", year).append("month", month).append("day", day)
            .append("categoryID", category.getId().toString());
    }

    private Expenditure convert(DBObject object, Category category){
        return new Expenditure(UUID.fromString((String) object.get("id")), (String) object.get("description"),
            ((Double) object.get("amount")).floatValue(), (int) object.get("year"), (int) object.get("month"),
            (int) object.get("day"), category);
    }

    Category convertCategory(DBObject object){
        return new Category(UUID.fromString((String) object.get("id")),
            (String) object.get("name"), ((Double) object.get("allotment")).floatValue());
    }
}
