package org.example.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelTest {


    @Test
    @DisplayName("parallel stream zip 여부")
        // O , it zips
    void test() {

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);

        integers.parallelStream().forEach(System.out::println);

        System.out.println("DONE");

    }

    @Test
    @DisplayName("parallel stream exception zip 여부")
    void testP(){

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7,8,9,10,11,12,13,14,15);

        integers.parallelStream().forEach(integer -> System.out.println(this.foo2(integer)));

        System.out.println("DONE");

    }

    int foo2(int a){
        if(a==2){
            throw new RuntimeException();
        }

        return a;
    }

    @Test
    @DisplayName("parallel stream with size (ForkJoinPool)")
    void test2() throws ExecutionException, InterruptedException {

        List<Integer> integers = IntStream.rangeClosed(1, 15).boxed().collect(Collectors.toList());

        ForkJoinPool customThreadPool = new ForkJoinPool(5);

        customThreadPool.submit(() -> {
                    integers.parallelStream().forEach(integer -> {
                                System.out.println("Thread : " + Thread.currentThread().getName() + ", int : " + integer + ", " + new Date());
                                try {
                                    Thread.sleep(5000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                }).get();

        System.out.println("DONE");

    }

    @Test
    @DisplayName("ForkJoinPool zips") // O
    void test3() throws ExecutionException, InterruptedException {

        List<Integer> integers = IntStream.rangeClosed(1, 15).boxed().collect(Collectors.toList());

        ForkJoinPool customThreadPool = new ForkJoinPool();

        customThreadPool.submit(() -> {
            integers.parallelStream().forEach(integer -> {
                System.out.println("int : " + integer);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }).get();

        System.out.println("DONE");

    }

    @Test
    @DisplayName("if someone throws exception, does it zip 정상적으로?")
    void test4() throws ExecutionException, InterruptedException {

        List<Integer> integers = IntStream.rangeClosed(1, 15).boxed().collect(Collectors.toList());

        ForkJoinPool customThreadPool = new ForkJoinPool(5);

        customThreadPool.submit(() -> {
            integers.parallelStream().forEach(integer -> {

                if(integer.equals(3)){
                    throw new RuntimeException();
                }

                System.out.println("Thread : " + Thread.currentThread().getName() + ", int : " + foo(integer) + ", " + new Date());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }).get();


        System.out.println("DONE");

    }

    @Test
    @DisplayName("Handling exception when using ForkJoinPool")
    void test5(){
        final int poolSize = 5;

        List<Integer> integers = IntStream.rangeClosed(1, 15).boxed().collect(Collectors.toList());

        ForkJoinPool customThreadPool = new ForkJoinPool(poolSize);

        customThreadPool.execute(() -> {
            integers.parallelStream().forEach(integer -> {
                System.out.println("Thread : " + Thread.currentThread().getName() + ", int : " + integer + ", " + new Date());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });



    }


    // he throws exception when it excepted 3
    public Integer foo(Integer integer){
        if(integer.equals(3)){
            System.out.println("here");
            throw new RuntimeException("아아악");
        }

        return integer;
    }

    @Test
    @DisplayName("thread-safe collection 사용 후기")
    void test6() throws ExecutionException, InterruptedException {
        /**
         * 하고자하는것은, Collection에 여러 thread에서 각 data insert하기.
         */
        List<Integer> integers = IntStream.rangeClosed(1, 1000).boxed().collect(Collectors.toList());



        final int poolSize = 1000;
        ForkJoinPool customPool = new ForkJoinPool(poolSize);
        List<Integer> result = new CopyOnWriteArrayList<>();

        customPool.submit(() -> {
            integers.parallelStream().forEach(integer -> {

                result.add(integer);


            });
        }).get();

        System.out.println(result.size());

    }

    public String getA() throws InterruptedException {
        System.out.println("Thread : " + Thread.currentThread().getName() + " date : " + new Date());
        System.out.println("getA() called...");
        System.out.println("start thread sleep");
        Thread.sleep(5000);
        System.out.println("thread sleep done");
        return "A";
    }

    public String getB(){
        System.out.println("Thread : " + Thread.currentThread().getName() + " date : " + new Date());

        System.out.println("getB() called...");
        return "B";
    }

    public String getC(){
        System.out.println("Thread : " + Thread.currentThread().getName() + " date : " + new Date());

        System.out.println("getC() called...");
        return null;
    }

    public String getD(){
        System.out.println("Thread : " + Thread.currentThread().getName() + " date : " + new Date());

        System.out.println("getD() called...");
        return "D";
    }

    public String getE(){
        System.out.println("Thread : " + Thread.currentThread().getName() + " date : " + new Date());

        System.out.println("getE() called...");
        return "E";
    }

    @Test
    @DisplayName("Future 사용 후기")
    void test10() throws InterruptedException {
        Callable<String> getACallable = this::getA;

        ForkJoinPool customForkJoinPool = new ForkJoinPool(5);
        ForkJoinTask<String> likeFuture = customForkJoinPool.submit(getACallable);
        System.out.println("main    " + "Thread : " + Thread.currentThread().getName() + " date : " + new Date());
        String joined = likeFuture.join();
        Thread.sleep(5000);

        System.out.println(joined);
    }

    @Test
    @DisplayName("CompletableFuture 사용 후기")
    void test11() throws InterruptedException {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                return getA();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.sleep(10000);


        String join = future1.join();
        System.out.println("hey");


    }
}

