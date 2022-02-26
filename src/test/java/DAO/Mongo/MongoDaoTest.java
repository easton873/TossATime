package DAO.Mongo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class MongoDaoTest {
    @BeforeAll
    public static void startUp(){
        DatabaseManager.getInstance("smartbudget_test");
    }
}
