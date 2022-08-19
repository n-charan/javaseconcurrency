package com.app.runnables;

import java.io.File;
import java.io.FileReader;

public class CleaningScheduler implements Runnable {

    @Override
    public void run() {
        File folder = new File("D:\\STUDY\\Workspace\\Java Learning WS\\javaseconcurrency\\folder");
        File[] files = folder.listFiles();

        for (File file : files) {
            if (System.currentTimeMillis()-file.lastModified() > 2*60*1000) {
                System.out.println("This file will be delete " + file.getName());
                //file.delete();
            }
        }
    }
}
