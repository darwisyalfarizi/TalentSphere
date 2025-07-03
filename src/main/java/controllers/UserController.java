/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import dao.UserDao;
import java.util.List;
import models.User;


/**
 *
 * @author darwisy
 */
public class UserController {
     private UserDao userDao = new UserDao();

    public static List<User> getAllUsers(){
        return UserDao.getAllUsers();
    }
    
    public List<User> searchUsers(String keyword) {
        return userDao.searchUsers(keyword);
    }

    public boolean insertUser(User user) {
        return userDao.insertUser(user);
    }
    
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
    public boolean deleteUser(int id) {
        return userDao.deleteUser(id);
    }
    public User getUserByUsername(String username) {
        return UserDao.getUserByUsername(username);
    }
    
}
