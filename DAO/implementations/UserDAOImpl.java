package ua.lviv.iot.DAO.implementations;

import ua.lviv.iot.DAO.UserDAO;
import ua.lviv.iot.model.User;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static final String FIND_ALL = "SELECT * FROM users";
    private static final String DELETE = "DELETE FROM users WHERE id_user=?";
    private static final String CREATE = "INSERT INTO users (name, login, url) VALUES (?, ?, ?),";
    private static final String UPDATE = "UPDATE users SET name=?, login=?, url=? WHERE id_user=?";
    private static final String FIND_BY_ID = "SELECT * FROM users WHERE id_user=?";

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
            while (resultSet.next()) {
                Integer idUser = resultSet.getInt("id_user");
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String url = resultSet.getString("url");
                User user = new User(idUser, name, login, url);
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public User findById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String login = resultSet.getString("login");
                    String url = resultSet.getString("url");
                    user = new User(id, name, login, url);
                    break;
                }
            }
        }
        return user;
    }

    @Override
    public int create(User entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getLogin());
            statement.setString(3, entity.getUrl());
            return statement.executeUpdate();
        }
    }

    @Override
    public int update(User entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getLogin());
            statement.setString(3, entity.getUrl());
            statement.setInt(4, entity.getIdUser());
            return statement.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        }
    }
}
