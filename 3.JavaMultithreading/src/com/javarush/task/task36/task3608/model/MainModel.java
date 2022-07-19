package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {

   // private List<User> allUsers = new ArrayList<>();

    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    public ModelData getModelData() { return modelData;  }

    ///----------------------------
    private List<User> getAllUsers() {return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));} // 10.09.20
   ///-------------------------------

    // загрузка пользователей model.loadUsers(); происходит в сервисе
    @Override
    public void loadUsers() {
        //modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
       modelData.setUsers(getAllUsers());
       modelData.setDisplayDeletedUserList(false);  }

    // стирание пользователей происходит в сервисе
    public void loadDeletedUsers() {
        //-------------- или так или так
       // modelData.setUsers(getAllUsers());
         modelData.setUsers(userService.getAllDeletedUsers());
         modelData.setDisplayDeletedUserList(true); }

    // получения пользователя по id из сервиса
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user); }

    public void deleteUserById(long id){
       User user = userService.deleteUser(id);
       //modelData.setActiveUser( userService.deleteUser(id));
       modelData.setUsers(getAllUsers()); }

    public void changeUserData(String name, long id, int level) {
        modelData.setUser(userService.createOrUpdateUser(name, id, level));
      //  modelData.setActiveUser( userService.createOrUpdateUser(name, id, level));
        modelData.setUsers(getAllUsers());
    }
}
