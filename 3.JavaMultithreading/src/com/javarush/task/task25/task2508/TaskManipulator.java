package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread th = new Thread();
//   String threadName;

 //   public TaskManipulator(String threadName) {
 //   this.threadName = threadName; }
 //   public TaskManipulator(TaskManipulator taskManipulator, String threadName){}

    public void run() {

      while (!th.isInterrupted()) {
          System.out.println(th.getName());
        try {
           Thread.sleep(100);
         } catch (InterruptedException e) {
            //   e.printStackTrace();
              th.interrupt();
         break;
        }
       }
    }
    @Override
    public void start(String threadName)  {
       // th = new Thread(new TaskManipulator(this, threadName));
        th = new Thread(this, threadName);
        th.start();

    }
    @Override
    public void stop() {
        th.interrupt();
        }
}
