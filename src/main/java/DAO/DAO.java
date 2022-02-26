package DAO;

import Exceptions.DataAccessException;

import java.util.UUID;

public interface DAO<T> {
    void createTable();
    boolean create(T obj);
    T read(String id);
    boolean update();
    boolean delete();
}
