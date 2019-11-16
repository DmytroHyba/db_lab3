package ua.lviv.iot.DAO.implementations;

import ua.lviv.iot.DAO.CommentsPostDAO;
import ua.lviv.iot.model.CommentsPost;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentsPostDAOImpl implements CommentsPostDAO {

    private static final String FIND_ALL = "SELECT * FROM comments_post";
    private static final String DELETE = "DELETE FROM comments_post WHERE id_comment_post=?";
    private static final String CREATE = "INSERT INTO comments_post (text, date) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE comments_post SET text=?, date=? WHERE id_comment_post=?";
    private static final String FIND_BY_ID = "SELECT * FROM comments_post WHERE id_comment_post=?";

    @Override
    public List<CommentsPost> findAll() throws SQLException {
        List<CommentsPost> commentsPosts = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
            while (resultSet.next()) {
                Integer idCommentsPost = resultSet.getInt("id_comment_post");
                String text = resultSet.getString("text");
                Date date = resultSet.getDate("date");
                CommentsPost commentsPost = new CommentsPost(idCommentsPost, text, date);
                commentsPosts.add(commentsPost);
            }
        }
        return commentsPosts;
    }

    @Override
    public CommentsPost findById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        CommentsPost commentsPost = null;
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String text = resultSet.getString("text");
                    Date date = resultSet.getDate("date");
                    commentsPost = new CommentsPost(id, text, date);
                    break;
                }
            }
        }
        return commentsPost;
    }

    @Override
    public int create(CommentsPost entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, entity.getText());
            statement.setDate(2, entity.getDate());
            return statement.executeUpdate();
        }
    }

    @Override
    public int update(CommentsPost entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, entity.getText());
            statement.setDate(2, entity.getDate());
            statement.setInt(3, entity.getIdCommentsPost());
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
