package DAO.Mongo;

import DAO.CategoryDao;
import DAO.ExpenditureDao;
import Model.Budget;
import Model.Category;
import Model.Expenditure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MongoExpenditureDaoTest extends MongoDaoTest{
    private ExpenditureDao dao;
    private CategoryDao categoryDao;

    @BeforeEach
    void setUp(){
        dao = DatabaseManager.getInstance().createExpenditureDao();
        categoryDao = DatabaseManager.getInstance().createCategoryDao();
    }

    @Test
    void expenditureDaoTest(){
        LocalDate now = LocalDate.now();
        Budget budget = new Budget("budgetForTests");
        Category category = new Category("testCategory", 4f);
        Category anotherCategory = new Category("anotherTestCategory", 3.5f);
        categoryDao.create(category, budget);
        categoryDao.create(anotherCategory, budget);
        Expenditure expenditure1ForCat1 = new Expenditure(category, "a purchase", 4.5f, now);
        Expenditure expenditure2ForCat1 = new Expenditure(category, "a second purchase", 0.5f, now);
        Expenditure expenditure1ForCat2 = new Expenditure(category, "a different purchase", 0.3f,
            now);
        List<Expenditure> firstEmptyQuery = dao.getExpendituresForDay(budget, now.getYear(), now.getMonthValue(),
            now.getDayOfMonth());
        List<Expenditure> secondEmptyQuery = dao.getExpendituresAll(budget);
        dao.createExpenditure(expenditure1ForCat1);
        Expenditure updatedExpenditure = new Expenditure(expenditure1ForCat1.getId(), "updated", 0.0f,
            1, 1, 1, category);
        dao.update(updatedExpenditure, updatedExpenditure.getCategory());
        Expenditure updatedQuery = dao.getExpendituresAll(budget).get(0);
        dao.createExpenditure(expenditure2ForCat1);
        dao.createExpenditure(expenditure1ForCat2);
        List<Expenditure> dayQuery = dao.getExpendituresForDay(budget, now.getYear(), now.getMonthValue(),
            now.getDayOfMonth());
        List<Expenditure> allQuery = dao.getExpendituresAll(budget);
        dao.delete(updatedExpenditure);
        List<Expenditure> postDeleteQuery = dao.getExpendituresAll(budget);

        assertAll("Expenditure DAO tests",
            ()->{assertEquals(0, firstEmptyQuery.size());},
            ()->{assertEquals(0, secondEmptyQuery.size());},
            ()->{assertEquals(2, dayQuery.size());},
            ()->{assertEquals(3, allQuery.size());},
            ()->{assertEquals(updatedExpenditure.getDescription(), updatedQuery.getDescription());},
            ()->{assertEquals(2, postDeleteQuery.size());});
    }
}