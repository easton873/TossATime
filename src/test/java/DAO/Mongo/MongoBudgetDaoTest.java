package DAO.Mongo;

import DAO.BudgetDao;
import Model.Budget;
import Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MongoBudgetDaoTest extends MongoDaoTest {
    private BudgetDao dao;

    @BeforeEach
    void setUp(){
        dao = DatabaseManager.getInstance().createBudgetDao();
    }

    @Test
    void budgetDaoTest(){
        User user = new User("easton", "gibson");
        Budget budget = new Budget("testBudget");
        Budget updatedBudget = new Budget(budget.getBudgetID(), "updatedBudget", budget.getTimestamp());
        dao.insert(budget, user);
        List<Budget> budgets = dao.getBudgets(user);
        dao.update(updatedBudget, user);
        List<Budget> updated = dao.getBudgets(user);
        dao.delete(budget);
        List<Budget> sadBudgets = dao.getBudgets(user);
        assertAll("Testing the budgetDAO",
            ()->{assertEquals(1, budgets.size());},
            ()->{assertEquals(budget.getBudgetID(), budgets.get(0).getBudgetID());},
            ()->{assertEquals(updatedBudget.getName(), updated.get(0).getName());},
            ()->{assertEquals(0, sadBudgets.size());});
    }
}