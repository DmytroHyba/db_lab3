package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementations.PostDAOImpl;
import ua.lviv.iot.model.Post;

import java.sql.SQLException;
import java.util.List;

public class PostService {

    public List<Post> findAll() throws SQLException {
        return new PostDAOImpl().findAll();
    }

    public Post findById(Integer id) throws SQLException {
        return new PostDAOImpl().findById(id);
    }


    public int create(Post entity) throws SQLException {
        return new PostDAOImpl().create(entity);
    }

    public int update(Post entity) throws SQLException {
        return new PostDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new PostDAOImpl().delete(id);
    }
}
