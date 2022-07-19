package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

            private static final Object PRESENT = new Object();
            private transient HashMap<E, Object> map;
            public Collection<? extends E> collection;
          //  int a =  Math.max(16,(int)Math.ceil(collection.size()/.75f) + 1); // колличество эллементов нашей колекции

            public AmigoSet(){ map = new HashMap<>(); }

            public AmigoSet(Collection<? extends E> collection) {
                this.map = new HashMap<>(Math.max(16,(int)Math.ceil(collection.size()/.75f)));
              addAll(collection);
            }
        //----------------------------------------------------------------------------------------------------------------------
            @Override
            public boolean add(E e) { return map.put(e, PRESENT) == null; }
            @Override
            public Iterator<E> iterator() { return map.keySet().iterator(); }
            @Override
            public Object clone()  {
                try {
                    AmigoSet<E> newSet = (AmigoSet<E>) super.clone();
                    newSet.map = (HashMap<E, Object>) map.clone();
                    return newSet;
                } catch (Exception e) {
                    throw new InternalError();
                }
            }
            @Override
            public boolean isEmpty() { return map.isEmpty(); }
            @Override
            public boolean contains(Object o) { return map.containsKey(o); }
            @Override
            public boolean remove(Object o) { return map.remove((E)o) == null; }
            @Override
            public void clear() { map.clear(); }
            @Override
            public int size() { return map.size(); }
        //--------------------------------------Серилизация-------------------------------------------------------------
            private void writeObject (ObjectOutputStream out) throws IOException {
                    out.defaultWriteObject();

//                     out.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
//                     out.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
                out.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
                out.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
                out.writeObject(this.map.size());
               // out.writeInt(map.size());
                        for(E e: this.map.keySet()){
                            out.writeObject(e); }

            //        out.writeInt(map.keySet().size());
            }
    //--------------------------------------десерилизация-------------------------------------------------------------
            private void readObject (ObjectInputStream in) throws IOException, ClassNotFoundException {
                in.defaultReadObject();

                int capacity = in.readInt();
                float loadFactor = in.readFloat();
                map = new HashMap(capacity, loadFactor);
//                E e;
//                while ((e = (E) in.readObject()) != null ){
//                    map.put(e, PRESENT);
//                }

                int size = (int)in.readObject();
//                int size = in.readInt();
                for(int i = 0; i < size; i++) {
                    map.put((E)in.readObject(), PRESENT);
                }

    }
}