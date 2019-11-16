package ua.lviv.iot.DAO;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

public interface GeneralDAO<Entity> {
    List<Entity> findAll() throws SQLException;

    Entity findById(Integer id) throws SQLException;

    int create(Entity entity) throws SQLException;

    int update(Entity entity) throws SQLException;

    int delete(Integer id) throws SQLException;
}
