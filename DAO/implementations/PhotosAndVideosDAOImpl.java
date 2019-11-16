package ua.lviv.iot.DAO.implementations;

import ua.lviv.iot.DAO.PhotosAndVideosDAO;
import ua.lviv.iot.model.PhotosAndVideos;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhotosAndVideosDAOImpl implements PhotosAndVideosDAO {

    private static final String FIND_ALL = "SELECT * FROM photos_and_videos";
    private static final String DELETE = "DELETE FROM photos_and_videos WHERE id=?";
    private static final String CREATE = "INSERT INTO photos_and_videos (content, size, photo, video) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE photos_and_videos SET content=?, size=?, photo=?, video=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM photos_and_videos WHERE id=?";

    @Override
    public List<PhotosAndVideos> findAll() throws SQLException {
        List<PhotosAndVideos> photosAndVideoss = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String content = resultSet.getString("content");
                String size = resultSet.getString("size");
                Integer photo = resultSet.getInt("photo");
                Integer video = resultSet.getInt("video");
                PhotosAndVideos photosAndVideos = new PhotosAndVideos(id, content, size, photo, video);
                photosAndVideoss.add(photosAndVideos);
            }
        }
        return photosAndVideoss;
    }

    @Override
    public PhotosAndVideos findById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        PhotosAndVideos photosAndVideos = null;
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String content = resultSet.getString("content");
                    String size = resultSet.getString("size");
                    Integer photo = resultSet.getInt("photo");
                    Integer video = resultSet.getInt("video");
                    photosAndVideos = new PhotosAndVideos(id, content, size, photo, video);
                    break;
                }
            }
        }
        return photosAndVideos;
    }

    @Override
    public int create(PhotosAndVideos entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, entity.getContent());
            statement.setString(2, entity.getSize());
            statement.setInt(3, entity.getPhoto());
            statement.setInt(4, entity.getVideo());
            return statement.executeUpdate();
        }
    }

    @Override
    public int update(PhotosAndVideos entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, entity.getContent());
            statement.setString(2, entity.getSize());
            statement.setInt(3, entity.getPhoto());
            statement.setInt(4, entity.getVideo());
            statement.setInt(5, entity.getId());
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