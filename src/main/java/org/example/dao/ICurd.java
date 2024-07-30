package org.example.dao;

import java.util.List;

public interface ICurd<T> {
    void insert(T obj);
    List<T> getAll();
    T getById(long id);
    void update(T obj,long id);
    void delete(long id);

}
