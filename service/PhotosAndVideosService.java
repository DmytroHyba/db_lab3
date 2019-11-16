package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementations.PhotosAndVideosDAOImpl;
import ua.lviv.iot.model.PhotosAndVideos;

import java.sql.SQLException;
import java.util.List;

public class PhotosAndVideosService {

    public List<PhotosAndVideos> findAll() throws SQLException {
        return new PhotosAndVideosDAOImpl().findAll();
    }

    public PhotosAndVideos findById(Integer id) throws SQLException {
        return new PhotosAndVideosDAOImpl().findById(id);
    }


    public int create(PhotosAndVideos entity) throws SQLException {
        return new PhotosAndVideosDAOImpl().create(entity);
    }

    public int update(PhotosAndVideos entity) throws SQLException {
        return new PhotosAndVideosDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new PhotosAndVideosDAOImpl().delete(id);
    }
}