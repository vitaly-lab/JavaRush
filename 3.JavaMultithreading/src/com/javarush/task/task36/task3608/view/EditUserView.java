package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

public class EditUserView implements View{

    private Controller controller;
    public void setController(Controller controller) {
        this.controller = controller; }

    private UserService userService = new UserServiceImpl();


    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:");
        User user = modelData.getActiveUser();
            System.out.println("\t" + user);
        System.out.println("===================================================");
    }

  public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);  }

    public void fireEventUserDeleted(long id){
        controller.onUserDelete(id);     }

    public void fireEventUserChanged(String name, long id, int level) {
        controller.onUserChange(name, id, level);
    }


}
