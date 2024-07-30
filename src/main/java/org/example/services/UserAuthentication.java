package org.example.services;

import org.example.dao.UserDao;
import org.example.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserAuthentication {

    private final UserDao userDao = new UserDao();
    public boolean checkLogin(String userName,String password){

       User user = userDao.Authentication(userName,password);
       if (user != null){
           return Boolean.TRUE;
       }
       return Boolean.FALSE;

    }
    public void save(String uname,String pass ,String conPass){
        User user = User.builder()
                .userName(uname)
                .password(pass)
                .confirmPassword(conPass)
                .build();
        userDao.insert(user);
    }
    public String[][] searchByName(String name){
        List<User> userList = userDao.getByName(name);
        return getInJTable(userList,4);
    }
    public String[][] getAllUserInJTable(){
        List<User> userList = userDao.getAll();
        return getInJTable(userList,4);
    }

    public String[][] getInJTable(List<User> userList,Integer col){
        String[][] data = new String[userList.size()][col];
        for (int i=0 ; i<userList.size() ; i++){
            data[i][0] = String.valueOf(userList.get(i).getId());
            data[i][1] = userList.get(i).getUserName();
            data[i][2] = userList.get(i).getPassword();
            data[i][3] = userList.get(i).getConfirmPassword();
        }
        return data;
    }
    public void update(Integer id,String uName,String pass,String conPass){
        User user = User.builder()
                .userName(uName)
                .password(pass)
                .confirmPassword(conPass)
                .build();
        userDao.update(user,id);
    }
    public void delete(Integer id){
        userDao.delete(id);
    }

}
