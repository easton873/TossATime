import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GsonTest {
    class Jimbo {
        String name = "fred";
        LocalDateTime timeStamp = LocalDateTime.now();
        int number = 5;

        public Jimbo() {
        }
    }
    @Test
    void test(){
        Gson gson = new Gson();
        String json = gson.toJson(new Jimbo());
        System.out.println(json);
    }
}
