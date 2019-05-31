package com.gmail.zzmortensen;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/*
    Benchmark                        Mode  Cnt   Score   Error  Units
    MyBenchmark.testLoopArray       thrpt   25  69,191 ± 0,606  ops/s
    MyBenchmark.testLoopLink        thrpt   25  92,106 ± 1,033  ops/s
    MyBenchmark.testStream          thrpt   25  77,637 ± 1,664  ops/s
    MyBenchmark.testStreamParallel  thrpt   25  71,105 ± 1,172  ops/s
 */
public class MyBenchmark {

//    @State(Scope.Benchmark)
//    public static class MyState {
//        final private static int MAX = 1_000_000;
//        static List<Integer> list = new ArrayList<>(MAX);
//
//        static {
//            for (int i = 0; i < MAX; i++) {
//                list.add(i);
//            }
//        }
//    }
//
//    @Benchmark
//    public List<Integer> testLoopArray() {
//        List<Integer> result = new ArrayList<>(MyState.MAX);
//        for (Integer i : MyState.list) {
//            if (i % 3 == 0) {
//                result.add(i);
//            }
//        }
//        return result;
//    }
//
//    @Benchmark
//    public List<Integer> testLoopLink() {
//        List<Integer> result = new LinkedList<>();
//        for (Integer i : MyState.list) {
//            if (i % 3 == 0) {
//                result.add(i);
//            }
//        }
//        return result;
//    }
//
//    @Benchmark
//    public List<Integer> testStream() {
//        return MyState.list.stream().filter(e -> e % 3 == 0).collect(Collectors.toList());
//    }
//
//    @Benchmark
//    public List<Integer> testStreamParallel() {
//        return MyState.list.parallelStream().filter(e -> e % 3 == 0).collect(Collectors.toList());
//    }

    /*
        Benchmark                 Mode  Cnt          Score         Error  Units
        MyBenchmark.testModulus  thrpt   25   57031120,435 ±  997970,505  ops/s
        MyBenchmark.testBitAnd   thrpt   25  153153904,696 ± 7351160,291  ops/s
     */
    @Benchmark
    public boolean testModulus() {
        return ThreadLocalRandom.current().nextInt() % 2 == 0;
    }

    @Benchmark
    public boolean testBitAnd() {
        return (ThreadLocalRandom.current().nextInt() & 1) == 0;
    }
}
