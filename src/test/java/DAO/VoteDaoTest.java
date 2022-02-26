package DAO;

import Model.Vote;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VoteDaoTest {
    private VoteDao voteDao;

    @BeforeEach
    void setUp(){
        Database.init();
        voteDao = new VoteDao();
    }

    @Test
    void test() {
        voteDao.create(new Vote(null, "event_id", "Penelope", "1200", "2", "22", "13"));
        List<Vote> vote = voteDao.readVotes("event_id");
        assertEquals(3, vote.size());
    }
}