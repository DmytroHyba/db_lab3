package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementations.BlockUserDAOImpl;
import ua.lviv.iot.model.BlockUser;

import java.sql.SQLException;
import java.util.List;

public class BlockUserService {

    public List<BlockUser> findAll() throws SQLException {
        return new BlockUserDAOImpl().findAll();
    }

    public BlockUser findById(Integer id) throws SQLException {
        return new BlockUserDAOImpl().findById(id);
    }


    public int create(BlockUser entity) throws SQLException {
        return new BlockUserDAOImpl().create(entity);
    }

    public int update(BlockUser entity) throws SQLException {
        return new BlockUserDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new BlockUserDAOImpl().delete(id);
    }
}
