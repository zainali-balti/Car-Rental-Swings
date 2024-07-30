package org.example.mapper;

import org.example.dao.UserDao;
import org.example.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapper implements IMapper<User>{
    //private final UserDao userDao =  new UserDao();
    @Override
    public List<User> getListOfObjects(ResultSet rs) throws SQLException {
        List<User> userList = new ArrayList<>();
        while (rs.next()){
            User user = User.builder()
                    .id(rs.getInt("id"))
                    .userName(rs.getString("uname"))
                    .password(rs.getString("pass"))
                    .confirmPassword(rs.getString("conpass"))
                    .build();
            userList.add(user);
        }
        return userList;
    }

    @Override
    public User getObjects(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return User.builder()
                    .id(rs.getInt("id"))
                    .userName(rs.getString("uname"))
                    .password(rs.getString("pass"))
                    .build();
        }
        return null;
    }
}
