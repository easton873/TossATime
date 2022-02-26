package DAO;

import Model.Budget;
import Model.User;

import java.util.List;


public interface BudgetDao {
    void insert(Budget budget, User user);
    List<Budget> getBudgets(User user);
    void delete(Budget budget);
    void update(Budget budget, User user);
}
