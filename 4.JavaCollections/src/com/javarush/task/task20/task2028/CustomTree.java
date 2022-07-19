package com.javarush.task.task20.task2028;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{
        List <Entry <String>> treeList = new ArrayList<>();
        Entry<String> root;
        int size;
                 CustomTree() {
                         this.root = new Entry<String>("0");
                         treeList.add(root);
                     }
    static class Entry <T> implements Serializable {
            String elementName;
            boolean availableToAddLeftChildren;
            boolean availableToAddRightChildren;
            Entry<T> parent;
            Entry<T> leftChild;
            Entry<T> rightChild;

            public Entry(String elementName) {
                this.elementName = elementName;
                availableToAddLeftChildren = true;
                availableToAddRightChildren =true;
            }

            boolean isAvailableToAddChildren () {return availableToAddLeftChildren || availableToAddRightChildren;}

        public void isAvailableToBeParent(Entry<T> element) {
            element.availableToAddLeftChildren = true;
            element.availableToAddRightChildren = true; }
        }
        @Override
        public boolean remove (Object o){
                     if (o instanceof String){
                         for (int i = 1; i < treeList.size() ; i++) {
                             Entry<String> p = treeList.get(i);
                             if (p.elementName.equals(o)) {
                                 removeReal(p);
                                 return true;
                             }
                         }
                         return false;

          } else throw new UnsupportedOperationException();
         }

    private void removeReal (Entry<String> element) {
                         if (element.leftChild != null || element.rightChild != null){

                             if (element.leftChild != null){
                                 removeReal(element.leftChild);
                                 element.leftChild = null;
                             element.parent.leftChild = null;}

                              if (element.rightChild != null){
                                  removeReal(element.rightChild);
                                  element.rightChild = null;
                              element.parent.leftChild = null;}
                     }
                         treeList.remove(element);
        element.parent.isAvailableToBeParent(element.parent);
                         size--;
                 }


        @Override
        public boolean add (String s) {

                Entry<String> entry = new Entry<>(s); // создаем новый узел дерева
                Entry<String> p; // в переменной p будет хранить родительский узел (p = parent я так понимаю)


            for (int i = 0; i < treeList.size(); i++) { // перебираем список узлов
                p = treeList.get(i); // в p (parent) кладем текущий узел

                if (p.isAvailableToAddChildren()){ // проверяем можно ли добавлять дочерние узлы
                    if (p.availableToAddLeftChildren) { // тут проверяем, что доступно левая ветка для добавления
                        p.availableToAddLeftChildren = false; // если доступна, то меняем флаг, что теперь занята
                        p.leftChild = entry; // у родителя в левый дочерний узел помещаем новый узел entry(s)
                        entry.parent = p; // у узла entry указываем, что для него родитель узел p
                        treeList.add(entry); // добавляем в список новый узел.
                        size++; // увеличиваем размер дерева на один
                        return true; // возвращаем true, что добавление прошло успешно
                    }
                    else if(p.availableToAddRightChildren){
                        p.availableToAddRightChildren = false;
                        p.rightChild = entry;
                        entry.parent = p;
                        treeList.add(entry);
                        size++;
                        return true; }
                }
            }
               return false;
        }

        public String getParent (String e) {
            for (int i = 0; i < treeList.size(); i++) {
                if (treeList.get(i).elementName.equals(e)) { return treeList.get(i).parent.elementName; }
            }  return null;
        }
    @Override
    public int size() {
        return size;
    }
    @Override
    public String get(int index) {throw new UnsupportedOperationException();}
    @Override
    public String set(int index, String element) {throw new UnsupportedOperationException();}
    @Override
    public void add(int index, String element) {throw new UnsupportedOperationException();}
    @Override
    public String remove(int index) {throw new UnsupportedOperationException();}
    public List<String> subList(int fromIndex, int toIndex) {throw new UnsupportedOperationException();}
    @Override
    protected void removeRange(int fromIndex, int toIndex) {throw new UnsupportedOperationException();}
    @Override
    public boolean addAll(int index, Collection<? extends String> c) {throw new UnsupportedOperationException();}
}
