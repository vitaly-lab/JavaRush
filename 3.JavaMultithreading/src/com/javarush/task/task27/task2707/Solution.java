package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
/*
Нитка #1 запускается, лочит obj1 и засыпает.
        Делаем небольшую паузу, чтобы первая нитка гарантированно отработала свою задачу.
        Город засыпает, просыпается мафия вторая нитка кродется с проверяемым методом и двумя объектами синхронизации,
         и пытается их залочить.
        Дальше два варианта:
        - первый объект у нее тот же obj1, она в него упирается и ничего не делает
        - первый объект у нее obj2, она его лочит и только потом упирается в obj1.
        В результате имеем obj1 гарантированно залочен еще первой ниткой,
        а вот obj2 может быть как занят так и свободен, в зависимости от очередности в тестируемом методе.
        Это и предстоит проверить ните #3.
        Она запускается и что-то делает синхронизируясь по obj2.
        Если obj2 свободен - то это действие произойдет сразу.
        Если занят - ей придется дождаться пока первая нить проснется, освободит obj1, потом нить
        #2 сможет сделать свои дела на обоих объектах, и уж потом выполнится блок syncronized нити #3.
        Проверив очередность выполнения мы узнаем в каком состоянии был obj2 к подходу третий нити,
        а значит очередность блокировки у нити с тестируемым методом.
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        new Thread(() -> {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) { e.printStackTrace();}
                    synchronized (o2) { }
                }
        }).start();

        Thread thread = new Thread(() -> solution.someMethodWithSynchronizedBlocks(o1, o2));
        thread.start();

        Thread.sleep(2000);
        if (thread.getState() != Thread.State.BLOCKED) {
            return true;

        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
