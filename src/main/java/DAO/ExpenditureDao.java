package DAO;

import Model.Budget;
import Model.Category;
import Model.Expenditure;

import java.util.List;

public interface ExpenditureDao {
    void createExpenditure(Expenditure expenditure);
    List<Expenditure> getExpendituresForDay(Budget budget, int year, int month, int day);
    List<Expenditure> getExpendituresAll(Budget budget);
    void delete(Expenditure expenditure);
    void update(Expenditure expenditure, Category category);

}
