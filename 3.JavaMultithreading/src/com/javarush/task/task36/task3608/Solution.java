package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        editUserView.setController(controller); ///------------ 19:37 10.09.20
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);


        usersView.fireEventShowAllUsers();
        editUserView.fireEventOpenUserEditForm(126L); ///???
       // usersView.fireEventOpenUserEditForm(126L);

        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Jonson", 123L, 1 );
        usersView.fireEventShowDeletedUsers();


    }
}