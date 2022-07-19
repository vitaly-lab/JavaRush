package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

public class UsersView implements View {

    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller; }

    private UserService userService = new UserServiceImpl();


    @Override
    public void refresh(ModelData modelData) {
        if (modelData.isDisplayDeletedUserList()) { System.out.println("All deleted users:");
            for (User user : modelData.getUsers()) {
                System.out.println("\t" + user);  }
            System.out.println("===================================================");
        }
        else {
            System.out.println("All users:");
            for (User user : modelData.getUsers()) {
                System.out.println("\t" + user);  }
            System.out.println("===================================================");}
    }
// загрузка пользователй model.loadUsers(); происходит в сервисе
    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();  }

// стирание пользователей происходит в сервисе
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();  }

}