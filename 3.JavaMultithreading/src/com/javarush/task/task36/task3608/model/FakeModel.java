package com.javarush.task.task36.task3608.model;


public class FakeModel implements Model {
//public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }
// такой же метод есть в MainMOdel, возможны конфликты
   /*@Override
    public void loadUsers() {

        modelData.getUsers().add(new User("A", 1, 1));
        modelData.getUsers().add(new User("B", 2, 1));
    }*/

    public void loadUsers() {
        throw new UnsupportedOperationException();
    }
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }
    public void loadUserById(long userId){throw new UnsupportedOperationException(); }
    public void deleteUserById(long id) {throw new UnsupportedOperationException();}
    public void changeUserData(String name, long id, int level) {throw new UnsupportedOperationException();}
}

