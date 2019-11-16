package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementations.CommentsPostDAOImpl;
import ua.lviv.iot.model.CommentsPost;

import java.sql.SQLException;
import java.util.List;

public class CommentsPostService {

    public List<CommentsPost> findAll() throws SQLException {
        return new CommentsPostDAOImpl().findAll();
    }

    public CommentsPost findById(Integer id) throws SQLException {
        return new CommentsPostDAOImpl().findById(id);
    }


    public int create(CommentsPost entity) throws SQLException {
        return new CommentsPostDAOImpl().create(entity);
    }

    public int update(CommentsPost entity) throws SQLException {
        return new CommentsPostDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new CommentsPostDAOImpl().delete(id);
    }
}
