//package com.gmail.zzmortensen;
//
//import org.openjdk.jmh.annotations.Benchmark;
//import org.openjdk.jmh.annotations.Scope;
//import org.openjdk.jmh.annotations.State;
//import org.openjdk.jmh.infra.Blackhole;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class MyBenchmark {
//
//    @State(Scope.Benchmark)
//    public static class MyState {
//        final private static int MAX = 100_000;
//        public static List<Integer> list = new ArrayList<>(MAX);
//        static {
//            for (int i = 0; i < MAX; i++) {
//                list.add(i);
//            }
//        }
//    }
//
//    @Benchmark
//    public void testLoop(MyState state, Blackhole blackhole) {
//        List<Integer> result = new ArrayList<>(MyState.MAX);
//        for (Integer i : MyState.list) {
//            if (i % 3 == 0) {
//                result.add(i);
//            }
//        }
//        blackhole.consume(result);
//    }
//
//    @Benchmark
//    public void testStream(MyState state, Blackhole blackhole) {
//        blackhole.consume(MyState.list.stream().filter(e -> e % 3 == 0).collect(Collectors.toList()));
//    }
//
//}
