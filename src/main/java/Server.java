import java.io.*;
import java.net.*;

import DAO.Mongo.DatabaseManager;
import DAO.Mongo.MongoDB;
import Handler.*;
import com.sun.net.httpserver.*;

public class Server {

    private static final int MAX_WAITING_CONNECTIONS = 12;
    private HttpServer server;

    private void run(String portNumber) {
        try {
            server = HttpServer.create(
                new InetSocketAddress(Integer.parseInt(portNumber)),
                MAX_WAITING_CONNECTIONS);
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }
        server.setExecutor(null);

        server.createContext("/add-budget", new AddBudgetHandler());
        server.createContext("/add-category", new AddCategoryHandler());
        server.createContext("/add-expenditure", new AddExpenditureHandler());
        server.createContext("/delete-budget", new DeleteBudgetHandler());
        server.createContext("/delete-category", new DeleteCategoryHandler());
        server.createContext("/delete-expenditure", new DeleteExpenditureHandler());
        server.createContext("/get-budgets", new GetBudgetsHandler());
        server.createContext("/get-categories", new GetCategoriesHandler());
        server.createContext("/get-expenditures", new GetExpendituresForDayHandler());
        server.createContext("/login", new LoginHandler());
        server.createContext("/register", new RegisterHandler());
        server.createContext("/update-budget", new UpdateBudgetHandler());

        System.out.println("Starting server");
        server.start();
        System.out.println("Server started");
    }

    public static void main(String[] args) {
        DatabaseManager.getInstance(DatabaseManager.DB_NAME);
        String portNumber = null;
        try {
            portNumber = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No command line args found...");
            System.out.println("Using port 8080 as default");
            portNumber = "8080";
        }
        new Server().run(portNumber);
    }
}

