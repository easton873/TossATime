package DAO;

import Model.Budget;
import Model.Category;

import java.util.List;

public interface CategoryDao {
    void create(Category category, Budget budget);
    void update(Category category, Budget budget);
    void delete(Category category);
    Category getCategory(Category category);
    List<Category> getCategories(Budget budget);
}
