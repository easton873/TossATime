package DAO.Mongo;

import DAO.*;
import com.mongodb.DB;

public class MongoDAOFactory implements DaoFactory {
    private DB database;

    public MongoDAOFactory(DB database) {
        this.database = database;
    }

    @Override
    public UserDao createUserDao() {
        return new MongoUserDao(database);
    }

    @Override
    public BudgetDao createBudgetDao() {
        return new MongoBudgetDao(database);
    }

    @Override
    public CategoryDao createCategoryDao() {
        return new MongoCategoryDao(database);
    }

    @Override
    public ExpenditureDao createExpenditureDao() {
        return new MongoExpenditureDao(database);
    }
}
