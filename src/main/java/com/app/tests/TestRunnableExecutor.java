package com.app.tests;

import java.io.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TestRunnableExecutor {

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
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(runnable);
    }
}
