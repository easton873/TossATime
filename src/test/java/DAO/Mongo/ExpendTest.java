package DAO.Mongo;

import DAO.ExpenditureDao;
import Model.Budget;
import Model.Expenditure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ExpendTest {
    @Test
    void anotherTest(){
        DatabaseManager.getInstance();
        ExpenditureDao dao = DatabaseManager.getInstance().createExpenditureDao();
        List<Expenditure> stuff = dao.getExpendituresForDay(
            new Budget(UUID.fromString("81a8ccfa-5bb7-4d5b-87a7-0e2e75874f70"), "e", LocalDateTime.now()),
            2021, 12, 15);
        Assertions.assertEquals(1, stuff.size());
    }
}
