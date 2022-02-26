package DAO;

import Exceptions.DataAccessException;

public interface DAO<T> {
    void createTable() throws DataAccessException;
    boolean create() throws DataAccessException;
    T read() throws DataAccessException;
    boolean update() throws DataAccessException;
    boolean delete() throws DataAccessException;
}
