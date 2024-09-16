package org.example.main.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repository <T> {
    // Tipo generico de datos a usar, diferentes tipos de datos
    List<T> findAll() throws SQLException;//leer datos

    T getById(Integer id) throws SQLException;//leemos dato

    void save(T t) throws SQLException;

    void delete(Integer id) throws SQLException;

}
