package ua.lviv.iot.DAO.implementations;

import ua.lviv.iot.DAO.LikeCommentsDAO;
import ua.lviv.iot.model.LikeComments;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LikeCommentsDAOImpl implements LikeCommentsDAO {

    private static final String FIND_ALL = "SELECT * FROM like_comments";
    private static final String DELETE = "DELETE FROM like_comments WHERE id_comments=?";
    private static final String CREATE = "INSERT INTO like_comments (id_user, like_comments) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE like_comments SET id_user=?, like_comments=? WHERE id_comments=?";
    private static final String FIND_BY_ID = "SELECT * FROM like_comments WHERE id_comments=?";

    @Override
    public List<LikeComments> findAll() throws SQLException {
        List<LikeComments> likeCommentss = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
            while (resultSet.next()) {
                Integer idComments = resultSet.getInt("id_comments");
                Integer idUser = resultSet.getInt("id_user");
                Integer likes = resultSet.getInt("like_comments");
                LikeComments likeComments = new LikeComments(idComments, idUser, likes);
                likeCommentss.add(likeComments);
            }
        }
        return likeCommentss;
    }

    @Override
    public LikeComments findById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        LikeComments likeComments = null;
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Integer idUser = resultSet.getInt("id_user");
                    Integer likes = resultSet.getInt("like_comments");
                    likeComments = new LikeComments(id, idUser, likes);
                    break;
                }
            }
        }
        return likeComments;
    }

    @Override
    public int create(LikeComments entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setInt(1, entity.getIdUser());
            statement.setInt(2, entity.getLikeComments());
            return statement.executeUpdate();
        }
    }

    @Override
    public int update(LikeComments entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setInt(1, entity.getIdUser());
            statement.setInt(2, entity.getLikeComments());
            statement.setInt(3, entity.getIdComments());
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