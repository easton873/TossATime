package DAO.Mongo;
import DAO.CategoryDao;
import Model.Budget;
import Model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MongoCategoryDaoTest extends MongoDaoTest{
    private CategoryDao dao;

    @BeforeEach
    void setUp(){
        dao = DatabaseManager.getInstance().createCategoryDao();
    }

    @Test
    void categoryDaoTest(){
        Budget budget = new Budget("testBudget");
        Category category = new Category("thing", 5.0f);
        Category anotherCategory = new Category("another", 31.8f);
        Category updatedCategory = new Category(category.getId(), "updatedName", 0.0f);
        Category noCategory = dao.getCategory(category);
        dao.create(category, budget);
        dao.create(anotherCategory, budget);
        Category firstQuery = dao.getCategory(category);
        List<Category> categories = dao.getCategories(budget);
        dao.update(updatedCategory, budget);
        Category updatedQuery = dao.getCategory(updatedCategory);
        dao.delete(updatedCategory);
        Category deletedQuery = dao.getCategory(updatedCategory);
        assertAll("Category dao tests",
            ()->{assertNull(noCategory);},
            ()->{assertEquals(category.getName(), firstQuery.getName());},
            ()->{assertEquals(2, categories.size());},
            ()->{assertEquals(updatedCategory.getName(), updatedQuery.getName());},
            ()->{assertEquals(updatedCategory.getAllotment(), updatedQuery.getAllotment());},
            ()->{assertNull(deletedQuery);});
    }
}