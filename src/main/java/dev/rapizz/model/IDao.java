package dev.rapizz.model;

import dev.rapizz.Connection;

public interface IDao<T> {
    java.sql.Connection connect = Connection.getInstance();
    T findById(T obj);
    T findByName(T obj);
    T save(T obj);
    T update(T obj, String[] params);
    void delete(T obj);
}
