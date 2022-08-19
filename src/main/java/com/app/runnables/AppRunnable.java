package com.app.runnables;

import java.io.*;

public class AppRunnable implements Runnable {

    @Override
    public void run() {
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
    }
}
