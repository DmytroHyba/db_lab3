package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementations.LikeCommentsDAOImpl;
import ua.lviv.iot.model.LikeComments;

import java.sql.SQLException;
import java.util.List;

public class LikeCommentsService {

    public List<LikeComments> findAll() throws SQLException {
        return new LikeCommentsDAOImpl().findAll();
    }

    public LikeComments findById(Integer id) throws SQLException {
        return new LikeCommentsDAOImpl().findById(id);
    }


    public int create(LikeComments entity) throws SQLException {
        return new LikeCommentsDAOImpl().create(entity);
    }

    public int update(LikeComments entity) throws SQLException {
        return new LikeCommentsDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new LikeCommentsDAOImpl().delete(id);
    }
}
