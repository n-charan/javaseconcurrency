package com.app.tests;

import java.io.*;

public class TestRunnable {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try(BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\STUDY\\Workspace\\Java Learning WS\\javaseconcurrency\\documents\\sample.txt")))) {
                String line = null;
                while((line = reader.readLine())!=null) {
                    System.out.println(Thread.currentThread().getName() + ": reading the line: " + line);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread = new Thread(runnable);
        System.out.println("Thread state is : " + thread.getState());
        thread.start();
        System.out.println("Thread state is : " + thread.getState());
    }
}
