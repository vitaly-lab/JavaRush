package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

// ModelData - это объект, который будет хранить необходимые данные для отображения на клиенте.
//Создай поле с геттером и сеттером List<User> users - это будет список пользователей для отображения.

public class ModelData {

   private List<User> users = new ArrayList<>();

     // private  List<User> allUsers = new ArrayList<>();
     private User user = new User();

    private User activeUser = new User();
   // private User activeUser;
    private boolean displayDeletedUserList = true;

    // getUsers для заполения коллекции users
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setUser(User user) { this.user = user; }

    public User getActiveUser() { return activeUser; }
    public void setActiveUser(User activeUser) { this.activeUser = activeUser; }


    public boolean isDisplayDeletedUserList() {return displayDeletedUserList; }
    public void setDisplayDeletedUserList(boolean displayDeletedUserList) { this.displayDeletedUserList = displayDeletedUserList; }

}
