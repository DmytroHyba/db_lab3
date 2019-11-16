package ua.lviv.iot.DAO.implementations;

import ua.lviv.iot.DAO.BlockUserDAO;
import ua.lviv.iot.model.BlockUser;
import ua.lviv.iot.persistant.ConnectionManager;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlockUserDAOImpl implements BlockUserDAO {

    private static final String FIND_ALL = "SELECT * FROM block_users";
    private static final String DELETE = "DELETE FROM block_users WHERE id_user=?";
    private static final String CREATE = "INSERT INTO block_users (reason_ban, user_name) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE block_users SET reason_ban=?, user_name=? WHERE id_user=?";
    private static final String FIND_BY_ID = "SELECT * FROM block_users WHERE id_user=?";

    @Override
    public List<BlockUser> findAll() throws SQLException {
        List<BlockUser> blockUsers = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
            while (resultSet.next()) {
                Integer idUser = resultSet.getInt("id_user");
                String reasonBan = resultSet.getString("reason_ban");
                String userName = resultSet.getString("user_name");
                BlockUser blockUser = new BlockUser(idUser, reasonBan, userName);
                blockUsers.add(blockUser);
            }
        }
        return blockUsers;
    }

    @Override
    public BlockUser findById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        BlockUser blockUser = null;
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String reasonBan = resultSet.getString("reason_ban");
                    String userName = resultSet.getString("user_name");
                    blockUser = new BlockUser(id, reasonBan, userName);
                    break;
                }
            }
        }
        return blockUser;
    }

    @Override
    public int create(BlockUser entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, entity.getReasonBan());
            statement.setString(2, entity.getUserName());
            return statement.executeUpdate();
        }
    }

    @Override
    public int update(BlockUser entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, entity.getReasonBan());
            statement.setString(2, entity.getUserName());
            statement.setInt(3, entity.getIdUser());
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
