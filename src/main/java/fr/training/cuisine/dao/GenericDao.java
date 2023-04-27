package fr.training.cuisine.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T, ID> {

    T create(T entity) throws SQLException;

    List<T> findAll();

    T findById(ID id);

    void update(T entity);

    void delete(T entity);
}
