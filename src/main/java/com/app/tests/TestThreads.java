package com.app.tests;

import com.app.runnables.AppThread;

public class TestThreads {

    public static void main(String[] args) {
        AppThread thread1 = new AppThread();
        thread1.setName("Thread 1");
        AppThread thread2 = new AppThread();
        thread2.setName("Thread 2");
        AppThread thread3 = new AppThread();
        thread3.setName("Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
