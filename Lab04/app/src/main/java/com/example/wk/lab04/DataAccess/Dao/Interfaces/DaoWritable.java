package com.example.wk.lab04.DataAccess.Dao.Interfaces;

public interface DaoWritable<T> {
    void save(T obj);
    void update(T obj);
    void delete(T obj);
}
