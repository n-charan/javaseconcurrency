package com.app.tests;

import com.app.dao.UserDao;
import com.app.runnables.UserProcessor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestExecutors {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        String fileName = "D:\\STUDY\\Workspace\\Java Learning WS\\javaseconcurrency\\documents\\new_users.txt";
        List<String> users = getUsersFromFile(fileName);
        UserDao dao = new UserDao();
        for (String user : users) {
            Future<Integer> future = service.submit(new UserProcessor(user, dao));
            /*try {
                System.out.println("Result of the opertion is : " + future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }*/
        }
        service.shutdown();
        System.out.println("Main execution over!");
    }

    public static List<String> getUsersFromFile(String fileName) {
        List<String> users = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line = null;
            while((line = reader.readLine())!=null) {
                users.add(line);
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, e);
        }
        return users;
    }
}
