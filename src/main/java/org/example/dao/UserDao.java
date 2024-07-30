package org.example.dao;

import org.example.domain.User;
import org.example.mapper.IMapper;
import org.example.mapper.UserMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDao extends BaseDao implements ICurd<User> {

    private final IMapper<User> userMapper = new UserMapper();
    public User Authentication(String userName,String password){
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.USER_AUTHENTICATION);
            ps.setString(1,userName);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            return userMapper.getObjects(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void insert(User obj) {

        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.NEW_USER_INSERT);
            ps.setString(1,obj.getUserName());
            ps.setString(2,obj.getPassword());
            ps.setString(3,obj.getConfirmPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<User> getAll() {

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SqlQueriesConstant.NEW_USER_GET_ALL);
            return userMapper.getListOfObjects(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getById(long id) {
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.NEW_USER_GET_BY_ID);
            ps.setInt(1, (int) id);
            ResultSet rs = ps.executeQuery();
            userMapper.getObjects(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void update(User obj, long id) {

        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.NEW_USER_UPDATE);
            ps.setString(1,obj.getUserName());
            ps.setString(2,obj.getPassword());
            ps.setString(3,obj.getConfirmPassword());
            ps.setInt(4, (int) id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(long id) {
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.NEW_USER_DELETE);
            ps.setInt(1, (int) id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<User> getByName(String name){
        try {
            PreparedStatement ps = con.prepareStatement(SqlQueriesConstant.NEW_USER_GET_BY_NAME);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            return userMapper.getListOfObjects(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
