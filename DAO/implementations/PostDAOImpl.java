package ua.lviv.iot.DAO.implementations;

import ua.lviv.iot.DAO.PostDAO;
import ua.lviv.iot.model.Post;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAOImpl implements PostDAO {

    private static final String FIND_ALL = "SELECT * FROM post";
    private static final String DELETE = "DELETE FROM post WHERE id_post=?";
    private static final String CREATE = "INSERT INTO post (date, description, id_user) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE post SET date=?, description=?, id_user=? WHERE id_post=?";
    private static final String FIND_BY_ID = "SELECT * FROM post WHERE id_post=?";

    @Override
    public List<Post> findAll() throws SQLException {
        List<Post> posts = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
            while (resultSet.next()) {
                Integer idPost = resultSet.getInt("id_post");
                Date date = resultSet.getDate("date");
                String description = resultSet.getString("description");
                Integer idUser = resultSet.getInt("id_user");
                Post post = new Post(idPost, idUser, date, description);
                posts.add(post);
            }
        }
        return posts;
    }

    @Override
    public Post findById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Post post = null;
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Date date = resultSet.getDate("date");
                    String description = resultSet.getString("description");
                    Integer idUser = resultSet.getInt("id_user");
                    post = new Post(id, idUser, date, description);
                    break;
                }
            }
        }
        return post;
    }

    @Override
    public int create(Post entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setDate(1, entity.getDate());
            statement.setString(2, entity.getDescription());
            statement.setInt(3, entity.getIdUser());
            return statement.executeUpdate();
        }
    }

    @Override
    public int update(Post entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setDate(1, entity.getDate());
            statement.setString(2, entity.getDescription());
            statement.setInt(3, entity.getIdUser());
            statement.setInt(4, entity.getIdPost());
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