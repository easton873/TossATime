package Exceptions;

public class DataAccessException extends Exception {
    public DataAccessException(String message)
    {
        super("Error: " + message);
    }

    public DataAccessException()
    {
        super();
    }
}
