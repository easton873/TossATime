import java.io.*;
import java.net.*;

import DAO.Database;
import Exceptions.DataAccessException;
import Handler.CreateEventHandler;
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

        server.createContext("/createEvent", new CreateEventHandler());

        System.out.println("Starting server");
        server.start();
        System.out.println("Server started");
    }

    public static void main(String[] args) {
        String portNumber = null;
        Database.init();
        try {
            Database.getInstance().createTables();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
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

