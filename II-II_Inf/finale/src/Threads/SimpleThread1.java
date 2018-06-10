package Threads;

public class SimpleThread1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println(Thread.currentThread().getName());
        MyRunneble myRunneble = new MyRunneble();
        Thread myThread2 = new Thread(myRunneble);
        myThread2.start();

    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    static class MyRunneble implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
