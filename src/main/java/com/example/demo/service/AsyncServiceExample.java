package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> serviceA = CompletableFuture.supplyAsync(AsyncServiceExample::callService);
        CompletableFuture<Integer> serviceB = CompletableFuture.supplyAsync(AsyncServiceExample::callServiceB);
        CompletableFuture<List<String>> serviceC = CompletableFuture.supplyAsync(AsyncServiceExample::callServiceC);

        CompletableFuture<Void> allOf = CompletableFuture.allOf(serviceA, serviceB, serviceC);
        CompletableFuture<String> finalResult = allOf.thenApply(
                v -> {
                    try {
                        String resultA = serviceA.get();
                        Integer resultB = serviceB.get();
                        List<String> resultc = serviceC.get();
                        return "Summary: A= " + resultA + " " + "B= " + resultB + " " + "C= " + resultc.size();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException("Exception", e);
                    }
                });
        System.out.println("Output\n" + finalResult.get());
    }

    private static String callService() {
        return "Service A";
    }

    private static Integer callServiceB() {
        return 42;
    }

    private static List<String> callServiceC() {
        return Arrays.asList("A", "B", "C", "D", "E");
    }
}