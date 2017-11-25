package com.example.wk.lab04.DataAccess.Dao.Interfaces;

import java.util.List;

public interface DaoReadable<T> {
    T getById(int id);
    List<T> getAll();
}
