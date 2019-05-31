package com.gmail.zzmortensen;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
    Benchmark                        Mode  Cnt   Score   Error  Units
    MyBenchmark.testLoopArray       thrpt   25  69,191 ± 0,606  ops/s
    MyBenchmark.testLoopLink        thrpt   25  92,106 ± 1,033  ops/s
    MyBenchmark.testStream          thrpt   25  77,637 ± 1,664  ops/s
    MyBenchmark.testStreamParallel  thrpt   25  71,105 ± 1,172  ops/s
 */
public class MyBenchmark {

    @State(Scope.Benchmark)
    public static class MyState {
        final private static int MAX = 1_000_000;
        public static List<Integer> list = new ArrayList<>(MAX);
        static {
            for (int i = 0; i < MAX; i++) {
                list.add(i);
            }
        }
    }

    @Benchmark
    public void testLoopArray(Blackhole blackhole) {
        List<Integer> result = new ArrayList<>(MyState.MAX);
        for (Integer i : MyState.list) {
            if (i % 3 == 0) {
                result.add(i);
            }
        }
        blackhole.consume(result);
    }

    @Benchmark
    public void testLoopLink(Blackhole blackhole) {
        List<Integer> result = new LinkedList<>();
        for (Integer i : MyState.list) {
            if (i % 3 == 0) {
                result.add(i);
            }
        }
        blackhole.consume(result);
    }

    @Benchmark
    public void testStream(Blackhole blackhole) {
        blackhole.consume(MyState.list.stream().filter(e -> e % 3 == 0).collect(Collectors.toList()));
    }

    @Benchmark
    public void testStreamParallel(Blackhole blackhole) {
        blackhole.consume(MyState.list.parallelStream().filter(e -> e % 3 == 0).collect(Collectors.toList()));
    }

}
