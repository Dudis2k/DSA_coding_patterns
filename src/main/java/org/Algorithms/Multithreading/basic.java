package org.Algorithms.Multithreading;

public class basic {
    static void main() throws InterruptedException {
        Thread thread = new Thread(
            ()->{
                System.out.println("We are now in a new Thread! "+Thread.currentThread().getName());
            }
        );
        Thread thread2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("We are now in a new 2nd Thread! "+Thread.currentThread().getName());
                    }
                }
        );
        thread.setName("First Thread");
        thread2.setName("Second Thread");
        System.out.println("This line is Before we started the thread inside "+Thread.currentThread().getName());
        thread.start();
        Thread.sleep(100);
        System.out.println("This line is after thread has started "+Thread.currentThread().getName());
    }
}
