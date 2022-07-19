package com.javarush.task.task17.task1713;

import java.util.*;


public class Solution implements List<Long>{
    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {

        Solution original = new Solution();

    }

    @Override
    public synchronized int size() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.size();
    }


    @Override
    public synchronized boolean isEmpty() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.contains(o);
    }

    @Override
    public synchronized Iterator<Long> iterator() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.iterator();
    }

    @Override
    public synchronized Object[] toArray() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.toArray();
    }

    @Override
    public synchronized <T> T[] toArray(T[] a) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.toArray(a);
    }

    @Override
    public synchronized boolean add(Long e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.add(e);
    }

    @Override
    public synchronized boolean remove(Object o) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.remove(o);
    }

    @Override
    public synchronized boolean containsAll(Collection<?> c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.containsAll(c);

    }

    @Override
    public synchronized boolean addAll(Collection<? extends Long> c) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.addAll(c);
    }
    @Override
    public synchronized boolean addAll(int index, Collection<? extends Long> c) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.addAll(index, c);
    }

    @Override
    public synchronized boolean removeAll(Collection<?> c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.removeAll(c);
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.retainAll(c);
    }

    @Override
    public synchronized void clear() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        original.clear();
    }

    @Override
    public synchronized Long get(int index) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.get(index);
    }

    @Override
    public synchronized Long set(int index, Long element) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.set(index, element);
    }

    @Override
    public synchronized void add(int index, Long element) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        original.add(index, element);
    }

    @Override
    public synchronized Long remove(int index) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.remove(index);
    }

    @Override
    public synchronized int indexOf(Object o) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.indexOf(o);
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.lastIndexOf(o);
    }

    @Override
    public synchronized ListIterator<Long> listIterator() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.listIterator();
    }

    @Override
    public synchronized ListIterator<Long> listIterator(int index) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.listIterator(index);
    }

    @Override
    public synchronized List<Long> subList(int fromIndex, int toIndex) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return original.subList(fromIndex, toIndex);
    }
}

