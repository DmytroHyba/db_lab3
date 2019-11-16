package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementations.UserDAOImpl;
import ua.lviv.iot.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    public List<User> findAll() throws SQLException {
        return new UserDAOImpl().findAll();
    }

    public User findById(Integer id) throws SQLException {
        return new UserDAOImpl().findById(id);
    }


    public int create(User entity) throws SQLException {
        return new UserDAOImpl().create(entity);
    }

    public int update(User entity) throws SQLException {
        return new UserDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new UserDAOImpl().delete(id);
    }
}