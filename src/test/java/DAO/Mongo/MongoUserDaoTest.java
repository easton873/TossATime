package DAO.Mongo;

import DAO.UserDao;
import Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MongoUserDaoTest extends MongoDaoTest{
    private UserDao dao;

    @BeforeEach
    void setUp(){
        dao = DatabaseManager.getInstance().createUserDao();
    }

    @Test
    void userDaoTest(){
        User user = new User("easton", "gibson");
        User noUser = dao.getUser("jimmy", "johnson");
        dao.createUser(user);
        User gottenUser = dao.getUser("easton", "gibson");
        User updatedUser = new User(user.getId(), "updated", "stuff");
        dao.updateUser(updatedUser);
        User gottenUpdatedUser = dao.getUser("updated", "stuff");
        dao.deleteUser(user.getId().toString());
        User deletedUser = dao.getUser("updated", "stuff");
        assertAll("Testing the userDAO",
            ()->{assertNull(noUser);},
            ()->{assertEquals(user.getId(), gottenUser.getId());},
            ()->{assertEquals(updatedUser.getUsername(), gottenUpdatedUser.getUsername());},
            ()->{assertNull(deletedUser);});
    }
}