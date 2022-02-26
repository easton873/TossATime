package DAO.Mongo;

import DAO.*;

public class DatabaseManager implements DaoFactory {
    private DaoFactory factory;
    public static String DB_NAME = "smartbudget";
    private static DatabaseManager instance;

    private DatabaseManager(String dbName) {
        factory = new MongoDAOFactory(MongoDB.getInstance(dbName).getDatabase());
    }

    public void commit(){
        MongoDB.getInstance(DB_NAME).commit();
    }

    public static DatabaseManager getInstance(String dbName){
        if (instance == null){
            instance = new DatabaseManager(dbName);
        }
        return instance;
    }

    public static DatabaseManager getInstance(){
        if (instance == null){
            instance = new DatabaseManager(DB_NAME);
        }
        return instance;
    }

    @Override
    public UserDao createUserDao() {
        return factory.createUserDao();
    }

    @Override
    public BudgetDao createBudgetDao() {
        return factory.createBudgetDao();
    }

    @Override
    public CategoryDao createCategoryDao() {
        return factory.createCategoryDao();
    }

    @Override
    public ExpenditureDao createExpenditureDao() {
        return factory.createExpenditureDao();
    }
}
