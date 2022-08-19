package com.app.tests;

import com.app.runnables.LoggingProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestOtherAPIs {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Callable<Boolean>> callables = new ArrayList<>();
        try {
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());

            List<Future<Boolean>> futures = service.invokeAll(callables);
            for (Future<Boolean> future : futures) {
                System.out.println("Operation result " + future.get());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n\n\n");

        try {
            System.out.println(service.invokeAny(callables));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        service.shutdown();
        try {
            System.out.println("service shutdown? : " + service.awaitTermination(30, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            service.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
